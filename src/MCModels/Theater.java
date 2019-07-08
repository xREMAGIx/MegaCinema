/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Theater {

    private int id;
    private int cinemaID;
    private int managerID;
    private String name;
    private int rowCount;
    private int colCount;
    private int status;

    public Theater(int id, int cinemaID, int managerID, String name, int status) {
        this.id = id;
        this.cinemaID = cinemaID;
        this.managerID = managerID;
        this.name = name;
        this.status = status;
    }

    public Theater() {
    }

    public int getId() {
        return id;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public ArrayList<Theater> loadTheaters() {
        String sql = " ";
        ResultSet rs = null;

        Database db = new Database();
        ArrayList<Theater> temp = new ArrayList<>();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst;

            try {
                sql = "SELECT * FROM theater";
                pst = con.prepareStatement(sql);

                rs = pst.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("theaterId");
                    //int cinemaID = rs.getInt("idcenema");
                    //int manaID = rs.getInt("idmana");
                    String name = rs.getString("theaterName");
                    //int gen = rs.getInt("status");

                    Theater t = new Theater(id, NULL, NULL, name, NULL);
                    //Theater t = new Theater (id, cinemaID, manaID, name, gen);
                    temp.add(t);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            Theater[] array = temp.toArray(new Theater[temp.size()]);

        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;

    }

    public int insert(Theater theater) {
        try {
            String sqlstr = "insert into theater( theaterName, theaterRowCount, theaterColCount, theaterStatus ) values( '"
                    + theater.getName() + "', " + theater.getRowCount() + ", " + theater.getColCount() + ", 1 )";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                theater.setId(rst.getInt(1));
                createSeats(theater);
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int update(Theater theater) {
        int rtn = 0;
        try {
            String sqlstr = "update theater set theaterName = '" + theater.getName() + "', theaterRowCount = "
                    + theater.getRowCount() + ", theaterColCount = " + theater.getColCount()
                    + "', theaterStatus = " + theater.getStatus();
            sqlstr += " where theaterId = " + theater.getId();
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int delete(int id) {
        int rtn = 0;
        Theater theater = new Theater();
        theater.setId(id);
        theater.setRowCount(theater.select("theaterId=" + theater.getId()).get(0).getRowCount());
        theater.setColCount(theater.select("theaterId=" + theater.getId()).get(0).getColCount());

        if (deleteSeats(theater) != 0) {
            try {
                String sqlstr = "delete from theater ";
                sqlstr += " where theaterId = " + id;
                Database db = new Database();
                db.openConnection();
                rtn = db.execCommand(sqlstr);
                db.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return rtn;
    }

    public List<Theater> select(String condt) {
        List<Theater> theaterList = null;
        theaterList = new LinkedList<Theater>();
        try {
            String sqlstr = "select theaterId, theaterName, theaterRowCount, theaterColCount, theaterStatus from theater ";
            condt.trim();
            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }
            Database db = new Database();
            if (db.openConnection() == null) {
                return null;
            }
            ResultSet rst = db.execQuery(sqlstr);
            if (rst != null) {
                while (rst.next()) {
                    Theater theater = new Theater();
                    theater.setId(rst.getInt("theaterId"));
                    theater.setColCount(rst.getInt("theaterColCount"));
                    theater.setRowCount(rst.getInt("theaterRowCount"));
                    theater.setStatus(rst.getInt("theaterStatus"));
                    theater.setName(rst.getString("theaterName"));
                    theaterList.add(theater);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
        return theaterList;
    }

    public int createSeats(Theater theater) {
        Seat seat = new Seat();
        Seat tempSeat = new Seat();
        try {
            for (int i = 1; i <= theater.getRowCount(); i++) {
                for (int j = 1; j <= theater.getColCount(); j++) {
                    seat.setTheaterId(theater.getId());
                    seat.setRow(i);
                    seat.setColumn(j);
                    seat.setStatus(1);
                    tempSeat.insert(seat);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }

    public int deleteSeats(Theater theater) {
        //Seat seat = new Seat();
        //Seat tempSeat = new Seat();
        try {
            for (int i = 1; i <= theater.getRowCount(); i++) {
                for (int j = 1; j <= theater.getColCount(); j++) {
                    Seat seat = new Seat();
                    Seat tempSeat = new Seat();

                    seat.setTheaterId(theater.getId());
                    System.out.println(seat.getTheaterId());
                    seat.setRow(i);
                    seat.setColumn(j);
                    int seatId = (tempSeat.select("theaterId=" + seat.getTheaterId() + ",seatRow=" + seat.getRow() + ",seatCol=" + seat.getColumn())).get(0).getId();

                    tempSeat.delete(seatId);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }

}

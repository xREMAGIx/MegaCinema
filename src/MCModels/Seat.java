/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author USER
 */
public class Seat {

    private int id;
    private int theaterId;
    private int row;
    private int column;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public int insert(Seat seat) {
        try {
            String sqlstr = "insert into seat( theaterId, seatRow, seatCol, seatStatus ) values( "
                    + seat.getTheaterId() + ", " + seat.getRow() + ", " + seat.getColumn() + ", " + seat.getStatus()
                    + " )";
            System.out.println(sqlstr);
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                seat.setId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public int update(Seat seat) {
        int rtn = 0;
        try {
            String sqlstr = "update seat set theaterId = " + seat.getTheaterId() + ", seatRow = " + seat.getRow()
                    + ", seatCol = " + seat.getColumn() + ", seatStatus = " + seat.getStatus();
            sqlstr += " where seatId = " + seat.getId();
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
        try {
            String sqlstr = "delete from seat ";
            sqlstr += " where seatId = " + id;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public List<Seat> select(String condt) {
        List<Seat> seatList = null;
        seatList = new LinkedList<Seat>();
        try {
            String sqlstr = "select * from seat ";
            condt.trim();
            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }
            Database db = new Database();
            if (db.openConnection()==null) {
                return null;
            }
            ResultSet rst = db.execQuery(sqlstr);
            if (rst != null) {
                while (rst.next()) {
                    Seat seat = new Seat();
                    seat.setId(rst.getInt("seatId"));
                    seat.setTheaterId(rst.getInt("theaterId"));
                    seat.setRow(rst.getInt("seatRow"));
                    seat.setColumn(rst.getInt("seatCol"));
                    seat.setStatus(rst.getInt("seatStatus"));
                    seatList.add(seat);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
        return seatList;
    }
}

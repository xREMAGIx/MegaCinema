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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Cinema {

    private int id;
    private String Name;
    private String Location;
    private int Status;

    public Cinema(int id, String Name, String Location, int Status) {
        this.id = id;
        this.Name = Name;
        this.Location = Location;
        this.Status = Status;
    }

    public Cinema() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public int getStatus() {
        return Status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int Insert(Cinema cinema) {

        try {
            String sqlstr = "insert into cinema(cinemaId, cinemaName, cinemaLocation, status) values(" + cinema.getId() + ", '"
                    + cinema.getName() + "', '" + cinema.getLocation() + "', " + cinema.getStatus()
                    + " )";

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.getInsertObjectIDs(sqlstr);

//            if (rst != null && rst.first()) {	
//                cinema.setId(rst.getInt(1));		
//            }	
            db.close(rst);
            //db.closeConnection();	
            return 1;

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int Update(Cinema cinema) {

        int rtn = 0;

        try {

            String sqlstr = "update cinema set " + " cinemaName = '" + cinema.getName()
                    + "', cinemaLocation = '" + cinema.getLocation() + "', status = " + cinema.getStatus();

            //String sqlstr =" ";
            sqlstr += " where cinemaId = " + cinema.getId();

            Database db = new Database();

            db.openConnection();

            rtn = db.execCommand(sqlstr);

            //db.closeConnection();	
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int Delete(int ID) {

        int rtn = 0;

        try {
            String sqlstr = "delete from cinema ";

            sqlstr += " where cinemaId = " + ID;

            Database db = new Database();

            db.openConnection();

            rtn = db.execCommand(sqlstr);

            //db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public List<Cinema> Select(String condt) {

        String sql = " ";
        ResultSet rs = null;

        Database db = new Database();
        List<Cinema> temp = new ArrayList<>();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst;

            try {
                sql = "SELECT * FROM cinema";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("cinemaId");
                    String cinemaName = rs.getString("cinemaName");
                    String cinemaLocation = rs.getString("cinemaLocation");
                    int gen = rs.getInt("status");

                    Cinema t = new Cinema(id, cinemaName, cinemaLocation, gen);
                    temp.add(t);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
//        Theater[] array = temp.toArray(new Theater[temp.size()]);

        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    public String IDtoName(int ID) {

        String rtn = "";

        try {
            String sqlstr = "select CinemaName from cinema ";

            sqlstr += " where cinemaId = " + ID;

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    rtn = rst.getString("cinemaName");

                }

            }

            //db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int getNextID() {
        int rtn = 0;

        try {
            String sqlstr = "SELECT cinemaId FROM cinema ORDER BY cinemaId DESC LIMIT 1";

//            sqlstr += " where cinemaId = " + ID;
            Database db = new Database();

            db.openConnection();

            //rtn = db.execCommand(sqlstr);

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {
                    return rst.getInt("cinemaId") + 1;

                }
            }

            //db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return -1;
    }

}

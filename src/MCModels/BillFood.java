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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class BillFood {

    private int Id;
    private Date Time;
    private int Total;
    private int cinemaId;
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public BillFood() {
    }

    public BillFood(int Id, Date Time, int Total, int cinemaId) {
        this.Id = Id;
        this.Time = Time;
        this.Total = Total;
        this.cinemaId = cinemaId;
    }

    public int getId() {
        return Id;
    }

    public Date getTime() {
        return Time;
    }

    public int getTotal() {
        return Total;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public int Insert(BillFood billfood) {

        try {
            String sqlstr = "insert into billFood (empId, cinemaId, Time, Total) values(" + billfood.getEmpId() + ", "
                    + billfood.getCinemaId() + ", '" + pFormatter.format(billfood.getTime()) + "', " + billfood.getTotal() + " )";

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.getInsertObjectIDs(sqlstr);

            if (rst != null && rst.first()) {	
                billfood.setId(rst.getInt(1));		
            }	
            db.close(rst);
            db.close();
            
            //db.closeConnection();	
            return billfood.getId();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int Update(BillFood billfood) {

        int rtn = 0;

        try {

            String sqlstr = "update billFood set billId = " + billfood.getId() + ", cinemaId = " + billfood.getCinemaId()
                    + ", Time = " + billfood.getTime() + ", Total = " + billfood.getTotal();

            //String sqlstr =" ";
            sqlstr += " where billId = " + billfood.getId();

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
            String sqlstr = "delete from billFood ";

            sqlstr += " where billId = " + ID;

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

    public List<BillFood> Select(String condt) {

        String sql = " ";
        ResultSet rs = null;

        Database db = new Database();
        List<BillFood> temp = new ArrayList<>();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst;

            try {
                sql = "SELECT * FROM billfood";
                condt.trim();
                if (!condt.isEmpty()) {
                    sql += " where " + condt;
                }
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("billId");
                    int cinemaid = rs.getInt("cinemaId");
                    Date date = rs.getDate("Time");
                    int total = rs.getInt("Total");

                    BillFood t = new BillFood(id, date, total, cinemaid);
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

    public int getNextID() {
        int rtn = 0;

        try {
            String sqlstr = "SELECT billId FROM billFood ORDER BY billId DESC LIMIT 1";

//            sqlstr += " where cinemaId = " + ID;
            Database db = new Database();

            db.openConnection();

           // rtn = db.execCommand(sqlstr);

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {
                    return rst.getInt("billId") + 1;

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

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Theater {
    private int id;
    private int cinemaID;
    private int Number;
    private int status;

    public Theater(int id, int cinemaID, int Number, int status) {
        this.id = id;
        this.cinemaID = cinemaID;
        this.Number = Number;
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

    public int getNumber() {
        return Number;
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

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int Insert(Theater theater) {

        try {	
         
            String sqlstr = "insert into theater(theaterCinema, theaterNumber, theaterStatus) values( "
                    + theater.getCinemaID() + ", " + theater.getNumber() + ", " + theater.getStatus()	
                    + " )";		


            Database db = new Database();
	
            db.openConnection();	
        
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
	
            if (rst != null && rst.first()) {	
                theater.setId(rst.getInt(1));		
            }	
            
            
            db.close(rst);	
            //db.closeConnection();	
            return 1;
          	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());	
	
        }	
        return 0;	
    }
    
    public int Update(Theater theater) {
		
        int rtn = 0;
		
        try {		
            String sqlstr = "update theater set " + " theaterCinemaID = " + theater.getCinemaID()
                    + ", theaterManager = " + theater.getNumber() + ", theaterStatus = " + theater.getStatus();            


            //String sqlstr =" ";
            
            sqlstr += " where theaterId = " + theater.getId();
	
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
            String sqlstr = "delete from theater ";
	
            sqlstr += " where theaterId = " + ID;
	
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
    
    public ArrayList <Theater> loadTheaters(){
        String sql=" ";
        ResultSet rs = null;
        
        Database db = new Database();
        ArrayList <Theater> temp= new ArrayList <> (); 
	
        try {
            Connection con = db.openConnection();
             PreparedStatement pst;
        
        try
        {
            sql = "SELECT * FROM theater";
            pst = con.prepareStatement(sql);
            
            
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("id");
            int cinemaID = rs.getInt("idcenema");
            int manaID = rs.getInt("idmana");
            int gen = rs.getInt("status");
            
            Theater t = new Theater (id, cinemaID, manaID, gen);
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        Theater[] array = temp.toArray(new Theater[temp.size()]);
        
        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
       
    }
    
}

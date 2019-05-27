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
    
    public int Insert(Theater theater) {

        try {	
         
            String sqlstr = "insert into theater(theaterCinema, theaterManagerID, theaterStatus) values( "
                    + theater.getCinemaID() + ", " + theater.getManagerID() + ", " + theater.getStatus()	
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
                    + ", theaterManager = " + theater.getManagerID() + ", theaterStatus = " + theater.getStatus();            


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
            
            int id = rs.getInt("theaterId");
            //int cinemaID = rs.getInt("idcenema");
            //int manaID = rs.getInt("idmana");
            String name = rs.getString("theaterName");
            //int gen = rs.getInt("status");
            
            Theater t = new Theater (id, NULL, NULL, name, NULL);
            //Theater t = new Theater (id, cinemaID, manaID, name, gen);
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

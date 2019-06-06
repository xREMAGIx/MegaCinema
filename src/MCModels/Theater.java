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
    private int Row;
    private int Collum;

    public Theater(int id, int cinemaID, int Number, int status, int row, int collum) {
        this.id = id;
        this.cinemaID = cinemaID;
        this.Number = Number;
        this.status = status;
        this.Row = row;
        this.Collum = collum;
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

    public int getRow() {
        return Row;
    }

    public int getCollum() {
        return Collum;
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

    public void setRow(int Row) {
        this.Row = Row;
    }

    public void setCollum(int Collum) {
        this.Collum = Collum;
    }
    
    
    
    public int Insert(Theater theater) {

        try {	
         
            String sqlstr = "insert into theater(cinemaId, Number, Status) values( "
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
            String sqlstr = "update theater set " + " cinemaId = " + theater.getCinemaID()
                    + ", Number = " + theater.getNumber() + ", Status = " + theater.getStatus();            


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
            int cinemaID = rs.getInt("cinemaId");
            int num = rs.getInt("Number");
            int gen = rs.getInt("Status");
            int row = rs.getInt("Row");
            int col = rs.getInt("Collum");
            
            Theater t = new Theater (id, cinemaID, num, gen, row, col);
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

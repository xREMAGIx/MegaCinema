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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Warehouse {
    private int Id;
    private int CinemaId;

    public Warehouse() {
    }

    public Warehouse(int Id, int CinemaId) {
        this.Id = Id;
        this.CinemaId = CinemaId;
    }

    public int getId() {
        return Id;
    }

    public int getCinemaId() {
        return CinemaId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setCinemaId(int CinemaId) {
        this.CinemaId = CinemaId;
    }
    
    public List<Warehouse> Select(String condt) {

        String sql=" ";
        ResultSet rs = null;
        
        Database db = new Database();
        ArrayList <Warehouse> temp= new ArrayList <> (); 
	
        try {
            Connection con = db.openConnection();
             PreparedStatement pst;
        
        try
        {
            sql = "SELECT * FROM warehouse";
            pst = con.prepareStatement(sql);
            
            
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("id");
            int cineid = rs.getInt("CinemaId");
            
            Warehouse t = new Warehouse (id, cineid);
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        Warehouse[] array = temp.toArray(new Warehouse[temp.size()]);
        
        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;	
    }
    
    public int Insert(Warehouse warehouse) {

        try {	
            String sqlstr = "insert into warehouse(Id, cinemaId) values(" + warehouse.getId() + "," + warehouse.getId() + " )";		


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
    
    public int Update(Warehouse warehouse) {
		
        int rtn = 0;
		
        try {		

            String sqlstr = "update warehouse set " + " cinemaId = " + warehouse.getCinemaId();            


            //String sqlstr =" ";
            
            sqlstr += " where Id = " + warehouse.getId();
	
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
            String sqlstr = "delete from warehouse ";
	
            sqlstr += " where Id = " + ID;
	
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
}

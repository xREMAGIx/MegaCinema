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
public class Unit {
    private int Id;
    private String Name;

    public Unit() {
    }

    public Unit(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public List<Unit> Select(String condt) {

        String sql=" ";
        ResultSet rs = null;
        
        Database db = new Database();
        ArrayList <Unit> temp= new ArrayList <> (); 
	
        try {
            Connection con = db.openConnection();
             PreparedStatement pst;
        
        try
        {
            sql = "SELECT * FROM unit";
            pst = con.prepareStatement(sql);
            
            
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("id");
            String name = rs.getString("Name");
            
            Unit t = new Unit (id, name);
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        Status[] array = temp.toArray(new Status[temp.size()]);
        
        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;	
    }
    
    public String IDtoName(int ID) {
	
        String rtn = "";
	
        try {	
            String sqlstr = "select Name from unit ";
	
            sqlstr += " where id = " + ID;
	
            Database db = new Database();
	
            db.openConnection();
	
            
            
            ResultSet rst = db.execQuery(sqlstr);
	
            if (rst != null) {
	
                while (rst.next()) {
		
                rtn =  rst.getString("Name");
		
                }
		
            }
	
            //db.closeConnection();
	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());		
        }	
        return rtn;	
    }
    
}

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
public class Status {
    private int id;
    private String name;

    public Status() {
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Status> Select(String condt) {

        String sql=" ";
        ResultSet rs = null;
        
        Database db = new Database();
        ArrayList <Status> temp= new ArrayList <> (); 
	
        try {
            Connection con = db.openConnection();
             PreparedStatement pst;
        
        try
        {
            sql = "SELECT * FROM status";
            pst = con.prepareStatement(sql);
            
            
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("id");
            String name = rs.getString("Name");
            
            Status t = new Status (id, name);
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCDatabase.Database;
import MCModels.Theater;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TheaterController extends Theater{
    Database db;
    Connection con;
    PreparedStatement pst;
    
    public TheaterController()
    {
        super();
        try {
            db= new Database();
            con = db.openConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <Theater> loadTheaters(){
        String sql=" ";
        ResultSet rs = null;
        
        ArrayList <Theater> temp= new ArrayList <> (); 
        try
        {
            sql = "SELECT * FROM theater";
            pst = con.prepareStatement(sql);
            
            
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("id");
            int movieID = rs.getInt("idmovie");
            int manaID = rs.getInt("idmana");
            String gen = rs.getString("Genre");
            
            Theater t = new Theater (id, movieID, manaID, gen);
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        Theater[] array = temp.toArray(new Theater[temp.size()]);
        return temp;
    }
}

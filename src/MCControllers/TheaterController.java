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
            con = db.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insertTheater(int id, int idcinema, int idmanager, int status)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="INSERT INTO theater(`id`,`idcimema`,`idmanager`, `status`) VALUES(?,?,?,?)";
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.setInt(2, idcinema);
            pst.setInt(3, idmanager);
            pst.setInt(4, status);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public int updateTheater(int id, int idcinema, int idmanager, int status)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="UPDATE theater SET idcinema = ?, idmanager = ? , status = ? WHERE id = ?";
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, idcinema);
            pst.setInt(2, idmanager);
            pst.setInt(3, status);
            pst.setInt(4, id);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public int deleteMovie (int id){
        int res=0;
        String sql="";
        
        try
        {
            sql="DELETE FROM theater WHERE id = ?";
            pst=con.prepareStatement(sql);
           
            pst.setInt(1, id);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
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
        return temp;
    }
}

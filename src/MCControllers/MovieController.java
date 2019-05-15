/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCDatabase.Database;
import MCModels.Movie;
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
public class MovieController extends Movie{
    Database db;
    Connection con;
    PreparedStatement pst;
    
    public MovieController()
    {
        super();
        try {
            db= new Database();
            con = db.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int insertMovie(int id, String name, int dur, String genre)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="INSERT INTO movie(`idmovie`,`Name`,`Duration`, `Genre`) VALUES(?,?,?,?)";
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, dur);
            pst.setString(4, genre);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    public int updateMovie(int id, String a, String b, String c)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="UPDATE movie SET Name = ?, Duration = ? , Genre = ? WHERE idmovie = ?";
            pst=con.prepareStatement(sql);
            
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setInt(4, id);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ArrayList <Movie> loadMovies(){
        String sql=" ";
        ResultSet rs = null;
        
        ArrayList <Movie> temp= new ArrayList <> (); 
        try
        {
            sql = "SELECT * FROM movie";
            pst = con.prepareStatement(sql);
            
         
            
           
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int movieID = rs.getInt("idmovie");
            String name = rs.getString("Name");
            int dur = rs.getInt("Duration");
            String gen = rs.getString("Genre");
            
            Movie t = new Movie (movieID, name, dur, gen);
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        Movie[] array = temp.toArray(new Movie[temp.size()]);
        return temp;
    }
    
    public String IDtoName(int ID){
        String sql=" ";
        ResultSet rs = null;
        try
        {
            sql = "SELECT Name FROM movie WHERE idmovie = ?";
            pst = con.prepareStatement(sql);
            
             pst.setInt(1, ID);
            
            
            rs = pst.executeQuery();
         
         while (rs.next()) {
            return rs.getString("Name");
        }
        
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return "null";
    }
    
    public int getNextID(){
        String sql=" ";
        ResultSet rs = null;
        try
        {
            sql = "SELECT idmovie FROM movie ORDER BY idmovie DESC LIMIT 1";
            pst = con.prepareStatement(sql);
       
      
            rs = pst.executeQuery();
         
         while (rs.next()) {
            return rs.getInt("idmovie");
        }
        
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
   
}

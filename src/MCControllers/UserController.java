/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCDatabase.Database;
import MCModels.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DELL
 */
public class UserController extends User{
    
    Database db;
    Connection con;
    PreparedStatement pst;
    
    public UserController()
    {
        super();

       

        db= new Database();
        try {
            con = db.openConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    public int createAccount(String a, String b, String c)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="INSERT INTO user(`id`,`name`,`email`, `password`) VALUES(NULL,?,?,?)";
            pst=con.prepareStatement(sql);
            
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
            
    public boolean checkLogin(String a, String b)
    {
        String sql=" ";
        ResultSet rs = null;
        
        
        try
        {
            sql = "SELECT * FROM user WHERE email=? and password=?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, a);
            pst.setString(2, b);
            
            
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}

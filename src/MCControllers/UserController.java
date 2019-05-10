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
            con = db.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int createAccount(User u)
    {
        int res=0;
        String sql="";
        
        try
        {
            sql="INSERT INTO user(`id`,`name`,`email`, `password`) VALUES(NULL,?,?,?)";
            pst=con.prepareStatement(sql);
            
            pst.setString(1, u.getName());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            
            res = pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
            
    public boolean checkLogin(User u)
    {
        String sql=" ";
        ResultSet rs = null;
        
        
        try
        {
            sql = "SELECT * FROM user WHERE email=? and password=?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getPassword());
            
            
            
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

    public boolean checkLogin(String email, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int createAccount(String name, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

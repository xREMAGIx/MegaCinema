/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class Database {
    
    
    private static String url;
    private static String username;
    private static String password;
//    
//    public Database()
//    {
//        url="jdbc:mysql://localhost:3306/megacinema";
//        username="root";
//        password="root";
//    }
    
    protected static void loadJDBCDriver() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e)
        {
            throw new Exception("SQL JDBC Driver not found...");
        }
    }
    
    
    public static Connection getConnection() throws Exception
    {
        //loading driver
//        try
//        {
//            Class.forName("com.mysql.jdbc");
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//                
//        try
//        {
//            con = DriverManager.getConnection(url,username,password);
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }        
//        return con;
        Connection connect = null;
        
        url="jdbc:mysql://localhost:3306/megacinema?autoReconnect=true&useSSL=false";
        username="root";
        password="remagi";
        
        if(connect==null)
        {
            loadJDBCDriver();
            try
            {
                connect = DriverManager.getConnection(url,username,password);
            }
            catch (java.sql.SQLException e)
            {
                throw new Exception("Cant access to database server..."+url+e.getMessage());
            }
        }
        
        return connect;
    }
    
    public void closeConnection() throws Exception
    {
        try
        {
            getConnection().close();
        }
        catch (Exception e)
        {
            System.out.println("Failed in closeConnection..."+e);
        }
    }
}

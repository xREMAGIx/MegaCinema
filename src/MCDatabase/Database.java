/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author DELL
 */
public class Database {
    
    private static Connection connect = null;
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

    public Connection getConnect() {
        return connect;
    }
    
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
    
    
    public Connection openConnection() throws Exception
    {
        
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
            catch (SQLException e)
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
            if(connect!=null)
          connect.close();
        }
        catch (SQLException e)
        {
            System.out.println("Failed in closeConnection..."+e);
        }
    }
    
    public ResultSet getInsertObjectIDs(String insertSql) throws Exception{
	ResultSet rst = null;
	try 
        {
	
            if(connect==null)
            {
                throw new Exception("Database not connected!");
            }
            
            Statement stmt = connect.createStatement();			
            stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
            rst = stmt.getGeneratedKeys();
            
	} 
        catch (SQLException e) 
        {
            //e.printStackTrace();
            System.out.println(e.getMessage());
	}
	return rst;
        
    }
    
    public int execCommand(String sql) throws Exception{
	int flag = 0;
	try {
            if(connect==null)
            {
                throw new Exception("Database not connected!");
            }
            

            Statement stmt = connect.createStatement();
        
            flag = stmt.executeUpdate(sql);
				
            stmt.close();			
	} 
        catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
	return flag;
    }
    
    public ResultSet execQuery(String sql) throws Exception {
		
        ResultSet rstSet = null;
	
        try {
            
            if (connect==null)
            {
                throw new Exception("Database not connected!");
            }
		
            Statement stmt = connect.createStatement();
	
            rstSet = stmt.executeQuery(sql);
	
        } catch (SQLException e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }	
        return rstSet;	
    }
       
    public void close(ResultSet rst) throws Exception {
       try {
	
            Statement stmt = rst.getStatement();	
            rst.close();	
            stmt.close();
            
        } catch (SQLException e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }	
    }
    
    public void close() throws SQLException, Exception{
		
        if(connect!=null){
	
            connect.close();
	
            connect=null;
	
        }
	
    }
}

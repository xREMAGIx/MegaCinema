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
    private final Theater theaterM = new Theater();
    
  
    
    public int insertTheater(int id, int idcinema, int number, int status)
    {
        Theater theater = new Theater();
        theater.setCinemaID(idcinema);
        theater.setNumber(number);
        theater.setStatus(status);
        
        return theaterM.Insert(theater);
    }
    
    public int updateTheater(int id, int idcinema, int number, int status)
    {
        Theater theater = new Theater();
        theater.setId(id);
        theater.setCinemaID(idcinema);
        theater.setNumber(number);
        theater.setStatus(status);
        return theaterM.Update(theater); 
    }
    
    public int deleteTheater (int id){
        return theaterM.Delete(id);
        
    }
    
    public ArrayList <Theater> loadTheaters(){
        return theaterM.loadTheaters();
    }
}

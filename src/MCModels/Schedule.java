/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Schedule {
 
    private int id;
    private int studioId;
    private int movieId;
    private Date time;
    private double price;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    @Override
    public String toString()
    {
        if(getTime()==null)
            return "0:00:00";
        else
            return DateFormat.getTimeInstance().format(getTime());
    }
    
    //insert new schedule of a movie
    public int Insert(Schedule schedule)
    {
        try {
		String sqlstr = "insert into schedule( studioId, movieId, schedTime, schedTicketPrice) values( "
				+ schedule.getStudioId() + ", " + schedule.getMovieId() + ", '" + schedule.getTime() + "', "
				+ schedule.getPrice() + " )";
		Database db = new Database();
		db.openConnection();
		ResultSet rst = db.getInsertObjectIDs(sqlstr);
                if (rst != null && rst.first()) 
                {
			schedule.setId(rst.getInt(1));
                }
		//db.close(rst);
                db.closeConnection();
	return 1;
	} 
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
	}
	return 0;
    }
    
    //update, modify schedule of a movie    
    public int Update(Schedule sched) {
	int rtn = 0;
	try {
		String sqlstr = "update schedule set studioId ='" + sched.getStudioId() + "', movieId = "
                        + sched.getMovieId() + ", schedTime = " + sched.getTime() + ", schedTicketPrice = '"
			+ sched.getPrice() + "' ";
                sqlstr += " where schedId = " + sched.getId();
		Database db = new Database();
		db.openConnection();
                rtn = db.execCommand(sqlstr);
		db.closeConnection();
	} 
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
	}
	return rtn;
	}
    
    //delete a schedule time of a movie
    public int Delete(int id) {
	int rtn = 0;
        
	try {
            String sqlstr = "delete from schedule ";
            sqlstr += " where schedId = " + id;
            
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
	return rtn;
    }
    
    //get shedule time from database
    public List<Schedule> Select(String condt) {
	List<Schedule> stuList = null;
	stuList = new LinkedList<Schedule>();
        try {
            String sqlstr = "select schedId, studioId, playId, schedTime, schedTicketPrice from schedule ";	
            condt.trim();
          
            if (!condt.isEmpty())
            {
                sqlstr += " where " + condt;
            }
            
            Database db = new Database();
	
            if (db.openConnection()==null) {
                return null;
            }
			
            ResultSet rst = db.execQuery(sqlstr);
	
            if (rst != null) {
                while (rst.next()) {
				
                    Schedule stu = new Schedule();	
                    
                    stu.setId(rst.getInt("schedId"));		
                    stu.setStudioId(rst.getInt("studioId"));
                    stu.setMovieId(rst.getInt("movieId"));		
                    stu.setTime(rst.getTimestamp("schedTime"));		
                    stu.setPrice(rst.getDouble("schedTicketPrice"));
		
                    stuList.add(stu);		
                }		
            }
		
            //db.close(rst);
	
            db.closeConnection();
		
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());	
        } 
        
        return stuList;
	
    }
    
}

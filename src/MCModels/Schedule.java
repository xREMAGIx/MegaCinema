/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Schedule {

    private int id;
    private int theaterId;
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

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
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

    SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //insert new schedule of a movie
    public int insert(Schedule schedule) {
        try {
            String sqlstr = "insert into schedule( theaterId, movieId, schedTime, schedTicketPrice) values( "
                    + schedule.getTheaterId() + ", " + schedule.getMovieId() + ", '" + pFormatter.format(schedule.getTime()) + "', "
                    + schedule.getPrice() + " )";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                schedule.setId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return 0;
    }

    //update, modify schedule of a movie    
    public int update(Schedule sched) {
        int rtn = 0;
        try {
            String sqlstr = "update schedule set theaterId =" + sched.getTheaterId() + ", movieId = "
                    + sched.getMovieId() + ", schedTime = '" +  pFormatter.format(sched.getTime()) + "', schedTicketPrice = "
                    + sched.getPrice() + " ";
            sqlstr += " where schedId = " + sched.getId();
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
            //db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    //delete a schedule time of a movie
    public int delete(int id) {
        int rtn = 0;

        try {
            String sqlstr = "delete from schedule ";
            sqlstr += " where schedId = " + id;

            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            
            db.close();
//            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    //get shedule time from database
    public List<Schedule> select(String condt) {
        List<Schedule> stuList = null;
        stuList = new LinkedList<Schedule>();
        try {
            String sqlstr = "select schedId, theaterId, movieId, schedTime, schedTicketPrice from schedule ";
            condt.trim();

            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }

            Database db = new Database();

            if (db.openConnection() == null) {
                return null;
            }

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {
                while (rst.next()) {

                    Schedule stu = new Schedule();

                    stu.setId(rst.getInt("schedId"));
                    stu.setTheaterId(rst.getInt("theaterId"));
                    stu.setMovieId(rst.getInt("movieId"));
                    stu.setTime(rst.getTimestamp("schedTime"));
                    stu.setPrice(rst.getDouble("schedTicketPrice"));

                    stuList.add(stu);
                }
            }

            db.close(rst);

//            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return stuList;

    }

    @Override
    public String toString() {
        return pFormatter.format(this.getTime());
    }
}

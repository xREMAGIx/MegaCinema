/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Ticket {

    private int id;
    private int seatId;
    private int scheduleId;
    private float price;
    private int status;
    private Date lockedTime;

    private String movieName;
    private Schedule schedule;
    private Seat seat;
    private Date currentLockedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getCurrentLockedTime() {
        return currentLockedTime;
    }

    public void setCurrentLockedTime(Date currentLockedTime) {
        this.currentLockedTime = currentLockedTime;
    }    
    
    public int insert(Ticket ticket) {
        try {
            String sqlstr = "insert into ticket( seatId, schedId, price, status ) values("
                    + ticket.getSeatId() + ", " + ticket.getScheduleId() + ", " + ticket.getPrice() + ", "
                    + ticket.getStatus() + " )";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                ticket.setId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int update(Ticket ticket) {
        int rtn = 0;
        try {
            String sqlstr = "update ticket set seatId = " + ticket.getSeatId() + ", schedId = "
                    + ticket.getScheduleId() + ", price = " + ticket.getPrice() + ", status = "
                    + ticket.getStatus() + ", lockedTime = '" + ticket.getLockedTime() + "'";
            sqlstr += " where id = " + ticket.getId();
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return rtn;
    }

    public int delete(int id) {
        int rtn = 0;
        try {
            String sqlstr = "delete from ticket ";
            sqlstr += " where id = " + id;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public List<Ticket> select(String condt) {
        List<Ticket> ticketList = null;
        ticketList = new LinkedList<Ticket>();
        try {
            String sqlstr = "select id, seatId, schedId, price, status, lockedTime from ticket ";
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
                    Ticket ticket = new Ticket();
                    ticket.setId(rst.getInt("id"));
                    ticket.setSeatId(rst.getInt("seatId"));
                    ticket.setScheduleId(rst.getInt("schedId"));
                    ticket.setPrice(rst.getInt("price"));
                    ticket.setStatus(rst.getInt("status"));
                    ticket.setLockedTime(rst.getDate("lockedTime"));
                    ticketList.add(ticket);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {

        }
        return ticketList;
    }

    public int lockTicket(int ID, String time) {
        int rtn = 0;
        try {
            String sqlstr = "update ticket set status = 1, lockedTime = '" + time + "'";
            sqlstr += " where id = " + ID;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return rtn;
    }

    public int unlockTicket(int ID) {
        int rtn = 0;
        try {
            String sqlstr = "update ticket set status = 0";
            sqlstr += " where id = " + ID;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return rtn;
    }
}

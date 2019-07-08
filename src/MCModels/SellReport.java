/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class SellReport {
    private int id;
    private int cinemaId;
    private Date reportDay;
    private int productTotal;
    private int ticketTotal;

    public SellReport() {
    }

    public SellReport(int id, int cinemaId, Date reportDay, int productTotal, int ticketTotal) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.reportDay = reportDay;
        this.productTotal = productTotal;
        this.ticketTotal = ticketTotal;
    }

    public int getId() {
        return id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public Date getReportDay() {
        return reportDay;
    }

    public int getProductTotal() {
        return productTotal;
    }

    public int getTicketTotal() {
        return ticketTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public void setReportDay(Date reportDay) {
        this.reportDay = reportDay;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    public void setTicketTotal(int ticketTotal) {
        this.ticketTotal = ticketTotal;
    }
    
    SimpleDateFormat pFormatter=new SimpleDateFormat("yyyy-MM-dd"); 
    public int Insert(SellReport sellreport) {

        try {	
            String sqlstr = "insert into sellreport (Id, cinemaId, reportDay, productTotal, ticketTotal) values(" + sellreport.getId() + ", "
                    + sellreport.getCinemaId() + ", '" + pFormatter.format(sellreport.getReportDay()) + "', " + sellreport.getProductTotal() 
                    + ", " + sellreport.getTicketTotal()+ " )";		


            Database db = new Database();
	
            db.openConnection();	
        
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
	
//            if (rst != null && rst.first()) {	
//                sellreport.setId(rst.getInt(1));		
//            }	
            
            
            db.close(rst);	
            //db.closeConnection();	
            return 1;
          	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());	
	
        }	
        return 0;	
    }
    
    public int Update(SellReport sellreport) {
		
        int rtn = 0;
		
        try {		

            String sqlstr = "update sellreport set Id = " + sellreport.getId() + ", productTotal = productTotal + " + sellreport.getProductTotal() 
                    + ", ticketTotal = ticketTotal + " + sellreport.getTicketTotal();            


            //String sqlstr =" ";
            
            sqlstr += " where Id = " + sellreport.getId();
	
            Database db = new Database();
	
            db.openConnection();
	
            rtn = db.execCommand(sqlstr);
	
            //db.closeConnection();	

        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());	
        }	
        return rtn;	
    }
        
    public int Delete(int ID) {
		
        int rtn = 0;
	
        try {	
            String sqlstr = "delete from sellreport ";
	
            sqlstr += " where Id = " + ID;
	
            Database db = new Database();
	
            db.openConnection();
	
            rtn = db.execCommand(sqlstr);
	
            //db.closeConnection();
	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());		
        }	
        return rtn;	
    }
    
    public int getNextID(){
        int rtn = 0;
	
        try {	
            String sqlstr = "SELECT Id FROM sellreport ORDER BY Id DESC LIMIT 1";
	
//            sqlstr += " where cinemaId = " + ID;
	
            Database db = new Database();
	
            db.openConnection();
	
            //rtn = db.execCommand(sqlstr);
            
            ResultSet rst = db.execQuery(sqlstr);
	
            if (rst != null) {
	
                while (rst.next()) {
                return  rst.getInt("Id")+1;
				
                }		
            }
	
            //db.closeConnection();
	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());		
        }	
        return 0;
    }
    
    public int getcurDayId(Date curdate){
        int rtn = 0;
	
        try {	
            String sqlstr = "SELECT Id FROM sellreport ";
	
            sqlstr += " where reportDay = '" + pFormatter.format(curdate) +"'";
	
            Database db = new Database();
	
            db.openConnection();
	
            rtn = db.execCommand(sqlstr);
            
            ResultSet rst = db.execQuery(sqlstr);
	
            if (rst != null) {
	
                while (rst.next()) {
                return  rst.getInt("Id");
				
                }		
            }
	
            //db.closeConnection();
	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());		
        }	
        return -1;
    }
    
    
    public List<SellReport> SelectAPeriod(Date begindate, Date enddate){
        int rtn = 0;
        List <SellReport> temp= new ArrayList <> (); 
	
        try {	
            String sqlstr = "SELECT * FROM sellreport ";
	
            sqlstr += " where reportDay >= '" + pFormatter.format(begindate) +"' and reportDay <= '" + pFormatter.format(enddate) + "'";
	
            Database db = new Database();
	
            db.openConnection();
	
            rtn = db.execCommand(sqlstr);
            
            ResultSet rst = db.execQuery(sqlstr);
	
            if (rst != null) {
	
                while (rst.next()) {
                int id =  rst.getInt("Id");
                Date date = rst.getDate("reportDay");
                int product =  rst.getInt("ProductTotal");
                int ticket = rst.getInt("TicketTotal");
                
                SellReport t = new SellReport(id,-1,date,product,ticket);
                temp.add(t);
				
                }		
            }
	
            //db.closeConnection();
	
        } catch (Exception e) {	
            //e.printStackTrace();
            System.out.println(e.getMessage());		
        }	
        return temp;
    }
    
    
}

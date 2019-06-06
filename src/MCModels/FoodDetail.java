/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class FoodDetail {
    private int id;
    private int billId;
    private int productId;
    private int Price;
    private int Quantity;

    public FoodDetail() {
    }

    public FoodDetail(int id, int billId, int productId, int Price, int Quantity) {
        this.id = id;
        this.billId = billId;
        this.productId = productId;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public int getId() {
        return id;
    }

    public int getBillId() {
        return billId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    public int Insert(FoodDetail fooddetail) {

        try {	
            String sqlstr = "insert into fooddetail (Id, billId, productId, Price, Quantity) values(" + fooddetail.getId() + ", "
                    + fooddetail.getBillId() + ", " + fooddetail.getProductId() + ", " + fooddetail.getPrice() + ", " + fooddetail.getQuantity() + " )";		


            Database db = new Database();
	
            db.openConnection();	
        
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
	
//            if (rst != null && rst.first()) {	
//                fooddetail.setId(rst.getInt(1));		
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
    
    public int Update(FoodDetail fooddetail) {
		
        int rtn = 0;
		
        try {		

            String sqlstr = "update fooddetail set Id = " + fooddetail.getId() + ", billId = " + fooddetail.getBillId()
                    + ", productId = " + fooddetail.getProductId() + ", Price = " + fooddetail.getPrice() + ", Quantity = " + fooddetail.getQuantity();            


            //String sqlstr =" ";
            
            sqlstr += " where Id = " + fooddetail.getId();
	
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
            String sqlstr = "delete from fooddetail ";
	
            sqlstr += " where billId = " + ID;
	
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
    
    
    public List<FoodDetail> Select(String condt) {

        String sql=" ";
        ResultSet rs = null;
        
        Database db = new Database();
        List <FoodDetail> temp= new ArrayList <> (); 
	
        try {
            Connection con = db.openConnection();
             PreparedStatement pst;
        
        try
        {
            sql = "SELECT * FROM fooddetail";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
         
         while (rs.next()) {
            
            int id = rs.getInt("Id");
            int billid = rs.getInt("billId");
            int productid = rs.getInt("productId");
            int price = rs.getInt("Price");
            int quan = rs.getInt("Quantity");
            
            FoodDetail t = new FoodDetail (id, billid, productid, price, quan); 
            temp.add(t);
            
        }
                
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
//        Theater[] array = temp.toArray(new Theater[temp.size()]);
        
        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;	
    }
    
     public int getNextID(){
        int rtn = 0;
	
        try {	
            String sqlstr = "SELECT Id FROM fooddetail ORDER BY Id DESC LIMIT 1";
	
//            sqlstr += " where cinemaId = " + ID;
	
            Database db = new Database();
	
            db.openConnection();
	
            rtn = db.execCommand(sqlstr);
            
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
        return -1;
    }
}

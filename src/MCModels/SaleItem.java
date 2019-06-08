/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SaleItem {

    private int id;
    private int ticketId;
    private int saleId;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int insert(SaleItem saleItem) {
        try {
            String sqlstr = "insert into saleitem( ticketId, saleId, price ) values( "
                    + saleItem.getTicketId() + ", " + saleItem.getSaleId() + ", " + saleItem.getPrice() + " )";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                saleItem.setId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }


    public int update(SaleItem saleItem) {
        int rtn = 0;
        try {
            String sqlstr = "update saleitem set ticketId = " + saleItem.getTicketId() + ", saleId = '"
                    + saleItem.getSaleId() + ", price='" + saleItem.getPrice();
            sqlstr += " where id = " + saleItem.getId();
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
            String sqlstr = "delete from saleitem ";
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

    
     public List<SaleItem> select(String condt) {
        List<SaleItem> saleItemList = null;
        saleItemList = new LinkedList<SaleItem>();
        try {
            String sqlstr = "select id, ticketId, saleId, price from saleitem ";
            condt.trim();
            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }
            Database db = new Database();
            if (db.openConnection()==null) {
                return null;
            }
            ResultSet rst = db.execQuery(sqlstr);
            if (rst != null) {
                while (rst.next()) {
                    SaleItem sale_item = new SaleItem();
                    sale_item.setId(rst.getInt("id"));
                    sale_item.setTicketId(rst.getInt("ticketId"));
                    sale_item.setSaleId(rst.getInt("saleId"));
                    sale_item.setPrice(rst.getInt("price"));
                    saleItemList.add(sale_item);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }
        return saleItemList;
    }

}

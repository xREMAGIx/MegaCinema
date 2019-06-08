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
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Sale {

    private int id;
    private int empId;
    private Date time;
    private float payment;
    private float change;
    private int type;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    float prices = 0;

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }
    
    
    Connection con;
    Database db;

    public int insert(Sale sale) {
        try {
            String sqlstr = "insert into sale( empId, time, payment, changeMoney, type, status ) values( "
                    + sale.getEmpId() + ", '" + sale.getTime() + "', " + sale.getPayment() + ", " + sale.getChange()
                    + ", " + sale.getType() + ", " + sale.getStatus() + " )";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                sale.setId(rst.getInt(1));
            }

            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public boolean doSale(List<Ticket> tickets, Sale sale) {
        try {
            int id = -1;
            db = new Database();
            db.openConnection();
            con = db.getConnect();
            con.setAutoCommit(false);
            String sqlstr = "insert into sale( empId, time, payment, changeMoney, type, status ) VALUES( ?, ?, ?, 0, 1, 1 )";
            PreparedStatement prep = con.prepareStatement(sqlstr, PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setInt(1, sale.getEmpId());
            prep.setTimestamp(2, new Timestamp(new Date().getTime()));
            prep.setFloat(3, sale.getPayment());
            prep.executeUpdate();
            ResultSet rs = prep.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            if (id > 0) {
                for (Ticket t : tickets) {
                    double price = t.getSchedule().getPrice();
                    String sqlstr2 = "insert into saleitem( ticketId, saleId, price ) VALUES( " + t.getId()
                            + ", " + id + ", " + price + ")";
                    prices += price;
                    int flag2 = db.execCommand(sqlstr2);
                    if (flag2 == 1) {
                        String sqlstr3 = "update ticket set status = 9 where id = " + t.getId();
                        int flag3 = db.execCommand(sqlstr3);
                        if (flag3 != 1) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            String sqlstr4 = "update sale set changeMoney = " + (sale.getPayment() - prices) + " where id = " + id;
            int flag4 = db.execCommand(sqlstr4);
            if (flag4 != 1) {
                return false;
            }
            con.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
                return false;
            }
            return false;
        } finally {
            try {
                con.setAutoCommit(true);
                db.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public int update(Sale sale) {
        int rtn = 0;
        try {
            String sqlstr = "update sale set empId = " + sale.getEmpId() + ", time = '" + sale.getTime()
                    + "', payment = " + sale.getPayment() + ", changeMoney = " + sale.getChange()
                    + ", type = " + sale.getType() + ", status = " + sale.getStatus();
            sqlstr += " where id = " + sale.getId();
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
            String sqlstr = "delete from sale ";
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

    public List<Sale> select(String condt) {
        List<Sale> saleList = null;
        System.out.println("pls");

        saleList = new LinkedList<Sale>();
        try {
            String sqlstr = "select id, empId, time, payment, changeMoney, type, status from sale ";
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
                    Sale sale = new Sale();
                    sale.setId(rst.getInt("id"));
                    sale.setEmpId(rst.getInt("empId"));
                    sale.setTime(rst.getTimestamp("time"));
                    sale.setPayment(rst.getFloat("payment"));
                    sale.setChange(rst.getFloat("changeMoney"));
                    sale.setType(rst.getInt("type"));
                    sale.setStatus(rst.getInt("status"));
                    saleList.add(sale);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }
        return saleList;
    }

}

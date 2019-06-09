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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Storage {

    private int Id;
    private int WarehouseId;
    private String ProductName;
    private int Quantity;
    private int Unit;

    public Storage() {
    }

    public Storage(int Id, int WarehouseId, String ProductName, int Quantity, int Unit) {
        this.Id = Id;
        this.WarehouseId = WarehouseId;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Unit = Unit;
    }

    public int getId() {
        return Id;
    }

    public int getWarehouseId() {
        return WarehouseId;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getUnit() {
        return Unit;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setWarehouseId(int WarehouseId) {
        this.WarehouseId = WarehouseId;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setUnit(int Unit) {
        this.Unit = Unit;
    }

    public int Insert(Storage storage) {

        try {
            String sqlstr = "insert into storage(storageId, warehouseId, productName, Quantity, Unit) values(" + storage.getId() + ", "
                    + storage.getWarehouseId() + ", '" + storage.getProductName() + "', " + storage.getQuantity() + ", "
                    + storage.getUnit() + " )";

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.getInsertObjectIDs(sqlstr);

//            if (rst != null && rst.first()) {	
//                storage.setId(rst.getInt(1));		
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

    public int Update(Storage storage) {

        int rtn = 0;

        try {

            String sqlstr = "update storage set storageId = " + storage.getId() + ", productName = '" + storage.getProductName()
                    + "', warehouseId = " + storage.getWarehouseId() + ", Quantity = " + storage.getQuantity() + ", Unit = " + storage.getUnit();

            //String sqlstr =" ";
            sqlstr += " where storageId = " + storage.getId() + " and warehouseId = " + storage.getWarehouseId();

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
            String sqlstr = "delete from storage ";

            sqlstr += " where storageId = " + ID;

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

    public List<Storage> Select(String condt) {

        String sql = " ";
        ResultSet rs = null;

        Database db = new Database();
        List<Storage> temp = new ArrayList<>();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst;

            try {
                sql = "SELECT * FROM storage";
                condt.trim();
                if (!condt.isEmpty()) {
                    sql += " where " + condt;
                }
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("storageId");
                    int wareid = rs.getInt("warehouseId");
                    String name = rs.getString("productName");
                    int quan = rs.getInt("Quantity");
                    int unit = rs.getInt("Unit");

                    Storage t = new Storage(id, wareid, name, quan, unit);
                    temp.add(t);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
//        Theater[] array = temp.toArray(new Theater[temp.size()]);

        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    public List<Storage> SelectProduct(String condt) {

        String sql = " ";
        ResultSet rs = null;

        Database db = new Database();
        List<Storage> temp = new ArrayList<>();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst;

            try {
                sql = "SELECT DISTINCT storageId, productName, Unit FROM storage";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("storageId");
                    int wareid = -1;
                    String name = rs.getString("productName");
                    int quan = -1;
                    int unit = rs.getInt("Unit");

                    Storage t = new Storage(id, wareid, name, quan, unit);
                    temp.add(t);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
//        Theater[] array = temp.toArray(new Theater[temp.size()]);

        } catch (Exception ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    public int Add(Storage storage, int add) {

        int rtn = 0;

        try {

            String sqlstr = "update storage set Quantity = " + "Quantity +" + add;

            //String sqlstr =" ";
            sqlstr += " where storageId = " + storage.getId() + " and warehouseId = " + storage.getWarehouseId();

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

    public String IDtoName(int ID) {

        String rtn = "";

        try {
            String sqlstr = "select productName from storage ";

            sqlstr += " where storageId = " + ID + " LIMIT 1";

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    rtn = rst.getString("productName");

                }

            }

            //db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int selectQuan(int ID, int warehouse) {

        int rtn = 0;

        try {
            String sqlstr = "select Quantity from storage ";

            sqlstr += " where storageId = " + ID + " and warehouseId = " + warehouse;

            Database db = new Database();

            db.openConnection();

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    rtn = rst.getInt("Quantity");

                }

            }

            //db.closeConnection();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

}

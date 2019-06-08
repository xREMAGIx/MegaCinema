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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Status {

    private int id;
    private String name;

    public Status() {
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Status> Select(String condt) {

        List<Status> statusList = null;

        statusList = new LinkedList<Status>();

        try {

            String sqlstr = "select statusId, statusName from status ";

            condt.trim();

            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }

            Database db = new Database();

            db.openConnection();

            if (db.openConnection() == null) {
                return null;
            }
//	
            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    Status status = new Status();

                    status.setId(rst.getInt("statusId"));

                    status.setName(rst.getString("statusName"));

                    statusList.add(status);
                }
            }

            db.close(rst);
            db.close();
            //db.closeConnection();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }

        return statusList;
    }
}

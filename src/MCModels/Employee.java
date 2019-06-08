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
public class Employee {

    private int access;
    private int id;
    private String name;
    private String password;
    private String addr;
    private String tel;
    private String email;
    private int no;

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int insert(Employee emp) {
        try {
            String sqlstr = "insert into employee(access, no, name, password, addr, tel, email ) values( "
                    + emp.getAccess() + ", " + emp.getNo() + ", '" + emp.getName() + "', '" + emp.getPassword() + 
                    "', '" + emp.getTel() + "', '" + emp.getEmail() + "')";
            Database db = new Database();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
            if (rst != null && rst.first()) {
                emp.setId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public int update(Employee emp) {
        int rtn = 0;
        try {
            String sqlstr = "update employee set id = " + emp.getId() + ", access = " + emp.getAccess()
                    + ", name = '" + emp.getName() + "', password = '" + emp.getPassword() + "', tel = '"
                    + emp.getTel() + "', addr = '" + emp.getAddr() + "', email = '" + emp.getEmail()
                    + "', no = " + emp.getNo();
            sqlstr += " where id = " + emp.getId();
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
            String sqlstr = "delete from employee ";
            sqlstr += " where emp_id = " + id;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    
    public List<Employee> select(String condt) {
        List<Employee> empList = null;
        empList = new LinkedList<Employee>();
        try {
            String sqlstr = "select id, access, name, pass, tel, addr, email, no from employee ";
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
                    Employee emp = new Employee();
                    emp.setId(rst.getInt("id"));
                    emp.setAccess(rst.getInt("access"));
                    emp.setName(rst.getString("name"));
                    emp.setPassword(rst.getString("pass"));
                    emp.setTel(rst.getString("tel"));
                    emp.setAddr(rst.getString("addr"));
                    emp.setEmail(rst.getString("email"));
                    emp.setNo(rst.getInt("no"));
                    empList.add(emp);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }
        return empList;
    }
}

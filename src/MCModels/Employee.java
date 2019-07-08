package MCModels;

import MCDatabase.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuliaHaVy
 */
public class Employee {

    private int access;
    private int id;
    private String name;
    private String addr;
    private String password;
    private String tel;
    private String email;
    private int no;

    public Employee() {
    }

    public Employee(int access, int id, String name, String addr, String tel, String email, int no) {
        this.access = access;
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.email = email;
        this.no = no;
    }

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void showValue() {
        System.out.println("ID :" + id + "\t Name :" + name);
    }

    public int insert(Employee emp) {
        try {
            String sqlstr = "insert into employee(access, no, name, pass, addr, tel, email ) values( "
                    + emp.getAccess() + ", " + emp.getNo() + ", '" + emp.getName() + "', '" + emp.getPassword() + "', '"
                    + emp.getAddr() + "', '" + emp.getTel() + "', '" + emp.getEmail() + "')";
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
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int update(Employee emp) {
        int rtn = 0;
        try {
            String sqlstr = "update employee set id = " + emp.getId() + ", access = " + emp.getAccess()
                    + ", name = '" + emp.getName() + "', pass = '" + emp.getPassword() + "', tel = '"
                    + emp.getTel() + "', addr = '" + emp.getAddr() + "', email = '" + emp.getEmail()
                    + "', no = " + emp.getNo();
            sqlstr += " where id = " + emp.getId();
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int delete(int id) {
        int rtn = 0;
        try {
            String sqlstr = "delete from employee ";
            sqlstr += " where id = " + id;
            Database db = new Database();
            db.openConnection();
            rtn = db.execCommand(sqlstr);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
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
            if (db.openConnection() == null) {
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
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {

        }
        return empList;
    }

    public boolean checkLogin(String a, String b) {
        String sql = "";
        ResultSet rs = null;

        try {
            sql = "SELECT * FROM employee WHERE name=? and pass=?";

            Database db = new Database();
            try {
                if (db.openConnection() == null) {
                    return false;
                }
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

            PreparedStatement pst = db.getConnect().prepareStatement(sql);

            pst.setString(1, a);
            pst.setString(2, b);

            rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}

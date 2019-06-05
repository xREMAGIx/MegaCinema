package MCModels;

import MCDatabase.Database;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

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
    
    public Employee()
    {    }
    
    public Employee(int access, int id, String name, String addr, String tel, String email, int no) 
    {
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
		String sqlstr = "insert into employee(emp_access, emp_no, emp_name, emp_password, emp_addr, emp_tel_num, emp_email ) values( "
				+ emp.getAccess() + ", " + emp.getNo() + ", '" + emp.getName() + "', '" + emp.getPassword() + "', '"
				+ emp.getAddr() + "', '" + emp.getTel() + "', '" + emp.getEmail() + "')";
		Database db = new Database();
	
            db.openConnection();	
        
            ResultSet rst = db.getInsertObjectIDs(sqlstr);
	
            if (rst != null && rst.first()) {	
                emp.setId(rst.getInt(1));		
            }	
            
            
            db.close(rst);	
            //db.closeConnection();	
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
		String sqlstr = "update employee set emp_id = " + emp.getId() + ", emp_access = " + emp.getAccess()
				+ ", emp_name = '" + emp.getName() + "', emp_password = '" + emp.getPassword() + "', emp_tel = '"
				+ emp.getTel() + "', emp_addr = '" + emp.getAddr() + "', emp_email = '" + emp.getEmail()
				+ "', emp_no = " + emp.getNo();
		sqlstr += " where emp_id = " + emp.getId();
		Database  db = new Database ();
		db.openConnection();
		rtn = db.execCommand(sqlstr);
		//db.closeConnection();
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
		sqlstr += " where emp_id = " + id;
		Database  db = new Database ();
		db.openConnection();
		rtn = db.execCommand(sqlstr);
		//db.closeConnection();
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
		String sqlstr = "select emp_id, emp_access, emp_name, emp_password, emp_tel, emp_addr, emp_email,emp_no from employee ";
		condt.trim();
		if (!condt.isEmpty())
                    sqlstr += " where " + condt;
		Database db = new Database();
		if (db.openConnection() == null) {
                    return null;
			}
		ResultSet rst = db.execQuery(sqlstr);
			if (rst != null) {
				while (rst.next()) {
					Employee emp = new Employee();
					emp.setId(rst.getInt("emp_id"));
					emp.setAccess(rst.getInt("emp_access"));
					emp.setName(rst.getString("emp_name"));
					emp.setPassword(rst.getString("emp_password"));
					emp.setTel(rst.getString("emp_tel"));
					emp.setAddr(rst.getString("emp_addr"));
					emp.setEmail(rst.getString("emp_email"));
					emp.setNo(rst.getInt("emp_no"));
					empList.add(emp);
				}
			}
			db.close(rst);
			//db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
                        System.out.println(e.getMessage());
		} finally {

		}
		return empList;
	}
    
}
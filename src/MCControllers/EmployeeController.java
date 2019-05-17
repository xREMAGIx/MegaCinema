/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

/**
 *
 * @author Huynh Ha Vy
 */


import MCModels.Employee;
import java.util.List;

public class EmployeeController {
    
    private final Employee emp = new Employee();

	public int add(Employee emp) {
		return emp.insert(emp);
	}

	public int modify(Employee emp) {
		return emp.update(emp);
	}

	public int delete(int id) {
		return emp.delete(id);
	}

	public List<Employee> Fetch(String condt) {
		return emp.select(condt);
	}

	public List<Employee> FetchAll() {
		return emp.select("");
	}
}





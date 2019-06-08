/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Employee;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EmployeeController {
 
    	private Employee empM = new Employee();

	public int add(Employee emp) {
		return empM.insert(emp);
	}

	public int modify(Employee emp) {
		return empM.update(emp);
	}

	public int delete(int id) {
		return empM.delete(id);
	}

	public List<Employee> select(String condt) {
		return empM.select(condt);
	}

	public List<Employee> selectAll() {
		return empM.select("");
	}
    
}

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
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import MCModels.Customer;

public class CustomerList extends AbstractListModel<String>{
	private ArrayList<Customer> lst = new ArrayList();
	
	public CustomerList() {
		lst = CustomerIO.readFile();
		
	}
	
	public void fireChange() {
		lst = CustomerIO.readFile();
		fireContentsChanged(this, 0, getSize());
	}
	
	@Override
	public String getElementAt(int index) {
		return lst.get(index).getName();
	}

	@Override
	public int getSize() {
		return lst.size();
	}

	public Customer getInfo(int cusSelected) {
		return lst.get(cusSelected);
	}

}

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

import MCModels.Product;

public class ProductList extends AbstractListModel<String>{
	private ArrayList<Product> lst = new ArrayList();
	
	public ProductList() {
		lst = ProductIO.readFile();
	}
	
	public void fireChange() {
		lst = ProductIO.readFile();
		fireContentsChanged(this, 0, getSize());
	}
	

	public Product getInfo(int index) {
		return lst.get(index);
	}
	
	@Override
	public String getElementAt(int arg0) {
		return lst.get(arg0).getName();
	}

	@Override
	public int getSize() {
		return lst.size();
	}

}


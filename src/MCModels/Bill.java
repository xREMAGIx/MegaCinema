/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import java.util.ArrayList;
import MCControllers.CustomerType;
/**
 *
 * @author Huynh Ha Vy
 */



public class Bill extends Customer{
	private ArrayList<BuyProduct> lstProduct = new ArrayList<>();

	public Bill() {
		super();
	}

	public Bill(int iD, String name, String address, CustomerType type) {
		super(iD, name, address, type);
	}
	
	public ArrayList<BuyProduct> getList() {
		return lstProduct;
	}
	
	public void add(BuyProduct b) {
		lstProduct.add(b);
	}
	
	
	
}


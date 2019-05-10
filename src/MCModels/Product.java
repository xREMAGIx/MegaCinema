/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

/**
 *
 * @author Huynh Ha Vy
 */
import java.io.Serializable;

public class Product implements Serializable{
	private int ID;
	private String name;
	private long price;

	public Product(int iD, String name, long price) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}


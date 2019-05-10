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
public class BuyProduct extends Product {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BuyProduct() {
	}

	public BuyProduct(int iD, String name, long price) {
		super(iD, name, price);
	}

	public BuyProduct(int iD, String name, long price, int quantity) {
		super(iD, name, price);
		this.quantity = quantity;
	}

   // public boolean getQuantity() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

}

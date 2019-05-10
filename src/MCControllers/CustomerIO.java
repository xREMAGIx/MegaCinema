/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import MCModels.Customer;

/**
 *
 * @author Huynh Ha Vy
 */
public class CustomerIO {
    public static void writeFile(ArrayList<Customer> lst) {
			try {
				ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("customer.dat"));
				o.writeObject(lst);
			} catch (Exception e) {
			}
		}
		
		public static ArrayList<Customer> readFile() {
			ArrayList<Customer> lst = new ArrayList();
			try {
				ObjectInputStream o = new ObjectInputStream(new FileInputStream("customer.dat"));
				lst = (ArrayList<Customer>) o.readObject();
			} catch (Exception e) {
			}
			return lst;
		}
}

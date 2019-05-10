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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import MCModels.Bill;

public class BillIO {
	public static void writeFile(ArrayList<Bill> lst) {
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("bill.dat"));
			o.writeObject(lst);
		} catch (Exception e) {
		}
	}
	
	public static ArrayList<Bill> readFile() {
		ArrayList<Bill> lst = new ArrayList();
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream("bill.dat"));
			lst = (ArrayList<Bill>) o.readObject();
		} catch (Exception e) {
		}
		return lst;
	}

    
}

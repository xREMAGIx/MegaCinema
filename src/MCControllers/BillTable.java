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
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.AbstractTableModel;

import MCModels.BuyProduct;

public class BillTable extends AbstractTableModel{
	private ArrayList<BuyProduct> lst = new ArrayList<>();
	String[] columns = {"Mặt hàng", "Số lượng", "Giá"}; 
	
	public BillTable() {
		
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return lst.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		BuyProduct b = lst.get(rowIndex);
		switch (colIndex) {
		case 0:
			return b.getName();
		case 1:
			return b.getQuantity();
		case 2:
			return b.getPrice() * b.getQuantity(); 
		}
		return null;
	}
	
	public void setList(ArrayList<BuyProduct> lst) {
		this.lst = lst;
	}

    //public void setList(ArrayList<BuyProduct> list) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
	
	
	
	
}

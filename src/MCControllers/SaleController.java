/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Sale;
import MCModels.Ticket;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SaleController {

    Sale saleM = new Sale();
    
    public int add(Sale sale) {
        return saleM.insert(sale);
    }

    public int modify(Sale sale) {
        return saleM.update(sale);
    }

    public int delete(int ID) {
        return saleM.delete(ID);
    }

    public boolean doSale(List<Ticket> tickets, Sale sale) {
        return saleM.doSale(tickets, sale);
    }

    public List<Sale> select(String condt) {
        return saleM.select(condt);
    }

    public List<Sale> selectAll() {
        return saleM.select("");
    }

}

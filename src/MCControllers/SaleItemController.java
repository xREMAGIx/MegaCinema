/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.SaleItem;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SaleItemController {

    public SaleItem saleItemM = new SaleItem();

    public int add(SaleItem saleItem) {
        return saleItemM.insert(saleItem);
    }

    public int modify(SaleItem saleItem) {
        return saleItemM.update(saleItem);
    }

    public int delete(int ID) {
        return saleItemM.delete(ID);
    }

    public List<SaleItem> select(String condt) {
        return saleItemM.select(condt);
    }

    public List<SaleItem> selectAll() {
        return saleItemM.select("");
    }

}

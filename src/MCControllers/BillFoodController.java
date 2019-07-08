/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.BillFood;
import java.util.Date;

import java.util.List;

/**
 *
 * @author USER
 */
public class BillFoodController {

    private final BillFood billfoodM = new BillFood();

    public int insertBillFood(int id, int empId, int cinemaId, Date time, int total) {
        BillFood billfood = new BillFood();
        billfood.setId(id);
        billfood.setEmpId(empId);
        billfood.setCinemaId(cinemaId);
        billfood.setTime(time);
        billfood.setTotal(total);

        return billfoodM.Insert(billfood);
    }

    public int updateBillFood(int id, int empId, int cinemaId, Date time, int total) {
        BillFood billfood = new BillFood();
        billfood.setId(id);
        billfood.setEmpId(empId);
        billfood.setCinemaId(cinemaId);
        billfood.setTime(time);
        billfood.setTotal(total);

        return billfoodM.Update(billfood);
    }

    public int deleteBillFood(int id) {
        return billfoodM.Delete(id);

    }

    public List<BillFood> loadBillFoods() {
        return billfoodM.Select("");
    }

    public List<BillFood> Select(String condt) {
        return billfoodM.Select(condt);
    }

    public int getNextID() {
        return billfoodM.getNextID();
    }
}

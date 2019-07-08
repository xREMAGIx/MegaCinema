/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.FoodDetail;
import java.util.List;

/**
 *
 * @author USER
 */
public class FoodDetailController {

    private final FoodDetail fooddetailM = new FoodDetail();

    public int insertFoodDetail(int id, int billId, int productId, int price, int quantity) {
        FoodDetail fooddetail = new FoodDetail();
        fooddetail.setId(id);
        fooddetail.setBillId(billId);
        fooddetail.setProductId(productId);
        fooddetail.setPrice(price);
        fooddetail.setQuantity(quantity);

        return fooddetailM.Insert(fooddetail);
    }

    public int updateFoodDetail(int id, int billId, int productId, int price, int quantity) {
        FoodDetail fooddetail = new FoodDetail();
        fooddetail.setId(id);
        fooddetail.setBillId(billId);
        fooddetail.setProductId(productId);
        fooddetail.setPrice(price);
        fooddetail.setQuantity(quantity);

        return fooddetailM.Update(fooddetail);
    }

    public int deleteFoodDetail(int id) {
        return fooddetailM.Delete(id);

    }

    public List<FoodDetail> loadFoodDetails() {
        return fooddetailM.Select("");
    }

    public List<FoodDetail> Select(String condt) {
        return fooddetailM.Select(condt);
    }

    public int getNextID() {
        return fooddetailM.getNextID();
    }
}

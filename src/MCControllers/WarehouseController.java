/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;


import MCModels.Warehouse;
import java.util.List;

/**
 *
 * @author USER
 */
public class WarehouseController {
    private final Warehouse warehouseM = new Warehouse();
    
  
    
    public int insertWarehouse(int id, int cinema)
    {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        warehouse.setCinemaId(cinema);
        
        
        return warehouseM.Insert(warehouse);
    }
    
    public int updateWarehouse(int id, int cinema)
    {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        warehouse.setCinemaId(cinema);
        return warehouseM.Update(warehouse); 
    }
    
    public int deleteWarehouse (int id){
        return warehouseM.Delete(id);
        
    }
    
    public List <Warehouse> loadWarehouses(){
        return warehouseM.Select("");
    }
    
    public int getNextID(){
        return warehouseM.getNextID();
    }
}

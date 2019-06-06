/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;


import MCModels.Storage;
import java.util.List;

/**
 *
 * @author USER
 */
public class StorageController {
    private final Storage storageM = new Storage();
    
  
    
    public int insertStorage(int id, int wareId, String product, int quantity, int unit)
    {
        Storage storage = new Storage();
        storage.setId(id);
        storage.setWarehouseId(wareId);
        storage.setProductName(product);
        storage.setQuantity(quantity);
        storage.setUnit(unit);
        
        return storageM.Insert(storage);
    }
    
    public int updateStorage(int id, int wareId, String product, int quantity, int unit)
    {
        Storage storage = new Storage();
        storage.setId(id);
        storage.setWarehouseId(wareId);
        storage.setProductName(product);
        storage.setQuantity(quantity);
        storage.setUnit(unit);
        
        return storageM.Update(storage); 
    }
    
    public int deleteStorage (int id){
        return storageM.Delete(id);
        
    }
    
    public List <Storage> loadStorages(){
        return storageM.Select("");
    }
    
    public List <Storage> loadProducts(){
        return storageM.SelectProduct("");
    }
//    public int getNextID(){
//        return storageM.getNextID();
//    }
    
    public int AddQuantity(int id, int wareId, int add)
    {
        Storage storage = new Storage();
        storage.setId(id);
        storage.setWarehouseId(wareId);
       
      
        
        return storageM.Add(storage, add);
    }
    
    public String IDtoName(int id){
        return storageM.IDtoName(id);
    }
    
    public int SelectQuantity(int id, int warehouse){
        return storageM.selectQuan(id, warehouse);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Unit;
import java.util.List;

/**
 *
 * @author USER
 */
public class UnitController {
     private final Unit unitM = new Unit();
     
     public List <Unit> loadUnit(){
        return unitM.Select("");
    }
}

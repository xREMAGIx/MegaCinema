/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Status;
import java.util.List;

/**
 *
 * @author USER
 */
public class StatusController{
     private final Status statusM = new Status();
     
     public List <Status> select(){
        return statusM.Select("");
    }
}

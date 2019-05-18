/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Schedule;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ScheduleController {
    
    private final Schedule scheduleM = new Schedule();
    
    public int Add(Schedule schedule)
    {
        return scheduleM.Insert(schedule);
    }
    
    public int Modify(Schedule schedule)
    {
        return scheduleM.Update(schedule);        
    }
    
    public int Delete(int id)
    {
        return scheduleM.Delete(id);
    }
    
    public List<Schedule> SelectAll()
    {
        return scheduleM.Select("");
    }
    
    public List<Schedule> Select(String condt)
    {
        return scheduleM.Select(condt);
    }
}

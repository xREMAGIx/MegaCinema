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
    
    public int add(Schedule schedule)
    {
        return scheduleM.insert(schedule);
    }
    
    public int modify(Schedule schedule)
    {
        return scheduleM.update(schedule);        
    }
    
    public int delete(int id)
    {
        return scheduleM.delete(id);
    }
    
    public List<Schedule> selectAll()
    {
        return scheduleM.select("");
    }
    
    public List<Schedule> select(String condt)
    {
        return scheduleM.select(condt);
    }
}

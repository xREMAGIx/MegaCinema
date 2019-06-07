/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.SellReport;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class SellReportController {
    private final SellReport sellreportM = new SellReport();
    
    public int insertSellReport(int id, int cinemaId, Date time, int producttotal, int tickettotal)
    {
        SellReport sellreport = new SellReport();
        sellreport.setId(id);
        sellreport.setCinemaId(cinemaId);
        sellreport.setReportDay(time);
        sellreport.setProductTotal(producttotal);
        sellreport.setTicketTotal(tickettotal);
        
        return sellreportM.Insert(sellreport);
    }
    
    public int updateSellReport(int id, int producttotal, int tickettotal)
    {
        SellReport sellreport = new SellReport();
        sellreport.setId(id);
        sellreport.setProductTotal(producttotal);
        sellreport.setTicketTotal(tickettotal);
        
        return sellreportM.Update(sellreport); 
    }
    
    public int deleteSellReport (int id){
        return sellreportM.Delete(id);
        
    }
    
    
    
    public int getNextID(){
        return sellreportM.getNextID();
    }
    
    public int getCurDayID(Date date){
        return sellreportM.getcurDayId(date);
    }
    
    public List <SellReport> loadAPeriod(Date begin, Date end){
        return sellreportM.SelectAPeriod(begin, end);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Ticket {
 
    private int id;
    private int seatId;
    private int scheduleId;
    private float price;
    private int status;
    private Date lockedTime;
    private String playName;
    private Schedule schedule;
    private Seat seat;
    
    
}

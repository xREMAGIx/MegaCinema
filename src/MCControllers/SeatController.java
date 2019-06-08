/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;


import MCModels.Seat;
import java.util.List;

/**
 *
 * @author USER
 */
public class SeatController {
  	private Seat seatM = new Seat();
	
	public int add(Seat seat){
		return seatM.insert(seat); 		
	}
	
	public int modify(Seat seat){
		return seatM.update(seat); 		
	}
	
	public int delete(int ID){
		return seatM.delete(ID); 		
	}
	
	public List<Seat> select(String condt){
		return seatM.select(condt);		
	}
	
	public List<Seat> selectAll(){
		return seatM.select("");		
	}
	
}

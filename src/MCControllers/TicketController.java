/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Ticket;
import java.util.List;

/**
 *
 * @author DELL
 */
public class TicketController {

    private final Ticket ticketM = new Ticket();

    public int add(Ticket ticket) {
        return ticketM.insert(ticket);
    }

    public int modify(Ticket ticket) {
        return ticketM.update(ticket);
    }

    public int delete(int ID) {
        return ticketM.delete(ID);
    }

    public List<Ticket> select(String condt) {
        return ticketM.select(condt);
    }

    public List<Ticket> selectAll() {
        return ticketM.select("");
    }

    public int lockTicket(int ID, String time) {
        return ticketM.lockTicket(ID, time);
    }

    public int unlockTicket(int ID) {
        return ticketM.unlockTicket(ID);
    }
}

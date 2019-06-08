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
        return ticketM.Insert(ticket);
    }

    public int modify(Ticket ticket) {
        return ticketM.Update(ticket);
    }

    public int delete(int ID) {
        return ticketM.Delete(ID);
    }

    public List<Ticket> Select(String condt) {
        return ticketM.Select(condt);
    }

    public List<Ticket> SelectAll() {
        return ticketM.Select("");
    }

    public int lockTicket(int ID, String time) {
        return ticketM.LockTicket(ID, time);
    }

    public int unlockTicket(int ID) {
        return ticketM.UnlockTicket(ID);
    }
}

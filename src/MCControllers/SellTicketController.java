/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Sale;
import MCModels.Schedule;
import MCModels.Seat;
import MCModels.Ticket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SellTicketController {

    private List<Ticket> ticketList;

    SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Ticket makeNewTicket(Schedule sched, Seat seat) {
        Ticket ticket = new Ticket();
        ticket.setSeatId(seat.getId());
        ticket.setScheduleId(sched.getId());
        ticket.setPrice((float) sched.getPrice());
        ticket.setStatus(0);
        ticket.setSchedule(sched);
        ticket.setSeat(seat);
        ticket.setMovieName(new MovieController().select("movieId=" + sched.getMovieId()).get(0).getName());
        new TicketController().add(ticket);
        return ticket;
    }

    public void makeNewSale() {
        ticketList = new ArrayList<Ticket>();
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
        Date date = new Date();
        TicketController ticketC = new TicketController();
        ticketC.lockTicket(ticket.getId(), pFormatter.format(date));
        ticket.setCurrentLockedTime(date);
    }

    public void removeTicket(Ticket ticket) {
        ticketList.remove(ticket);
        TicketController ticketC = new TicketController();
        ticketC.unlockTicket(ticket.getId());
        ticket.setCurrentLockedTime(null);
        ticketC.delete(ticket.getId());
    }

    public void removeAllTicket() {
        for (Ticket item : ticketList) {
            TicketController ticketC = new TicketController();
            ticketC.unlockTicket(item.getId());
            item.setCurrentLockedTime(null);
        }
        ticketList.removeAll(ticketList);
    }

    public String getInfo() {
        int i = 0;
        double price = 0;
        String info = "";
        for (Ticket t : ticketList) {
            info += "Movie：" + t.getMovieName() + "\n";
            info += "Time：" + pFormatter.format(t.getSchedule().getTime()) + "\n";
            info += "Seat：Row " + t.getSeat().getRow() + " Column " + t.getSeat().getColumn() + "\n";
            info += "Price：" + t.getSchedule().getPrice() + " dollar\n\n";
            i++;
            price += t.getSchedule().getPrice();
        }
        if (ticketList.size() > 0) {
            info += "=================\n";
            info += "Total " + i + "Ticket(s)  " + price + "dollar\n";
        }
        return info;
    }

    public boolean isTicketSelected(Ticket ticket) {
        for (Ticket t : ticketList) {
            if (t.getId() == ticket.getId()) {
                return true;
            }
        }
        return false;
    }

    public void clearSale() {
        while (ticketList.size() > 0) {
            removeTicket(ticketList.get(0));
        }
        makeNewSale();
    }

    public boolean doSale(Sale sale) {
        if (new SaleController().doSale(ticketList, sale)) {
            makeNewSale();
            return true;
        }
        return false;
    }
}

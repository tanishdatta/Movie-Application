package com.project.ticketApp;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class TicketController {
    private MainController parentController;
    private TicketGUI gui;
    private Ticket ticket;

    public TicketController(MainController parentController){

        this.parentController = parentController;
    }
    public void viewTicket(int ticketID){
        try {
            this.ticket = TicketsSingleton.getInstance().verifyTicket(ticketID);
            if(ticket == null){
                Dialog notify = new Dialog();
                notify.add(new Paragraph("Ticket Does Not Exist"));
                notify.open();
            }
            else{
                viewTicket(ticket);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void viewTicket(Ticket tick) {
        //this.ticket = tick;
        this.gui = new TicketGUI(this, tick);
        gui.open();

        //called by main controller
        //verify ticketID using ticketsingleton (receive ticket obj)
        //set this.ticket = shit you got from singleton
        //instantiate ticketGUI, passing in this and ticket
    }
    public void refundTicket(){
        System.out.println("Checking if showtime has proper date: "+ (ticket.getShowtime().getTime() != null));
        try {
            if(!ticket.getShowtime().getTime().isBefore(LocalDateTime.now().plusDays(3))){
                Dialog notify = new Dialog();
                notify.add(new Paragraph("Ticket is refunded"));
                notify.open();
                Credit credit = CreditSingleton.getInstance().createCredit(ticket.getPrice());
                this.gui.displayRefundCode(credit.getCreditCode(), ticket.getPrice());
                TicketsSingleton.getInstance().deleteTicket(ticket);
            }
            else{
                this.gui.nonRefundable();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        //called by ticket gui
        //verify if ticket is refundable (not within 72 hrs)
            //note: ticket should already have been set by viewticket
        //check to see if showtime attribute in ticket is within 72 hours
        //if not refundable, call nonrefundable in ticketgui
        //if refundable, show confirmation dialog (mention 15% admin fee if regular user), get confirmation
        // then get price from ticket and create new credit using credit singleton
        //use ticket singleton to delete ticket
        //get credit code from credit
        //call displayrefundcode in ticketgui, passing in credit code and amount refunded
    }
    

}
package com.project.ticketApp;

public class TicketController {
    private MainController parentController;
    private TicketGUI gui;
    private Ticket ticket;

    public TicketController(MainController parentController){
        this.parentController = parentController;
    }
    public void viewTicket(int ticketID){
        //called by main controller
        //verify ticketID using ticketsingleton (receive ticket obj)
        //set this.ticket = shit you got from singleton
        //instantiate ticketGUI, passing in this and ticket
    }
    public void refundTicket(){
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
package com.project.ticketApp;

public class TicketController {
    private MainController parentController;
    private TicketGUI gui;

    public TicketController(MainController parentController){
        this.parentController = parentController;
    }
    public void viewTicket(int ticketID){
        //called by main controller
        //verify ticketID using ticketsingleton (receive ticket obj)
        //instantiate ticketGUI, passing in this and ticket
    }
    public void refundTicket(Ticket ticket){
        //called by ticket gui
        //verify if ticket is refundable (not within 72 hrs)
        //check to see if showtime attribute in ticket is within 72 hours
        //if not refundable, call nonrefundable in ticketgui
        //if refundable, get price from ticket and generate credit
        //place credit in credit singleton
        //use ticket singleton to delete ticket
        //get credit code from credit
        //call displayrefundcode in ticketgui, passing in credit code
    }

}
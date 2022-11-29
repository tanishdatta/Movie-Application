package com.project.ticketApp;

public class TicketController {
    private MainController parentController;
    private TicketGUI gui;

    public TicketController(MainController parentController){
        //set parent control

    }
    public void viewTicket(int ticketID){
        //called by main controller
        //verify ticketID using ticketsingleton (receive ticket obj)
        //instantiate ticketGUI, passing in this and ticket
    }
    public void refundTicket(Ticket ticket){
        //called by ticket gui
        //verify if ticket is refundable (not within 72 hrs) with singleton
        //if not refundable, call nonrefundable in ticketgui
        //if refundable, get price from ticket and generate credit
        //place credit in credit singleton
        //
    }
    private void makeGUI(Ticket ticket){}

}
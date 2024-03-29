package com.project.ticketApp;
//stub done

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter.*;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TicketGUI extends Dialog {
    private Ticket ticket;
    private TicketController parentController;

    //start components...
    VerticalLayout ticketDisplay = new VerticalLayout();
    Button refund = new Button("Refund Ticket");
    Button done = new Button("Done");
    Paragraph refundPara;
    //end componentes

    //start important functs...
    public TicketGUI(TicketController parentController, Ticket ticket){
        this.ticket = ticket;
        this.parentController = parentController;
        initTicketDisplay();//prints out ticket information
        initRefundButton();//build a refund button
    }
    public void refundTicket(){
        parentController.refundTicket();
    }

    public void nonRefundable(){
        Dialog nonRefundable = new Dialog();
        nonRefundable.add(new Paragraph("Sorry, tickets can only be refunded a minimum of 72 hrs before show.  Enjoy your movie!"));
        nonRefundable.open();
    }

    public void displayRefundCode(int refundCode, int refundAmount){
        refundPara = new Paragraph("Your refund code is: " + refundCode + ". Amount refunded is: "+ refundAmount);
        add(refundPara);
    }
    //end important functs
    
    //start helper functs...
    private void initTicketDisplay() {
        
        ticketDisplay.add(new Paragraph("Movie: "+ ticket.getShowtime().getMovie().getMovie().getMovieName()));
        ticketDisplay.add(new Paragraph("Theatre: "+ ticket.getShowtime().getMovie().getTheatre().getName()));
        //add date time formatter later
        String [] stuff = ticket.getShowtime().getTime().toString().split("T");
        String display = "\nDate: " + stuff[0] + "\n" + "Time: " + stuff[1];
        ticketDisplay.add(new Paragraph(display));
        //ticketDisplay.add(new Paragraph("Showtime: "+ ticket.getShowtime().getTime()));
        ticketDisplay.add(new Paragraph("Seat: "+ IntToChar.convert(ticket.getxCoord())+ticket.getyCoord()));
        ticketDisplay.add(new Paragraph("TicketID: "+ ticket.getTicketID()));
        add(ticketDisplay);
    }
    private void initRefundButton() {
        refund.addClickListener(ClickEvent ->{refundTicket();});
        add(refund);
        done.addClickListener(ClickEvent ->{this.close();});
        add(done);
    }
    //end helper functs
}

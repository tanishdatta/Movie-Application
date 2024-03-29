package com.project.ticketApp;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

public class SeatController implements PaymentObserver{
    private Showtime showtime;
    private int ticketPrice = 300;//hardcoded ticket price
    private RegisteredUser user;
    private int xCoord;
    private int yCoord;
    private SeatGUI seatgui;
    private MainController parentController;

    //needs to add itself to paymentObserver

    public SeatController(RegisteredUser user, Showtime showtime, MainController parent){
        //set parent control
        //set user
        //set showtime
        //set seatcapstrategy depending on whether or not user is null
        //get 2d arraylist from showtime
        //if bookable, instantiate seatgui, passing in 2d arraylist and this
        this.parentController = parent;
        this.showtime = showtime;
        this.user = user;
        ArrayList<ArrayList<Boolean>> seatTable = showtime.getSeatArray();
        seatgui = new SeatGUI(seatTable, this);
        seatgui.open();
        

    }
    public void selectSeat(int xCoord, int yCoord){
        //called by seatgui
        //set x and y coordinates
        //instantiate payment controller, passing in user and price
        for (int y = 0; y < showtime.getSeatArray().size(); y++){
            for (int x= 0; x < showtime.getSeatArray().get(y).size(); x++){
                
                if(  y == yCoord && x == xCoord){
                    this.yCoord = yCoord;
                    this.xCoord = xCoord;
                    if(showtime.getSeatArray().get(y).get(x) == false){

                        if (user == null){
                            new PaymentController(ticketPrice, this);// guest user pays first then update array list in show time
                        }
                        else {
                            new PaymentController(user, ticketPrice, this);// RU pays first then update array list in show time
                        }
                       
                    }
                    else{
                        //change this to is display it to seatGUI instead
                        Dialog notify = new Dialog();
                        notify.add(new Paragraph("Please pick another seat"));
                        notify.open();
                    }
                }
            }
        }
    }
    @Override
    public void paymentGood() {
        //call showtime obj, passing in coords
        //show confirmation dialog
        Ticket tick = null;
        showtime.setSeatOccupied(xCoord, yCoord);// updates showtime arraylist
        try {
            tick = TicketsSingleton.getInstance().createTicket(xCoord, yCoord, showtime, ticketPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TicketController tickCon = new TicketController(parentController);
        tickCon.viewTicket(tick);
        
        
    }
    
}

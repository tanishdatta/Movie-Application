package com.project.ticketApp;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

public class SeatController implements PaymentObserver{
    private Showtime showtime;
    private int ticketPrice = 300;
    private RegisteredUser user;
    private int xCoord;
    private int yCoord;
    private SeatGUI seatgui;

    //needs to add itself to paymentObserver

    public SeatController(RegisteredUser user, Showtime showtime){
        //set parent control
        //set user
        //set showtime
        //set seatcapstrategy depending on whether or not user is null
        //get 2d arraylist from showtime
        //if bookable, instantiate seatgui, passing in 2d arraylist and this

        this.showtime = showtime;
        this.user = user;
        ArrayList<ArrayList<Boolean>> seatTable = showtime.getSeatArray();
        /*for (ArrayList<Boolean> row : seatTable){
            for (Boolean seat : row){
                System.out.print(seat.booleanValue());
                System.out.print(" ");
            }
            System.out.println();
        }*/
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
        
        showtime.setSeatOccupied(xCoord, yCoord);// updates showtime arraylist

        Dialog notify = new Dialog();
        notify.add(new Paragraph("Seat chosen"));
        notify.addDialogCloseActionListener(CloseAction -> seatgui.close());
        notify.open();
    }
    
}

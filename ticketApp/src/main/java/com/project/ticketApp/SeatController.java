package com.project.ticketApp;

import java.util.ArrayList;

public class SeatController implements PaymentObserver{
    private Showtime showtime;
    private int ticketPrice = 300;
    private RegisteredUser user;
    private int xCoord;
    private int yCoord;
    private SeatCapStrategy seatCapStrat;

    //needs to add itself to paymentObserver

    public SeatController(RegisteredUser user, Showtime showtime){
        //set parent control
        //set user
        //set showtime
        //set seatcapstrategy depending on whether or not user is null
        //get 2d arraylist from showtime
        //check if showtime is bookable using seatCapStrat
        //if bookable, instantiate seatgui, passing in 2d arraylist and this

        this.showtime = showtime;
        this.user = user;
        ArrayList<ArrayList<Boolean>> SeatTable = showtime.getSeatArray();

    }
    public void selectSeat(int xCoord, int yCoord){
        //called by seatgui
        //set x and y coordinates
        //instantiate payment controller, passing in user and price
        for (int y = 0; y < showtime.getSeatArray().size(); y++){
            for (int x= 0; x < showtime.getSeatArray().get(y).size(); x++){
                
                if(  y == yCoord && x == xCoord){
                    if(showtime.getSeatArray().get(y).get(x) == false){
                        showtime.setSeatOccupied(xCoord, yCoord);
                        new PaymentController(user, ticketPrice);
                    }
                    else{
                        //change this to is display it to seatGUI instead
                        System.out.println("Please pick another seat");
                    }
                }
            }
        }
    }
    @Override
    public void paymentGood() {
        //call selectSeat in showtime obj, passing in coords
        //show confirmation dialog
        
    }
}

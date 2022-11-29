package com.project.ticketApp;

<<<<<<< Updated upstream
public class SeatController {

=======
public class SeatController implements PaymentObserver{
    private Showtime showtime;
    private int ticketPrice;
    private RegisteredUser user;
    private int xCoord;
    private int yCoord;
    private SeatCapStrategy seatCapStrat;

    public SeatController(RegisteredUser user, Showtime showtime){
        //set parent control
        //set user
        //set showtime
        //set seatcapstrategy depending on whether or not user is null
        //get 2d arraylist from showtime
        //check if showtime is bookable using seatCapStrat
        //if bookable, instantiate seatgui, passing in 2d arraylist and this

    }
    public void selectSeat(int xCoord, int yCoord){
        //called by seatgui
        //instantiate payment controller, passing in user and price
    }
    @Override
    public void paymentGood() {
        //call selectSeat in showtime obj, passing in coords
        //show confirmation dialog
        
    }
>>>>>>> Stashed changes
}

package com.project.ticketApp;

public class Ticket {

    private int seatXCoord; 
    private int seatYCoord;
    private Showtime showtime;
    private int price = 300;
    private int ticketID;
    
    //Remember to add ticket notification (email or pop up)

    public Ticket(int xCoord, int yCoord, Showtime showtime, int price){
    
    }

    public int getSeatNum(){
        return (Integer) null;
    }

    public Showtime getShowtime(){
        return showtime;
    }

    public int getPrice(){
        return price;
    }

    
}

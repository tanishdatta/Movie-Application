package com.project.ticketApp;

public class Ticket {

    private int xCoord; 
    private int yCoord;
    private Showtime showtime;
    private int price;
    private int ticketID;
    
    //Remember to add ticket notification (email or pop up)

    public Ticket(int xCoord, int yCoord, Showtime showtime, int ticketID, int price){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.showtime = showtime;
        this.ticketID = ticketID;
        this.price = price;
        
    }
    public int getTicketID(){
        return this.ticketID;
    }
    
    public Showtime getShowtime(){
        return showtime;
    }

    public int getPrice(){
        return price;
    }
    
    public int getxCoord() {
        return xCoord;
    }
    public int getyCoord() {
        return yCoord;
    }
    
    
}

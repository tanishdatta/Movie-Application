package com.project.ticketApp;

public class Ticket {

    private int xCoord; 
    private int yCoord;
    private Showtime showtime;
    private int price = 15;
    private int ticketID;
    
    //Remember to add ticket notification (email or pop up)

    public Ticket(int xCoord, int yCoord, Showtime showtime, int ticketID){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.showtime = showtime;
        this.ticketID = ticketID;
        
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

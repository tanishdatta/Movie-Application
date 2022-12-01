package com.project.ticketApp;

public class TicketsSingleton extends Singleton<Ticket> {

    private static TicketsSingleton instance;

    public static TicketsSingleton getInstance(){
        return instance;
    }

    private TicketsSingleton(){

    }

    public Ticket verifyTicket(int ticketID){
        //if ticket id is in arr than return that ticket
        //else return null
        return null;
    }

    public Ticket createTicket(Showtime showtime){
        //makes a ticket based on showtime and adds it to the database and to the arraylist
        return null;
    }


    public int getNextID() {
        int maybeID = arr.size();
        int nextID;

        while(true) {
            nextID = maybeID;
            for (Ticket e : arr) {
                if (e.getTicketID() == maybeID) {
                    maybeID++;
                }
            }
            if(maybeID != nextID){
                nextID = maybeID;
            }
            else{
                break;
            }
        }
        //counts number of objects in arraylist
        //check if that number is already taken as id
        //if not keep incrementing one until valid ID found
        return nextID;
    }
}

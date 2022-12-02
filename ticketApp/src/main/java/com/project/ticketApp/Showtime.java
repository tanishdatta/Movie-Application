package com.project.ticketApp;
//stub finished
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Showtime {
   private ArrayList<ArrayList<Boolean>> seatOccupied;
   private OfferedMovie movie;
   private LocalDateTime time;

   public Showtime(ArrayList<ArrayList<Boolean>> seats, LocalDateTime time){
    this.seatOccupied = seats;
    this.time = time;
    this.movie = movie;
   }
   public ArrayList<ArrayList<Boolean>> getSeatArray(){
    return this.seatOccupied;
   }
   public void setSeatOccupied(int x, int y){// true means occupied
       //set designated seat as true
       //For seatOccupied arraylist of boolean objects.
       // Designates which seats are free and which are empty. o
       // Outside arraylist is y axis and inside arraylist is x axis
   }

   public LocalDateTime getTime(){
        return time;
   }
   public OfferedMovie getMovie(){
    return movie;
   }
   public void setMovie(OfferedMovie movie){
    this.movie = movie;
   }
}

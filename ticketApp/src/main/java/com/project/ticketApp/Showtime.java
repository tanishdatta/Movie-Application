package com.project.ticketApp;
//stub finished
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Showtime {
   private ArrayList<ArrayList<Boolean>> seatOccupied;
   private LocalDateTime time;
   public ArrayList<ArrayList<Boolean>> getSeatArray(){
    return this.seatOccupied;
   }
   public void setSeatOccupied(int x, int y){
       //set designated seat as true
       //For seatOccupied arraylist of boolean objects.
       // Designates which seats are free and which are empty. o
       // Outside arraylist is y axis and inside arraylist is x axis
   }
   public Showtime(ArrayList<ArrayList<Boolean>> seatOccupied){
       this.seatOccupied = seatOccupied;
   }
}

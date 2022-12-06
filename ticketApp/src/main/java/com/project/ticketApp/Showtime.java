package com.project.ticketApp;
import java.sql.SQLException;
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
   }
   public LocalDateTime getTime(){
    return time;
   }
   public OfferedMovie getMovie(){
    return movie;
   }

   public Showtime(ArrayList<ArrayList<Boolean>> seatOccupied){
    this.seatOccupied = seatOccupied;
    }

   public ArrayList<ArrayList<Boolean>> getSeatArray(){
    return this.seatOccupied;
    }

   public void setSeatOccupied(int xCoord, int yCoord){// true means occupied
       //set designated seat as true
       //For seatOccupied arraylist of boolean objects.
       // Designates which seats are free and which are empty. o
       // Outside arraylist is y axis and inside arraylist is x axis
       for ( int y = 0; y < seatOccupied.size(); y++ ){
        for(int x = 0; x< seatOccupied.get(y).size(); x++){

            if ( x == xCoord && y == yCoord){
                seatOccupied.get(y).set(x, true);
                try{
                    System.out.println(movie.getMovie().getMovieName());
                    TheatresSingleton.getInstance().setSeat(movie.getMovie().getMovieName(),movie.getTheatre().getName(), time, xCoord, yCoord);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
       }
    }
public void setMovie(OfferedMovie offeredMovie) {
    this.movie = offeredMovie;
}


}

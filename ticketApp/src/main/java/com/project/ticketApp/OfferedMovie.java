package com.project.ticketApp;

import java.util.ArrayList;

public class OfferedMovie {
private Movie movie;
private Theatre theatre; 
private ArrayList<Showtime> showtimes;

public OfferedMovie(ArrayList<Showtime> showtimes, Movie movie){
    this.showtimes = showtimes;
    this.movie = movie;
    for (Showtime s : showtimes){
        s.setMovie(this);
    }
}
public ArrayList <Showtime> getShowtimes(){
    return showtimes; 
}
public Movie getMovie(){
    return movie;
}

public void addShowtime(Showtime showtime){
    this.showtimes.add(showtime);
}
public void setTheatre(Theatre theatre){
    this.theatre = theatre;
}
public Theatre getTheatre(){
    return theatre;
}

}

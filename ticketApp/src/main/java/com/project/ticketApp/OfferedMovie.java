package com.project.ticketApp;

import java.util.ArrayList;

public class OfferedMovie {
private Movie movie; 
private ArrayList<Showtime> showtimes;

public ArrayList <Showtime> getShowtimes(){
    return showtimes; 
}
public OfferedMovie(ArrayList<Showtime> showtimes){
    this.showtimes = showtimes;
}
public void addShowtime(Showtime showtime){
    this.showtimes.add(showtime);
}

}

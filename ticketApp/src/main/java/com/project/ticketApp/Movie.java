package com.project.ticketApp;

import java.time.LocalDate;

public class Movie {
private LocalDate announcementDate;
private String movieName; 

//Constructor
public Movie(LocalDate releaseDate, String movieName){
    this.announcementDate = releaseDate;
    this.movieName = movieName;
}

//getters
public LocalDate getAnnouncementDate(){
    return announcementDate;
}

public String getMovieName(){
    return movieName;
}
}

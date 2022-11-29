package com.project.ticketApp;

import java.time.LocalDate;

public class Movie {
private LocalDate releaseDate;
private String movieName; 

//Constructor
public Movie(LocalDate releaseDate, String movieName){
    this.releaseDate = releaseDate;
    this.movieName = movieName;
}

//getters
public LocalDate getReleasedDate(){
    return releaseDate;
}

public String getMovieName(){
    return movieName;
}
}

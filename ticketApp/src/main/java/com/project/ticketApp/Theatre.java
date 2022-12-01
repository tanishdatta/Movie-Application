package com.project.ticketApp;
//Stub Finished
import java.util.ArrayList;

public class Theatre {
    private ArrayList<OfferedMovie> availableMovies;
    public ArrayList<OfferedMovie> getAvailableMovies(){
        return this.availableMovies;
    }
    public void addOfferedMovie(OfferedMovie movie){
        availableMovies.add(movie);
    }

    public Theatre(ArrayList<OfferedMovie> availableMovies){
        this.availableMovies = availableMovies;
    }
}

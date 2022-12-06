package com.project.ticketApp;
//Stub Finished
import java.util.ArrayList;

public class Theatre {
    private ArrayList<OfferedMovie> availableMovies;
    private String theatreName;

    public Theatre(String theatreName, ArrayList<OfferedMovie> availableMovies){
        this.theatreName = theatreName;
        this.availableMovies = availableMovies;
        if (availableMovies.size() >0){
            for (OfferedMovie om : availableMovies){
                om.setTheatre(this);
            }
        }
        
    }
    
    public ArrayList<OfferedMovie> getAvailableMovies(){
        return this.availableMovies;
    }
    public void addOfferedMovie(OfferedMovie movie){
        availableMovies.add(movie);
    }

    
    public String getName(){
        return theatreName;
    }
}

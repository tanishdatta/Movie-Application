package com.project.ticketApp;

import java.util.ArrayList;

public class TheatresSingleton extends Singleton<Theatre> {
    private static TheatresSingleton instance;

    private TheatresSingleton(){
        //Create array list of theatres
        //For each theatre find all offeredMovies where the theatre name is the same
            //IN FOR LOOP DO THE FOLLOWING
            //Find all movies in movieSingleton array(arr) with same string/name
            //Find showtimes in database for that offeredmovie in this theatre
        //          (Instantiate Showtimes objects in arraylist to pass to offeredmovie or add each showtime to already created offeredmovie object)
            //Instantiate offeredmovie object with movie object and showtimes in theatre objects array (availableMovies)
    }
    public static TheatresSingleton getInstance(){
        return instance;
    }
    public ArrayList<Theatre> getAllTheatres(){
        return arr;
    }
}

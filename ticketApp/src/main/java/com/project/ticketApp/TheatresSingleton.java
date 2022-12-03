package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TheatresSingleton extends Singleton<Theatre> {
    private static TheatresSingleton instance;

    private TheatresSingleton(){
        //sorry to whoever is coding this =(
        //Create array list of theatres
        //For each theatre find all offeredMovies where the theatre name is the same
            //IN FOR LOOP DO THE FOLLOWING
            //Find all movies in movieSingleton array(arr) with same string/name
            //Find showtimes in database for that offeredmovie in this theatre
                // (Instantiate Showtimes objects in arraylist to pass to offeredmovie or add each showtime to already created offeredmovie object)
                //don't forget to also pass the offeredmovie into the showtime object so there's two-way aggregation
            //Instantiate offeredmovie object with movie object and showtimes in theatre objects array (availableMovies)
            //holy fuck you also have to pass the theatre back into the offeredmovie to get two way aggregation again
            PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM movie");
            ResultSet rs = selectStatement.executeQuery();
    
            // will traverse through all found rows
            while (rs.next()) {
                String name = rs.getString("name");
                LocalDate announcementDate = rs.getDate("announcement_date").toLocalDate(); 
                Theatre theatre = new Theatre(announcementDate, name);
                arr.add(movie);
            }

    }
    public static TheatresSingleton getInstance(){
        
        if (instance == null) {
            instance = new TheatresSingleton();
        }

        return instance;
        
    }
    public ArrayList<Theatre> getAllTheatres(){
        return arr;
    }
}

package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TheatresSingleton extends Singleton<Theatre> {
    private static TheatresSingleton instance;

    private TheatresSingleton()throws SQLException{
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
            
            //filters out theatres and its offered movies
            
            // PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM theatre AS T, movie AS M, showtime AS S, offered_movie AS OM WHERE T.name = OM.theatre_name");
            // ResultSet rs = selectStatement.executeQuery();

            

            // ArrayList<Showtime> showtime;
            // ArrayList<OfferedMovie> offeredMovies;
            
    
            // // will traverse through all found rows
            // while (rs.next()) {
            //     String name = rs.getString("OM.theatre_name");
            //     String movieName = rs.getString("OM.movie_name");
        
            //     //LocalDate announcementDate = rs.getDate("announcement_date").toLocalDate(); 
                



            //     // offeredMovies.add(new OfferedMovie(showtime, movie)) ;

            //     // Theatre theatre = new Theatre(name, offeredMovies);
            //     // arr.add(theatre);
            // }

    }
    public static TheatresSingleton getInstance() throws SQLException{
        
        if (instance == null) {
            instance = new TheatresSingleton();
        }

        return instance;
        
    }
    public ArrayList<Theatre> getAllTheatres(){
        return arr;
    }
}

package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.vaadin.flow.component.html.Pre;

public class TheatresSingleton extends Singleton<Theatre> {
    private static TheatresSingleton instance;

    private TheatresSingleton()throws SQLException{
       initConnection();
       //getting theatres
       PreparedStatement theatreQuery = con.prepareStatement("SELECT Name FROM Theatre;");
       ResultSet theatreSet = theatreQuery.executeQuery();
       while (theatreSet.next()){
        //making each theatre
        ArrayList<OfferedMovie> omList = new ArrayList<OfferedMovie>();
        String theatreName = theatreSet.getString(1);
        PreparedStatement movieQuery = con.prepareStatement("SELECT movie_name FROM OfferedMovie WHERE theatre_name = ?;");
        movieQuery.setString(1, theatreName);
        ResultSet movieSet = movieQuery.executeQuery();
        while(movieSet.next()){
            //making offeredmovies for each theatre
            ArrayList<Showtime> stList = new ArrayList<Showtime>();
            String movieName = movieSet.getString(1);
            PreparedStatement timeQuery = con.prepareStatement("SELECT date_time FROM Showtime WHERE theatre_name = ? AND movie_name = ?");
            timeQuery.setString(1, theatreName);
            timeQuery.setString(2, movieName);
            ResultSet timeSet = timeQuery.executeQuery();
            while(timeSet.next()){
                //making showtimes for each offeredmovie
                Timestamp thisTime = timeSet.getTimestamp(1);
                ArrayList<ArrayList<Boolean>> seatTable = new ArrayList<ArrayList<Boolean>>();
                for (ArrayList<Boolean> row : seatTable){
                    for (Boolean status : row){
                        PreparedStatement seatQuery = con.prepareStatement("SELECT status FROM Seat WHERE theatre_name = ? AND movie_name = ? AND time = ? AND seatXcoord = ? AND seatYcoord = ?;");
                        seatQuery.setString(1, theatreName);
                        seatQuery.setString(2, movieName);
                        seatQuery.setTimestamp(3, thisTime);
                        int xCoord = row.indexOf(status);
                        int yCoord = seatTable.indexOf(row);
                        seatQuery.setInt(4,xCoord);
                        seatQuery.setInt(5,yCoord);
                        ResultSet seatSet = seatQuery.executeQuery();
                        seatSet.next();
                        status = seatSet.getBoolean(1);
                    }
                }
                //construct showtime with seattable and time
                stList.add(new Showtime(seatTable, thisTime.toLocalDateTime()));
            }
            //get movie object for each offeredmovie
            MoviesSingleton mSingleton = MoviesSingleton.getInstance();
            omList.add(new OfferedMovie(stList, mSingleton.getMovie(movieName)));
            //offered movie passed into its children showtimes in constructor
        }
        arr.add(new Theatre(theatreName, omList));
        //theatre passed into its children offeredmovies in constructor
       }
    }
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

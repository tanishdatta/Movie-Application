package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MoviesSingleton extends Singleton<Movie>{
    private static MoviesSingleton instance;

    public static MoviesSingleton getInstance() throws SQLException{
        if (instance == null) {
            instance = new MoviesSingleton();
        }
        return instance;
    }
    private MoviesSingleton() throws SQLException{
        //Instantiate movie objects in arraylist based on database

        
        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM movie");
        ResultSet rs = selectStatement.executeQuery();

        // will traverse through all found rows
        while (rs.next()) {
            String name = rs.getString("name");
            LocalDate announcementDate = rs.getDate("announcement_date").toLocalDate(); 
            Movie movie = new Movie(announcementDate, name);
            arr.add(movie);
        }
    }

    public Movie getMovie(String movieName){
        //Returns Movie object in array that corresponds with given String
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMovieName() == movieName)
                return arr.get(i);
        }
        return null;
    }
    
}

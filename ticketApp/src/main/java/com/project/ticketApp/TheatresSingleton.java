package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class TheatresSingleton extends Singleton<Theatre> {
    private static TheatresSingleton instance;

    private TheatresSingleton()throws SQLException{
       initConnection();
       //do this once and comment it out lol
       /* 
        populateSeats("Star Wars: Episode VII - The Force Awakens","WISH.com_cineplex", "2012-06-18 17:10:10");
        populateSeats("Avengers: Endgame","WISH.com_cineplex", "2012-06-18 13:10:10");
        populateSeats("Spider-Man: No Way Home","WISH.com_cineplex", "2012-06-18 10:00:00");
        populateSeats("Avatar","WISH.com_cineplex", "2012-06-18 06:00:00");
        populateSeats("Top Gun: Maverick","WISH.com_cineplex", "2012-06-18 20:00:00");
        */
       //getting theatres
       PreparedStatement theatreQuery = con.prepareStatement("SELECT Name FROM Theatre;");
       ResultSet theatreSet = theatreQuery.executeQuery();
       while (theatreSet.next()){
        //making each theatre
        ArrayList<OfferedMovie> omList = new ArrayList<OfferedMovie>();
        String theatreName = theatreSet.getString(1);
        PreparedStatement movieQuery = con.prepareStatement("SELECT movie_name FROM offered_movie WHERE theatre_name = ?;");
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
                for (int rowNum = 0; rowNum < 10; rowNum++){
                    ArrayList<Boolean> row = new ArrayList<Boolean>();
                    for (int colNum = 0; colNum < 10; colNum++){
                        Boolean status = false;
                        PreparedStatement seatQuery = con.prepareStatement("SELECT status FROM Seat WHERE theatre_name = ? AND movie_name = ? AND showtime_time = ? AND seatXcoord = ? AND seatYcoord = ?;");
                        seatQuery.setString(1, theatreName);
                        seatQuery.setString(2, movieName);
                        seatQuery.setTimestamp(3, thisTime);
                        seatQuery.setInt(4,colNum);
                        seatQuery.setInt(5,rowNum);
                        ResultSet seatSet = seatQuery.executeQuery();
                        seatSet.next();
                        status = seatSet.getBoolean(1);
                        row.add(status);
                    }
                    seatTable.add(row);
                }
                //construct showtime with seattable and time
                stList.add(new Showtime(seatTable, thisTime.toLocalDateTime()));
            }
            //get movie object for each offeredmovie
            MoviesSingleton mSingleton = MoviesSingleton.getInstance();
            omList.add(new OfferedMovie(stList, mSingleton.getMovie(movieName)));

            // System.out.println(mSingleton.getMovie(movieName).getMovieName());
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

    //this function should only be executed once to set seats in database
    private void populateSeats(String moviename, String theatrename, String datetime) {
        for (int row = 0; row <10; row++){
            for (int column = 0; column<10; column++){
                try{
                    PreparedStatement makeSeat = con.prepareStatement("INSERT INTO Seat (theatre_name, movie_name, showtime_time, seatXcoord, seatYcoord, status) VALUES (?,?,?,?,?,?);");
                    makeSeat.setString(1, theatrename);
                    makeSeat.setString(2, moviename);
                    makeSeat.setTimestamp(3, Timestamp.valueOf(datetime));
                    makeSeat.setInt(4, column);
                    makeSeat.setInt(5, row);
                    makeSeat.setBoolean(6, false);
                    makeSeat.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void setSeat(String moviename, String theatrename, LocalDateTime datetime, int xCoord, int yCoord){
        try{
            PreparedStatement makeSeat = con.prepareStatement("UPDATE Seat SET status = ? WHERE theatre_name = ? AND movie_name = ? AND showtime_time = ? AND seatXcoord = ? AND seatYcoord = ?;");
            makeSeat.setBoolean(1, true);
            makeSeat.setString(2, theatrename);
            makeSeat.setString(3, moviename);
            makeSeat.setTimestamp(4, Timestamp.valueOf(datetime));
            makeSeat.setInt(5, xCoord);
            makeSeat.setInt(6, yCoord);
            
            makeSeat.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
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

    public Showtime getShowtime(String theatre_name, String movie_name, LocalDateTime time) {
        for (Theatre t : arr){
            if (t.getName().equals(theatre_name)){
                for (OfferedMovie om : t.getAvailableMovies()){
                    if (om.getMovie().getMovieName().equals(movie_name)){
                        for (Showtime st : om.getShowtimes()){
                            if (st.getTime().equals(time)){
                                return st;
                            }
                        }
                    }
                }
            }
            
        }
        System.out.println("Error finding showtime in theatressingleton");
        return null;
    }
    public void addTheatre(String theatreName) throws SQLException{
        PreparedStatement makeTheatre = con.prepareStatement("INSERT INTO Theatre (name, location) VALUES (?,?);");
        makeTheatre.setString(1,theatreName);
        makeTheatre.setString(2,"Somewhere else");
        makeTheatre.executeUpdate();

        arr.add(new Theatre(theatreName, new ArrayList<OfferedMovie>()));
    }

    public boolean addOfferedMovie(String movieName, String theatreName) throws SQLException{
        PreparedStatement makeOfferedMovie = con.prepareStatement("INSERT INTO offered_movie (movie_name, theatre_name) VALUES (?,?);");
        makeOfferedMovie.setString(1,movieName);
        makeOfferedMovie.setString(2,theatreName);
        makeOfferedMovie.executeUpdate();
        if(MoviesSingleton.getInstance().getMovie(movieName) == null){
            return false;
        }
        for(Theatre t : arr){
            if(t.getName().equals(theatreName)){
                t.addOfferedMovie(new OfferedMovie(new ArrayList<Showtime>(), MoviesSingleton.getInstance().getMovie(movieName)));
                return true;
            }
        }
        return false;
       
    }

    public boolean addShowtime(String movieName, String theatreName, LocalDate showtime_date, LocalTime showtime_time) throws SQLException {
        PreparedStatement makeShowtime = con.prepareStatement("INSERT INTO Showtime (theatre_name, movie_name, date_time) VALUES (?,?,?);");
        makeShowtime.setString(1,movieName);
        makeShowtime.setString(2,theatreName);
        LocalDateTime stuff = LocalDateTime.of(showtime_date, showtime_time);
        makeShowtime.setTimestamp(3, Timestamp.valueOf(stuff));
        makeShowtime.executeUpdate();
        for(Theatre t : arr){
            if(t.getName().equals(theatreName)){
                for(OfferedMovie om: t.getAvailableMovies()){
                    if(om.getMovie() == null){
                        return false;
                    }
                    if(om.getMovie().getMovieName().equals(movieName)){
                        ArrayList<ArrayList<Boolean>> seatTable = new ArrayList<ArrayList<Boolean>>();
                        for (int rowNum = 0; rowNum < 10; rowNum++){
                            ArrayList<Boolean> row = new ArrayList<Boolean>();
                            for (int colNum = 0; colNum < 10; colNum++){
                                row.add(false);
                            }
                        }
                        om.addShowtime(new Showtime(seatTable, stuff));
                        populateSeats(movieName, theatreName, stuff.toString());
                        return true;
                    
                }
            }
        }
        
    }
    return false;
}
}


package com.project.ticketApp;

import java.util.ArrayList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TicketsSingleton extends Singleton<Ticket> {

    private static TicketsSingleton instance;

    public static TicketsSingleton getInstance(){
        return instance;
    }

    private TicketsSingleton() throws SQLException{
        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM ticket;");
        // this will return a ResultSet of all users with said name
        ResultSet rs = selectStatement.executeQuery();

        // will traverse through all found rows
        while (rs.next()) {
            int ticketID = rs.getInt("ticket_id");
            LocalDateTime time = rs.getTimestamp("showtime_time").toLocalDateTime();
            String theatre_name = rs.getString("theatre_name");
            String movie_name = rs.getString("movie_name");
            int xCoord = rs.getInt("seatXcoord");
            int yCoord = rs.getInt("seatYcoord");

            // MoviesSingleton moviesSingleton = MoviesSingleton.getInstance();
            // Movie offedMovie = moviesSingleton.getMovie(movie_name);
            
            // find seats for specific showtime above
            PreparedStatement selectSeatsStatement = con.prepareStatement("SELECT * FROM seat WHERE theatre_name = ? AND movie_name = ? AND showtime_time = ? ORDER BY seatXcoord ASC;");
            selectSeatsStatement.setString(1, theatre_name);
            selectSeatsStatement.setString(2, movie_name);
            selectSeatsStatement.setTime(3, rs.getTime("showtime_time"));
            // this will return a ResultSet of all users with said name
            ResultSet rs2 = selectSeatsStatement.executeQuery();

            // iterate through each tuple, create an arraylist of seats
            ArrayList<ArrayList<Boolean>> seats = new ArrayList<ArrayList<Boolean>>();
            
            while (rs2.next()) {
                int xcoord = rs2.getInt("seatXcoord");
                PreparedStatement selectYStatement = con.prepareStatement("SELECT * FROM seat WHERE theatre_name = ? AND movie_name = ? AND showtime_time = ? AND seatXcoord = ? ORDER BY seatYcoord ASC;");
                selectYStatement.setString(1, theatre_name);
                selectYStatement.setString(2, movie_name);
                selectYStatement.setTime(3, rs.getTime("showtime_time"));
                selectYStatement.setInt(4, xcoord);
                ResultSet rs3 = selectYStatement.executeQuery();
                ArrayList<Boolean> columns = new ArrayList<Boolean>();
                while (rs3.next()) {
                    columns.add(rs3.getBoolean("status"));
                }
                seats.add(columns);
            }

            Showtime showtime = new Showtime(seats, time);
            Ticket ticket = new Ticket(xCoord, yCoord, showtime, ticketID);
            arr.add(ticket);
        }
    }

    public Ticket verifyTicket(int ticketID){
        //if ticket id is in arr than return that ticket
        //else return null
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getTicketID() == ticketID)
                return arr.get(i);
        }
        return null;
    }

    public Ticket createTicket(Showtime showtime){
        //makes a ticket based on showtime and adds it to the database and to the arraylist

        // commented for now because im not sure how to get the x, y coord
        // int xCoord = ; 
        // int yCoord = ;
        // String movie_name = showtime.getMovie().getMovie().getMovieName();
        // String theatre_name = showtime.getMovie().getTheatre().getName();
        // int price = 15;
        

        // PreparedStatement iStatement = con.prepareStatement("INSERT INTO ticket (showtime_time, theatre_name, movie_name, seatXcoord, seatYcoord, price) VALUES (?, ?, ?, ?, ?, ?);");
        // iStatement.setTime(1, theatre_name);
        // iStatement.setString(2, theatre_name);
        // iStatement.setString(3, movie_name);
        // iStatement.setInt(4, xCoord);
        // iStatement.setInt(5, yCoord);
        // iStatement.setInt(6, price);
        // iStatement.executeQuery();

        // PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM ticket ORDER BY ticket_id DESC LIMIT 1;");
        // ResultSet rs = selectStatement.executeQuery();

        // Ticket newTicket = new Ticket(xCoord, yCoord, showtime, rs.getInt("ticket_id"));
        // arr.add(newTicket);
        // return newTicket;
        return null;
    }


    // public int getNextID() {
    //     int maybeID = arr.size();
    //     int nextID;

    //     while(true) {
    //         nextID = maybeID;
    //         for (Ticket e : arr) {
    //             if (e.getTicketID() == maybeID) {
    //                 maybeID++;
    //             }
    //         }
    //         if(maybeID != nextID){
    //             nextID = maybeID;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     //counts number of objects in arraylist
    //     //check if that number is already taken as id
    //     //if not keep incrementing one until valid ID found
    //     return nextID;
    // }
}

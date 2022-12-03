package com.project.ticketApp;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.catalina.User;

public class UsersSingleton extends Singleton<RegisteredUser> {

    private static UsersSingleton instance;

    private UsersSingleton() throws SQLException {
        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM registereduser;");
        ResultSet rs = selectStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("username");
            int card = rs.getInt("credit_card_num");
            String holder = rs.getString("credit_card_holder");
            RegisteredUser ru = new RegisteredUser(name, card, holder);
            arr.add(ru);
        }
    }

    public static UsersSingleton getInstance() throws SQLException{
        if (instance == null)  {
            instance = new UsersSingleton();
        }
        return instance;
    }

    public void updateUserSubscription(RegisteredUser user) throws SQLException{
        //update lastpaid in database according to given user object
        //call setlastpaid for that user
        String username = user.getUsername();
        LocalDate date = user.getLastPaid();

        PreparedStatement uStatement = con.prepareStatement("UPDATE registereduser SET last_payment = ? WHERE username = ?;");
        uStatement.setDate(1, Date.valueOf(date));
        uStatement.setString(2, username);
        uStatement.executeQuery();

    }

    public RegisteredUser verifyLogin(String username, String password) throws SQLException{
        //check in database if username and password map to a registered user entity

        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM registereduser WHERE username = ?;");
        selectStatement.setString(1, username);
        // this will return a ResultSet of all users with said name
        ResultSet rs = selectStatement.executeQuery();

        if (rs.next()) {
            if (rs.getString("password") == password) {
                String name = rs.getString("username");
                int card = rs.getInt("credit_card_num");
                String holder = rs.getString("credit_card_holder");
                RegisteredUser ru = new RegisteredUser(name, card, holder);
                return ru;
            }
        }

        return null;
    }

    // public int getNextID() {
    //     int maybeID = arr.size();
    //     int nextID;

    //     while(true) {
    //         nextID = maybeID;
    //         for (RegisteredUser e : arr) {
    //             if (e.getUserID() == maybeID) {
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

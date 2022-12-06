package com.project.ticketApp;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

// import org.apache.catalina.User;

public class UsersSingleton extends Singleton<RegisteredUser> {

    private static UsersSingleton instance;

    private UsersSingleton() throws SQLException {
        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM registereduser;");
        ResultSet rs = selectStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("username");
            int card = rs.getInt("credit_card_num");
            String holder = rs.getString("credit_card_holder");
            Date last_paid = rs.getDate("last_payment");
            RegisteredUser ru = new RegisteredUser(name, card, holder,last_paid.toLocalDate());
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
        uStatement.setDate(1, Date.valueOf(LocalDate.now()));
        uStatement.setString(2, username);
        uStatement.executeUpdate();

        user.setLastPaid(LocalDate.now());

    }
    public void addUser(String username, String password, String name, int creditCardNO, String creditCardHolder, LocalDate last_payment) throws SQLException
{

        PreparedStatement makeSeat = con.prepareStatement("INSERT INTO registereduser (username, password, name, credit_card_number, credit_card_holder, last_payment) VALUES (?,?,?,?,?,?);");
        makeSeat.setString(1, username);
        makeSeat.setString(2, password);
        makeSeat.setDate(6, Date.valueOf(last_payment));
        makeSeat.setString(3, name);
        makeSeat.setInt(4, creditCardNO);
        makeSeat.setString(5, creditCardHolder);
        makeSeat.executeUpdate();

        arr.add(new RegisteredUser(username, creditCardNO,creditCardHolder,last_payment));

}    
    public RegisteredUser verifyLogin(String username, String password) throws SQLException{
        //check in database if username and password map to a registered user entity

        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM registereduser WHERE username = ?;");
        selectStatement.setString(1, username);
        // this will return a ResultSet of all users with said name
        ResultSet rs = selectStatement.executeQuery();

        if (rs.next()) {

            if (rs.getString("password").equals(password)) {
                // String name = rs.getString("username");
                // int card = rs.getInt("credit_card_num");
                // String holder = rs.getString("credit_card_holder");
                // RegisteredUser ru = new RegisteredUser(name, card, holder);
                // return ru;
                // System.out.println(rs.getString("password"));
                for (RegisteredUser RU : arr){
                    if(RU.getUsername().equals(username)){
                        return RU;
                    }
                }


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

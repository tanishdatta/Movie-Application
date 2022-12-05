package com.project.ticketApp;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PaymentSingleton extends Singleton<Payment> {

    private static PaymentSingleton instance;

    public static PaymentSingleton getInstance() throws SQLException{
        if (instance == null) {
            instance = new PaymentSingleton();
        }
        return instance;
    }
    public void createPayment(int dollarAmount, int creditCardNO, String cardHolderName) throws SQLException{
        //Make payment object
        PreparedStatement iStatement = con.prepareStatement("INSERT INTO payment (amount, credit_card_num, credit_card_holder, local_date) VALUES (?, ?, ?, ?);");
        iStatement.setInt(1, dollarAmount);
        iStatement.setInt(2, creditCardNO);
        iStatement.setString(3, cardHolderName);
        iStatement.setDate(4, Date.valueOf(LocalDate.now()));
        iStatement.executeUpdate();

        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM PAYMENT WHERE credit_card_holder = ? ORDER BY payment_id DESC LIMIT 1");
        selectStatement.setString(1, cardHolderName);
        ResultSet rs = selectStatement.executeQuery();
        
        Payment payment = new Payment(dollarAmount, creditCardNO, cardHolderName, rs.getInt("payment_id"), LocalDate.now());
        arr.add(payment);
    }
    private PaymentSingleton() throws SQLException{
        PreparedStatement selectStatement = con.prepareStatement("SELECT * from payment;");

        // this will return a ResultSet of all users with said name
        ResultSet rs = selectStatement.executeQuery();

        // will traverse through all found rows
        while (rs.next()) {
            int id = rs.getInt("payment_id");
            int amount = rs.getInt("amount");
            int creditCardNum = rs.getInt("credit_card_num");
            String creditCardHolder = rs.getString("credit_card_holder");
            LocalDate date = rs.getDate("local_date").toLocalDate();
            Payment payment = new Payment(amount, creditCardNum, creditCardHolder, id, date);
            arr.add(payment);
        }

    }
    // public int getNextID() {
    //     int maybeID = arr.size();
    //     int nextID;

    //     while(true) {
    //         nextID = maybeID;
    //         for (Payment e : arr) {
    //             if (e.getPaymentID() == maybeID) {
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

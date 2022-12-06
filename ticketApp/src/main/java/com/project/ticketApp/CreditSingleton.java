package com.project.ticketApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditSingleton extends Singleton<Credit> {
    private static CreditSingleton instance;

    public static CreditSingleton getInstance() throws SQLException{
        if (instance == null) {
            instance = new CreditSingleton();
        }
        return instance;
    }

    public CreditSingleton() throws SQLException{
        //look at credits in database and construct credit objects based off of that
        //Add credit objects to array

        PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM refund_credit;");

        // this will return a ResultSet of all users with said name
        ResultSet rs = selectStatement.executeQuery();

        // will traverse through all found rows
        while (rs.next()) {
            int amount = rs.getInt("dollar_amount");
            int code = rs.getInt("credit_code");
            Credit credit = new Credit(amount, code);
            arr.add(credit);
        }
        
        
    }

    public void deleteCredit(Credit credit) throws SQLException{
        //delete credit from database
        //also delete from ArrayList
        int code = credit.getCreditCode();
        PreparedStatement delStatement = con.prepareStatement("DELETE FROM refund_credit WHERE credit_code = ?;");
        delStatement.setInt(1, code);

        delStatement.executeUpdate();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCreditCode() == code) 
            arr.remove(credit);
        }
    }


    public void addDollars(Credit credit, int dollar) throws SQLException{
        //Add dollar value to credit in database
        //Add dollar value to credit object in ArrayList

        int code = credit.getCreditCode();
        PreparedStatement uStatement = con.prepareStatement("UPDATE refund_credit SET dollar_amount = dollar_amount + ? WHERE credit_code = ?;");
        uStatement.setInt(1, dollar);
        uStatement.setInt(2, code);
        uStatement.executeUpdate();

    }

    public void subtractDollars(Credit credit, int dollar) throws SQLException{
        //Subtract dollar value to credit in database
        //Subtract dollar value to credit object in ArrayList

        int code = credit.getCreditCode();
        PreparedStatement uStatement = con.prepareStatement("UPDATE refund_credit SET dollar_amount = dollar_amount - ? WHERE credit_code = ?;");
        uStatement.setInt(1, dollar);
        uStatement.setInt(2, code);
        uStatement.executeUpdate();

    }

    public Credit createCredit(int dollar) throws SQLException{
        //Use getNextId to get the next credit code to make new credit object and to add credit to database with that credit code and given dollar value
        //Make new credit thingy in database with given dollar value and creditcode
        //Create new credit object in arraylist with dollar value and creditcode
        //Return new credit object


        // create a new in refund_credit with given dollar amount
        PreparedStatement iStatement = con.prepareStatement("INSERT INTO refund_credit (dollar_amount) VALUES (?);");
        iStatement.setInt(1, dollar);
        iStatement.executeUpdate();

        // retrieve credit_code pf last added tuple to the table
        PreparedStatement gStatement = con.prepareStatement("SELECT * FROM refund_credit ORDER BY credit_code DESC LIMIT 1;");
        ResultSet rs = gStatement.executeQuery();
        rs.next();
        int code = rs.getInt("credit_code");
        Credit credit = new Credit(dollar, code);
        arr.add(credit);

        
        return credit;
    }

    public Credit getCredit(int creditCode){
        //Find credit object in array list that has the same creditCode number

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCreditCode() == creditCode)
                return arr.get(i);
        }
        return null;
    }

    // maybe dont need this anymore
    // public int getNextID() {
    //     int maybeID = arr.size();
    //     int nextID;

    //     while(true) {
    //         nextID = maybeID;
    //         for (Credit e : arr) {
    //             if (e.getCreditCode() == maybeID) {
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

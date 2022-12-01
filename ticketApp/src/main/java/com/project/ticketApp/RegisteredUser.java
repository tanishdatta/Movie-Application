package com.project.ticketApp;

import java.time.LocalDate;

//Stub finished
public class RegisteredUser {
    private int userID;
    private int creditCardNo;
    private String name;
    private LocalDate lastPaid; //need ot connect ot databases somehow

    public RegisteredUser(int userID, int creditCardNo, String name){
        this.userID = userID;
        this.creditCardNo = creditCardNo;
        this.name = name;
    }


    public int getUserID() {
        return this.userID;
    }

    public int getCreditCardNo() {
        return this.creditCardNo;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getLastPaid() {
        return this.lastPaid;
    }

    public void setLastPaid(LocalDate lastpaid) {
        this.lastPaid = lastpaid;
    }
}

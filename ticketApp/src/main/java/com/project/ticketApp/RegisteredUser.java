package com.project.ticketApp;

import java.time.LocalDate;

//Stub finished
public class RegisteredUser {
    private int userID;
    private int creditCardNo;
    private String name;
    private LocalDate lastpaid; //need ot connect ot databases somehow

    public RegisteredUser(int userID, int creditCardNo, String name){
        this.userID = userID;
        this.creditCardNo = creditCardNo;
        this.name = name;
    }
}

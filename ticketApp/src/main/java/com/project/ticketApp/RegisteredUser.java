package com.project.ticketApp;

import java.time.LocalDate;

//Stub finished
public class RegisteredUser {
    private String username;
    private int creditCardNo;
    private String cardHolderName;
    private LocalDate lastPaid; //need ot connect ot databases somehow

    public RegisteredUser(String username, int creditCardNo, String cardHolderName, LocalDate lastpaid){
        this.username = username;
        this.creditCardNo = creditCardNo;
        this.cardHolderName = cardHolderName;
        this.lastPaid = lastpaid;
        
    }


    public String getUsername() {
        return this.username;
    }

    public int getCreditCardNo() {
        return this.creditCardNo;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public LocalDate getLastPaid() {
        return this.lastPaid;
    }

    public void setLastPaid(LocalDate lastpaid) {
        this.lastPaid = lastpaid;
    }
}

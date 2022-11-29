package com.project.ticketApp;

import java.time.LocalDate;
//Stub finished
public class Payment {
    private int dollarAmount;
    private int creditCardNo;
    private String cardholderName;
    private LocalDate date;

    public Payment(int dollarAmount, int creditCardNo, String cardholderName){
        this.dollarAmount = dollarAmount;
        this.creditCardNo = creditCardNo;
        this.cardholderName = cardholderName;
    }

    public int getDollarAmount(){
        return this.dollarAmount;
    }

    public int getCardNo(){
        return this.creditCardNo;
    }

    public String getCardName(){
        return this.cardholderName;
    }

    public LocalDate getTransactionDate(){
        return this.date;
    }
}

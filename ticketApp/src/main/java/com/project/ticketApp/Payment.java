package com.project.ticketApp;

import java.time.LocalDate;
//Stub finished
public class Payment {
    private int dollarAmount;
    private int creditCardNo;
    private String cardholderName;
    private LocalDate date;
    private int paymentID;

    public Payment(int dollarAmount, int creditCardNo, String cardholderName, int paymentID){
        this.dollarAmount = dollarAmount;
        this.creditCardNo = creditCardNo;
        this.cardholderName = cardholderName;
        this.paymentID = paymentID;
    }
    public int getPaymentID(){
        return this.paymentID;
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

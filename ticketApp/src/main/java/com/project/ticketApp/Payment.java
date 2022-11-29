package com.project.ticketApp;

import java.time.LocalDate;

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
        return 5;
    }

    public int getCardNo(){
        return 5;
    }
}

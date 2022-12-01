package com.project.ticketApp;

public class PaymentGUI {

    private int dollarAmount;
    private PaymentController parentController;

    public PaymentGUI(PaymentController paymentController){
        //Display the dollar amount
        //Build a text field for credit code
        //Build an enter button for creditCode
        //Build a pay button
    }
    public PaymentGUI(RegisteredUser user, PaymentController paymentController){
        //Display the dollar amount
        //Build a text field for credit code
        //Build an enter button for creditCode
        //Build a pay button
        //Pre-load all credit card info using user
    }

    public void setDollarAmount(int dollarAmount){
        this.dollarAmount = dollarAmount;
        //update GUI with new dollarAmount
    }

    public void setCreditCode(int creditCode){
        //called when user enters a creditCode
        //call setCreditCode in paymentController
        parentController.setCreditCode(creditCode);
    }
}


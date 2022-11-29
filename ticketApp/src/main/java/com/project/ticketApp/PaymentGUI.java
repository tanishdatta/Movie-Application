package com.project.ticketApp;

public class PaymentGUI {

    private int dollarAmount;
    private PaymentController parentController;

    public PaymentGUI(PaymentController paymentController){

    }
    public PaymentGUI(RegisteredUser user, PaymentController paymentController){

    }

    public void setDollarAmount(int dollarAmount){
        this.dollarAmount = dollarAmount;

    }

    public void setCreditCode(int creditCode){

    }
}


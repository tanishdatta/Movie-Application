package com.project.ticketApp;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

//stub done
public class PaymentController {
    private RegisteredUser user;
    private PaymentGUI gui;
    private Credit credit;
    private int dollarAmount;
    private int creditDifference; //(original $) minus (credit $)
    private PaymentObserver paymentObserver;

    //constructor
    public PaymentController(RegisteredUser user, int dollarAmount, SeatController seatController){
        this.user =user;
        this.dollarAmount = dollarAmount;

    }

    public PaymentController(int dollarAmount,SeatController seatController){
        this.dollarAmount = dollarAmount;
    }

    public void pay(int cardNumber, String cardHolder){
        //called by paymentGUI
        //notionally verify card info...
        Dialog notionalVerification = new Dialog();
        notionalVerification.add(new Paragraph("Notionally verifying credit card info:"));
        notionalVerification.add(new Paragraph("Credit card number: " + cardNumber));
        notionalVerification.add(new Paragraph("Cardholder: " + cardHolder));
        notionalVerification.add(new Paragraph("Card info good"));
        notionalVerification.add(new Paragraph("Modularity babyyyyyyy"));
        notionalVerification.open();
        
        //create payment object passing in the amount to pay (taking into account creditDifference)
            //and credit card info
        //update/deletes credit from creditSingleton depending on whether creditDifference is >=0

        //Display a notification confirming payment
        //notify payment observer that payment is good to go
        //close payment gui
    }

    public void setCreditCode(int creditCode){
        // gets credit code from paymentGUI which the user inputs
        //Get credit object from creditSingleton
        //if there is already a Credit in this controller, replace it(make sure you can't get an infinite refund hack)
        //calculate credit difference and assign in to creditDifference memberVariable
                // make sure to recalculate credit difference if replacing Credit object
        //update gui with new dollarAmount
    }

    public void setObserver(PaymentObserver Observer){
        //Self-Explanatory you got this
    }
}

package com.project.ticketApp;
//stub done
public class PaymentController {
    private RegisteredUser user;
    private PaymentGUI gui;
    private Credit credit;
    private int dollarAmount;
    private int creditDifference;
    private PaymentObserver paymentObserver;

    //constructor
    public PaymentController(RegisteredUser user, int dollarAmount){
        this.user =user;
        this.dollarAmount = dollarAmount;

    }

    public PaymentController(int dollarAmount){
        this.dollarAmount = dollarAmount;
    }

    public void pay(){
        //called by paymentGUI
        //create payment object passing in the dollar amount
        //update/deletes credit from creditSingleton

        //Display a notification confirming payment
        //Change paymentGood in observer to true
    }

    public void setCreditCode(int creditCode){
        // gets credit code from paymentGUI which the user inputs
        //Get credit object from creditSingleton
        //calculate credit difference and assign in to creditDifference memberVariable
        //update dollarAmount
        //update gui with new dollarAmount
    }

    public void setObserver(PaymentObserver Observer){
        //Self-Explanatory you got this
    }
}

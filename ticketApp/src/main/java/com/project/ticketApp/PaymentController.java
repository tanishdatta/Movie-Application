package com.project.ticketApp;
//stub done
public class PaymentController {
    private RegisteredUser user;
    private PaymentGUI gui;
    private Credit credit;
    private int dollarAmount;
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
        //does payment 
        //update/deletes credit from creditSingleton
    }

    public void setCreditCode(int creditCode){
        // gets credit code from paymentGUI which the user inputs
    }

    public void setObserver(PaymentObserver Observer){
        
    }
}

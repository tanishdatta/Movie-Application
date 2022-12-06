package com.project.ticketApp;

import java.sql.SQLException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

//stub done
public class PaymentController {
    private RegisteredUser user;
    private PaymentGUI gui;
    private Credit credit;
    private int dollarAmount;
    private PaymentObserver paymentObserver;
    private int creditDifference;

    //constructor
    public PaymentController(RegisteredUser user, int dollarAmount, PaymentObserver paymentObserver){
        this.user =user;
        this.dollarAmount = dollarAmount;
        this.paymentObserver = paymentObserver;
        this.gui = new PaymentGUI(user, this,this.dollarAmount);
        gui.open();

    }

    public PaymentController(int dollarAmount, PaymentObserver paymentObserver){
        this.dollarAmount = dollarAmount;
        this.paymentObserver = paymentObserver;
        this.credit = null;
        this.gui = new PaymentGUI(this,this.dollarAmount);
        gui.open();
    }

    public void pay(int cardNumber, String cardHolder) {
        //called by paymentGUI
        //notionally verify card info...
        Dialog notionalVerification = new Dialog();
        notionalVerification.add(new Paragraph("Notionally verifying credit card info:"));
        notionalVerification.add(new Paragraph("Credit card number: " + cardNumber));
        notionalVerification.add(new Paragraph("Cardholder: " + cardHolder));
        notionalVerification.add(new Paragraph("Card info good"));
        Button okay = new Button("OK");
        okay.addClickListener(ClickEvent ->{notionalVerification.close();});
        notionalVerification.add(okay);

        notionalVerification.open();
        if (credit != null){
            if(creditDifference <= 0){
                try {
                    CreditSingleton.getInstance().subtractDollars(this.credit, dollarAmount);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Dialog notify = new Dialog();
                notify.add(new Paragraph("Your credit pays for the entire purchase"));
                notify.add(new Paragraph("Your new credit balance is: " + this.credit.getDollars()));
                notify.open();
                this.gui.close();
                this.paymentObserver.paymentGood();
            }
            else{
                if (cardNumber == 0 || cardHolder == null){
                    Dialog noCard = new Dialog();
                    noCard.add(new Paragraph("Error: no credit card info submitted"));
                    Button ok2 = new Button("OK");
                    ok2.addClickListener(ClickEvent -> {noCard.close();});
                    noCard.add(ok2);
                    return;
                }
                try {
                    CreditSingleton.getInstance().deleteCredit(this.credit);
                    this.credit = null;
                    PaymentSingleton.getInstance().createPayment(creditDifference, cardNumber, cardHolder);
                    this.gui.close();
                    this.paymentObserver.paymentGood();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        else{
            if (cardNumber == 0 || cardHolder == null){
                Dialog noCard = new Dialog();
                noCard.add(new Paragraph("Error: no credit card info submitted"));
                Button ok2 = new Button("OK");
                ok2.addClickListener(ClickEvent -> {noCard.close();});
                noCard.add(ok2);
                return;
            }
            try{
                PaymentSingleton.getInstance().createPayment(dollarAmount, cardNumber, cardHolder);
                this.gui.close();
                this.paymentObserver.paymentGood();
                System.out.println("paid without credit code");
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
        

        //create payment object passing in the amount to pay (taking into account creditDifference)
        //and credit card info
        //update/deletes credit from creditSingleton depending on whether creditDifference is >=0

        //Display a notification confirming payment
        //notify payment observer that payment is good to go
        //close payment gui
        



    }

        public void setCreditCode (int creditCode){

            try {
                this.credit = CreditSingleton.getInstance().getCredit(creditCode);
            }catch(Exception e){
                e.printStackTrace();
                System.exit(1);
            }

            this.creditDifference = this.dollarAmount - this.credit.getDollars();
            if(creditDifference <= 0) {
                this.gui.setDollarAmount(0);
            }
            else{
                this.gui.setDollarAmount(this.dollarAmount);
            }
            // gets credit code from paymentGUI which the user inputs
            //Get credit object from creditSingleton
            //if there is already a Credit in this controller, replace it(make sure you can't get an infinite refund hack)
            //calculate credit difference and assign in to creditDifference memberVariable
            // make sure to recalculate credit difference if replacing Credit object
            //update gui with new dollarAmount
        }

    }

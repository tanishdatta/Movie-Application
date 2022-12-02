package com.project.ticketApp;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class PaymentGUI extends Dialog{

    private int dollarAmount;
    private PaymentController parentController;

    //start components...
    Paragraph dollarPara;
    NumberField refundCreditNF = new NumberField("Enter refund credit code:");
    Button useRefund = new Button("Submit refund code");
    NumberField ccNumNF = new NumberField("Credit card number:");
    TextField cardHolderTF = new TextField("Credit card cardholder name:");
    Button pay = new Button("Pay");

    //end components

    //start important functs...
    public PaymentGUI(PaymentController paymentController, int dollarAmount){
        this.dollarAmount = dollarAmount;
        this.parentController = paymentController;
        initDollarPara();//Display the dollar amount
        initCardGroup();//Build a text field for credit code and enter button
        initRefundGroup();//build fields for credit card info and pay button
    }
    
    public PaymentGUI(RegisteredUser user, PaymentController paymentController, int dollarAmount){
        this(paymentController, dollarAmount);
        loadCardInfo(user);
        //Pre-load all credit card info using user
    }

    
    public void setDollarAmount(int dollarAmount){
        this.dollarAmount = dollarAmount;
        dollarPara = new Paragraph("Pay amount: $"+ dollarAmount);
        //update GUI with new dollarAmount
    }

    private void setCreditCode(int creditCode){
        //called when user enters a creditCode
        parentController.setCreditCode(creditCode);//call setCreditCode in paymentController
    }
    private void pay(int cardNumber, String cardHolder){//called when user presses pay
        parentController.pay(cardNumber,cardHolder);
    }
    //end important functs

    //start helper functs...
    private void initDollarPara() {
        dollarPara = new Paragraph("Pay amount:$ "+ dollarAmount);
        add(dollarPara);
    }
    private void initCardGroup() {
        add(ccNumNF);
        add(cardHolderTF);
        pay.addClickListener(ClickEvent ->{pay(ccNumNF.getValue().intValue(), cardHolderTF.getValue());});
        add(pay);
    }
    private void initRefundGroup() {
        HorizontalLayout refundGroup = new HorizontalLayout();
        refundGroup.add(refundCreditNF);
        useRefund.addClickListener(ClickEvent -> {setCreditCode(refundCreditNF.getValue().intValue());});
        refundGroup.add(useRefund);
        add(refundGroup);
    }
    private void loadCardInfo(RegisteredUser user) {
        ccNumNF.setValue(new Double(user.getCreditCardNo()));
        cardHolderTF.setValue(user.getCardHolderName());
         
    }
    //end helper functs
}


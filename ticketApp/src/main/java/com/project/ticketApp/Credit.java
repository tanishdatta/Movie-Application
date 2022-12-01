package com.project.ticketApp;

import java.sql.Connection;

//Stub finished
public class Credit{
    private int dollarAmount;
    private int creditCode;

    public Credit(int dollarAmount, int creditCode){
        this.dollarAmount = dollarAmount;
        this.creditCode = creditCode;
        //call init connection
    }

    //dollar amount =- amount and change in databases
    public void subtractDollars(int amount){
        dollarAmount -= amount;

    }

    public void addDollars(int amount){
        dollarAmount += amount;

    }

    //getters
    public int getDollars(){
        return this.dollarAmount;
    }

    public int getCreditCode(){
        return this.creditCode;
    }

}
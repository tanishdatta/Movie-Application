package com.project.ticketApp;

import java.sql.Connection;

//Stub finished
public class Credit{
    private int dollarAmount;
    private int creditCode;
    private Connection con;

    //Contstructor 
    public Credit(int dollarAmount){
        this.dollarAmount = dollarAmount;
        this.creditCode = CreditSingleton.getInstance().getNextID();
        //call init connection
    }

    //dollar amount =- amount and change in databases
    public void subtractDollars(int amount){
        dollarAmount -= amount;
        //change in databases
    }

    public void addDollars(int amount){
        dollarAmount += amount;
        //change in databases
    }

    //getters
    public int getDollars(){
        return this.dollarAmount;
    }

    public int getCreditCode(){
        return this.creditCode;
    }

    private void initConnection(){
        
    }
}
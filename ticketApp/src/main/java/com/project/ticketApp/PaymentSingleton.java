package com.project.ticketApp;

public class PaymentSingleton extends Singleton<Payment> {

    private static PaymentSingleton instance;

    public static PaymentSingleton getInstance(){
        return instance;
    }
    public void createPayment(int dollarAmount, int creditCardNO, String cardHolderName){
        //Make payment object
    }
    private PaymentSingleton(){

    }
    public int getNextID() {
        int maybeID = arr.size();
        int nextID;

        while(true) {
            nextID = maybeID;
            for (Payment e : arr) {
                if (e.getPaymentID() == maybeID) {
                    maybeID++;
                }
            }
            if(maybeID != nextID){
                nextID = maybeID;
            }
            else{
                break;
            }
        }
        //counts number of objects in arraylist
        //check if that number is already taken as id
        //if not keep incrementing one until valid ID found
        return nextID;
    }
    
}

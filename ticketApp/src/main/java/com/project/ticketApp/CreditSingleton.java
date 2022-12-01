package com.project.ticketApp;

public class CreditSingleton extends Singleton<Credit> {
    private static CreditSingleton instance;

    public static CreditSingleton getInstance(){
        return instance;
    }

    public CreditSingleton(){
        //look at credits in database and construct credit objects based off of that
        //Add credit objects to array
    }

    public void deleteCredit(Credit credit){
        //delete credit from database
        //also delete from ArrayList
    }


    public void addDollars(Credit credit, int dollar){
        //Add dollar value to credit in database
        //Add dollar value to credit object in ArrayList
    }

    public void subtractDollars(Credit credit, int dollar){
        //Subtract dollar value to credit in database
        //Subtract dollar value to credit object in ArrayList
    }

    public Credit createCredit(int dollar){
        //Use getNextId to get the next credit code to make new credit object and to add credit to database with that credit code and given dollar value
        //Make new credit thingy in database with given dollar value and creditcode
        //Create new credit object in arraylist with dollar value and creditcode
        //Return new credit object
        return null;
    }

    public Credit getCredit(int creditCode){
        //Find credit object in array list that has the same creditCode number
        return null;
    }

    public int getNextID() {
        int maybeID = arr.size();
        int nextID;

        while(true) {
            nextID = maybeID;
            for (Credit e : arr) {
                if (e.getCreditCode() == maybeID) {
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

package com.project.ticketApp;

public class UsersSingleton extends Singleton<RegisteredUser> {

    private static UsersSingleton instance;

    public static UsersSingleton getInstance(){
        return instance;
    }

    public void updateUserSubscription(RegisteredUser user){
        //update lastpaid in database according to given user object
        //call setlastpaid for that user
    }

    public RegisteredUser verifyLogin(String username, String password){
        //check in database if username and password map to a registered user entity
        return null;
    }

    public int getNextID() {
        int maybeID = arr.size();
        int nextID;

        while(true) {
            nextID = maybeID;
            for (RegisteredUser e : arr) {
                if (e.getUserID() == maybeID) {
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

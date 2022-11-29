package com.project.ticketApp;

public class UsersSingleton extends Singleton<RegisteredUser> {

    public Boolean verfiedLogin(String username, String password){
        //check in database if username and password map to a registered user entity
        return false;

    }

    @Override
    public void addObj(RegisteredUser obj) {
        // TODO Auto-generated method stub
        //add to database and arraylist
        
    }

    //getters
    @Override
    public RegisteredUser getObj(int objID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getNextID() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

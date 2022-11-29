package com.project.ticketApp;

public class CreditSingleton extends Singleton<Credit> {

    
    public void deleteCredit(Credit credit){
    //deletle credit from database
    //also delete from arraylist
    }

   
    @Override
    public void addObj(Credit obj) {
        // TODO Auto-generated method stub

        //add object to databases
        //add to arraylist
        
    }

     //getters
    @Override
    public Credit getObj(int objID) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int getNextID() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    

}

package com.project.ticketApp;
//stub done
import java.sql.Connection;
import java.util.ArrayList;

public abstract class Singleton<E>{
    Connection con;
    protected ArrayList<E> arr;

    protected Singleton(){

    }

    private void initConnection(){
        //establish connection to SQL
    }

    
}

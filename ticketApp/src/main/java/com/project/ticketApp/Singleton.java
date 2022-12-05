package com.project.ticketApp;
//stub done
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Singleton<E>{
    Connection con;
    protected ArrayList<E> arr;

    protected Singleton(){
        arr = new ArrayList<E>();
        initConnection();
    }

    public void initConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/ticketreservation_db", "user1", "ensf"); 
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    
}

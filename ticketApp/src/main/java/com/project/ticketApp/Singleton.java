package com.project.ticketApp;
//stub done
import java.util.ArrayList;

public abstract class Singleton<E>{

    private static Singleton instance;
    
    private ArrayList<E> arr;

    protected Singleton(){

    }

    public static Singleton getInstance(){
        return instance; 
    }

    public void addObj(E obj){

    }

    public E getObj(int objID){
        return null;
        
    }

    public int getNextID(){
        return (Integer) null;
    }
    private void initConnection(){

    }
    
}

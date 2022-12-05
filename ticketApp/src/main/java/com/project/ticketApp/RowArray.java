package com.project.ticketApp;

import java.util.ArrayList;

public class RowArray {
    private ArrayList<Boolean> arr;
    private int rowNum;
    public RowArray(ArrayList<Boolean> arr, int rownum){
        this.arr = arr;
        this.rowNum = rownum;
    }
    public Boolean getBool(int i){
        return arr.get(i);
    }
    public void setBool(int i, Boolean val){
        arr.set(i, val);
    }
    public int getrowNum(){
        return rowNum;
    }
    
}

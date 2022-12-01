package com.project.ticketApp;

import java.util.ArrayList;
//stub finished 
public class SeatGUI {
    private SeatController parentController;

    public SeatGUI(ArrayList<ArrayList<Boolean>> seatArray, SeatController parentController){
        //Create 10 x 10 of icons that are differentiated by either colour or icon as full or empty
        //each seat is a button (button with icon)
        //10 by 10 is a VAADIN grid
        //Button calls selectSeat with coordinates somehow you figure it out

        //Just fuckin do it
    }

    public void selectSeat(int xCoord, int yCoord){
        //call seatController passing in the coordinates
        parentController.selectSeat(xCoord, yCoord);
    }
}

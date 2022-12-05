package com.project.ticketApp;

import java.util.ArrayList;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
//stub finished 
public class SeatGUI extends Dialog{
    private SeatController parentController;

    //start components...
    Grid<ArrayList<Boolean>> seatGrid = new Grid<ArrayList<Boolean>>();
    //end components...

    //start important functs..
    public SeatGUI(ArrayList<ArrayList<Boolean>> seatArray, SeatController parentController){
        this.parentController = parentController;
        buildGrid(seatArray);
        //Create 10 x 10 of icons that are differentiated by either colour or icon as full or empty
        //each seat is a button (button with icon)
        //10 by 10 is a VAADIN grid
        //Button calls selectSeat with coordinates somehow you figure it out

        //Just fuckin do it
    }

    

    public void selectSeat(int xCoord, int yCoord){
        parentController.selectSeat(xCoord, yCoord);
    }
    //end important functs

    //start helper functions..
    private void buildGrid(ArrayList<ArrayList<Boolean>> seatArray) {
        //holy fuck here we go..
        seatGrid.setItems(seatArray);
        //first make y axis labels
        seatGrid.addColumn(row -> {
            System.out.println(seatArray.indexOf(row));
            return IntToChar.convert(seatArray.indexOf(row));
        }).setAutoWidth(true).setFlexGrow(1);
        //then make each column with buttons
        for (int c = 0; c<10; c++){
            int column = c;
            seatGrid.addComponentColumn(row ->{
                if (row.get(column) == false){
                    Button seat = new Button(new Icon(VaadinIcon.USER));
                    seat.addThemeVariants(ButtonVariant.LUMO_ICON);
                    seat.getElement().setAttribute("aria-label", "Book seat");
                    seat.addClickListener(ClickEvent ->{selectSeat(column, seatArray.indexOf(row));});
                    return seat;
                }
                else{
                    Button seat = new Button(new Icon(VaadinIcon.CLOSE_SMALL));
                    seat.addThemeVariants(ButtonVariant.LUMO_ICON);
                    seat.getElement().setAttribute("aria-label", "Seat Occupied");
                    return seat;
                }
            }).setHeader(String.valueOf(column)).setAutoWidth(true).setFlexGrow(1);
        }
        add(seatGrid);
    }
    //end helper functions
}

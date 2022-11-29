package com.project.ticketApp;

import java.util.ArrayList;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MainScreenGUI extends VerticalLayout{
    private MainController parentController;

    public MainScreenGUI(ArrayList<Theatre> theatreList, MainController parentController){
        //set parent control
        //build combobox of theatres
        //build select button for combobox
    }
    private void selectTheatre(Theatre theatre){
        //called when select theatre button pressed
        //call loadTheatreMovies in main controller

    }
    public void loadTheatreMovies(ArrayList<OfferedMovies> movieList){
        //called by main controller when offered movies for this theatre fetched
        //build Accordion of offeredmovies
        //inside each panel of the accordion is a list of buttons for each showtime
    }
    private void selectShowtime(Showtime showtime){
        //called when user clicks selects a showtime in the accordion
        //call selectShowtime in main controller, passing in showtime obj
    }
}

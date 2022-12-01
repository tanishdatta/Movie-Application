package com.project.ticketApp;
//stubs done
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainController extends VerticalLayout{
    private RegisteredUser user;
    private MovieFilterStrategy filterstrat;//strategy pattern for filtering publicly available and/or early access movies
    private MainScreenGUI gui;

    public MainController(){
        //instantiate Logincontroller
    }
    public void loginSuccess(RegisteredUser user){
        //called by Logincontroller when successfully logged in
        //user is null when logging in as regular user
        //get arraylist of theatre objects from TheatresSingleton
        //this.user = user;
        //instantiate and open MainControllerGUI with arraylist of theatre objs and registereduser obj 
    }
    public void loadTheatreMovies(Theatre theatre){
        //called by MainScreenGUI when theatre chosen
        //get arrayList of offered movies from theatre obj
        //set filterStrat depending on whether user is null
        //use filterStrat to select which offeredmovies to display
        //call loadTheatreMovies in gui
    }
    public void selectShowtime(Showtime showtime){
        //called by MainScreenGUI when showtime selected
        //instantiate and open seatcontroller, passing in user and showtime objs
    }

    public void viewTicket(int ticketCode){
        //instantiates ticketController
        //calls viewTicket in ticketController and pass in ticketCode
    }
}

package com.project.ticketApp;
//stubs done
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;

@Route("")
public class MainController extends VerticalLayout{
    private RegisteredUser user;
    private MovieFilterStrategy filterstrat;//strategy pattern for filtering publicly available and/or early access movies
    private MainScreenGUI gui;
    private SeatCapStrategy seatCapStrat;//strategy pattern for determining if showtime is open for booking depending on % of seats abailable

    public MainController(){
        LoginController loginController = new LoginController(this);
        //instantiate Logincontroller
    }
    public void loginSuccess(RegisteredUser user){
        //called by Logincontroller when successfully logged in
        if(!user.equals(null)){
            this.user = user;
        }
        else{
            this.user = null;
        }
        try {
            ArrayList<Theatre> theatres = TheatresSingleton.getInstance().getAllTheatres();
            this.gui = new MainScreenGUI(theatres, this);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        //user is null when logging in as regular user
        //get arraylist of theatre objects from TheatresSingleton
        //this.user = user;
        //instantiate and open MainControllerGUI with arraylist of theatre objs and registereduser obj 
    }
    public void loadTheatreMovies(Theatre theatre){
        ArrayList<OfferedMovie> movies = theatre.getAvailableMovies();
        if(!user.equals(null)){
            this.filterstrat = new TwoDaysPrior();
        }
        else{
            this.filterstrat = new PublicAnnouncementOnly();
        }
        gui.loadTheatreMovies(this.filterstrat.filterMovies(movies));
        //called by MainScreenGUI when theatre chosen
        //get arrayList of offered movies from theatre obj
        //set filterStrat depending on whether user is null
        //use filterStrat to select which offeredmovies to display
        //call loadTheatreMovies in gui
    }
    public void selectShowtime(Showtime showtime){
        //called by MainScreenGUI when showtime selected
        if(LocalDate.now().isBefore(showtime.getMovie().getMovie().getAnnouncementDate())){
            this.seatCapStrat = new MaxTenPercent();
        }
        else{
            this.seatCapStrat = new MaxHundredPercent();
        }
        //set seatCapStrat depending on whether showtime is currently in early access
        if(this.seatCapStrat.allowSeatBooking(showtime.getSeatArray())){
            SeatController seatController = new SeatController(this.user,showtime);
        }
        else{
            Dialog notify = new Dialog();
            notify.add(new Paragraph("This showtime cannot be booked because 10% of seats have been booked already. Wait until the public announcement date"));
            notify.open();
        }
        //use seatCapStrat to decide if showtime can be booked
        //if not, send error message
        // else, instantiate and open seatcontroller, passing in user and showtime objs
    }

    public void viewTicket(int ticketCode){
        TicketController ticketController = new TicketController(this);
        ticketController.viewTicket(ticketCode);
        //instantiates ticketController
        //calls viewTicket in ticketController and pass in ticketCode
    }
}

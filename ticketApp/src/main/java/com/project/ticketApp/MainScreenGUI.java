package com.project.ticketApp;
import java.time.format.DateTimeFormatter;
//stubs done
import java.util.ArrayList;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;

public class MainScreenGUI extends VerticalLayout{
    private MainController parentController;

    //start components...
    NumberField ticketNF = new NumberField("Enter ticket code:");
    Button viewTicket = new Button("View ticket");
    ComboBox<Theatre> theatreCB = new ComboBox<Theatre>("Choose theatre:");
    Button selectTheatre = new Button("Select theatre");
    Accordion movieAC = new Accordion();
    //end components

    //start important functs...
    public MainScreenGUI(ArrayList<Theatre> theatreList, MainController parentController){
        this.parentController = parentController;
        initHeader();
        initTicketGroup();//Build a numberfield for ticketcode and "view ticket" button
        initTheatreGroup(theatreList);//build combobox of theatres and "select theatre" button
    }
    private void viewTicket(int ticketCode){
        parentController.viewTicket(ticketCode);
    }
    private void selectTheatre(Theatre theatre){//called when select theatre button pressed
        parentController.loadTheatreMovies(theatre);//call loadTheatreMovies in main controller
    }
    private void selectShowtime(Showtime showtime){//called when user clicks selects a showtime in the accordion
        parentController.selectShowtime(showtime);
    }
    public void loadTheatreMovies(ArrayList<OfferedMovie> movieList){//called by main controller when 
                                                            //offered movies for this theatre fetched
        Accordion movieAC = new Accordion();//clear accordion
        for (OfferedMovie om : movieList){//build Accordion of offeredmovies
            VerticalLayout omLayout = new VerticalLayout();//build grid of showtimes  in each panel
            omLayout.add(new Paragraph("Select showtime:"));
            
            ArrayList<Showtime> omShowtimes = om.getShowtimes();
            Grid<Showtime> omGrid = new Grid<Showtime>();
            omGrid.setItems(omShowtimes);
            omGrid.addColumn(new LocalDateTimeRenderer<>(Showtime::getTime,
                "yyyy-MM-dd")).setHeader("Date").setSortable(true)
                .setComparator(Showtime::getTime);
            omGrid.addColumn(new LocalDateTimeRenderer<>(Showtime::getTime,
            "HH:mm")).setHeader("Time");
            omGrid.addComponentColumn(st -> {
                Button getTick = new Button("Get tickets");
                getTick.addClickListener(ClickEvent -> {selectShowtime(st);});
                return getTick;
            });
            omLayout.add(omGrid);
            
            movieAC.add(om.getMovie().getMovieName(),omLayout);
        } 
    }
    //end importnat functs

    //start helper functs...
    private void initHeader() {
        H1 header = new H1("Ticket Reservation App");
        add(header);
    }
    private void initTicketGroup() {
        HorizontalLayout ticketGroup = new HorizontalLayout();

        ticketGroup.add(ticketNF);
        viewTicket.addClickListener(ClickEvent -> {viewTicket(ticketNF.getValue().intValue());});
        ticketGroup.add(viewTicket);

        add(ticketGroup);
    }
    private void initTheatreGroup(ArrayList<Theatre> theatreList) {
        HorizontalLayout theatreGroup = new HorizontalLayout();

        theatreCB.setItems(theatreList);
        theatreCB.setItemLabelGenerator(Theatre::getName);
        theatreGroup.add(theatreCB);

        selectTheatre.addClickListener(ClickEvent -> {selectTheatre(theatreCB.getValue());});
        theatreGroup.add(selectTheatre);

        add(theatreGroup);
    }
    //end helper functs
}

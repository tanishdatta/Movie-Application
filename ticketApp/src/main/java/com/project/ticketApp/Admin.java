package com.project.ticketApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;
import com.vaadin.flow.component.datepicker.DatePicker;


public class Admin extends VerticalLayout implements PaymentObserver{
        Button registerUser = new Button("Register User");
        NumberField creditCardNO = new NumberField("Enter creditCardNumber");
        TextField usernameTF = new TextField("Username");
        TextField passwordField = new TextField("Password");
        TextField name = new TextField("Full Name");
        TextField creditCardHolder = new TextField("Credit Card Holder");

        Button addTheatre = new Button("Add Theatre");
        TextField theatreName = new TextField("Theater Name");

        Button addMovie = new Button("Add Movie");
        TextField movieName = new TextField("Movie Name");
        DatePicker movieAnnounce = new DatePicker("Announcement Date");

        Button addShowtime = new Button("Add Showtime");
        TextField showtimeName = new TextField("Movie Name");
        TextField showtimeTheatre = new TextField("Theatre");
        DatePicker showtime_date = new DatePicker("Date of Showtime");
        TimePicker showtime_time = new TimePicker("Time of Showtime");

        Button addOfferedMovie = new Button("Add Offered Movie");
        TextField offeredMovieName = new TextField("Movie Name");
        TextField offeredMovieTheatre = new TextField("Theatre");

        int creditCardNOINT;
        String usernameSTRING;
        String passwordString;
        String nameSTRING;
        String creditCardHolderSTRING;


        public Admin() {
            H1 header = new H1("ADMIN FOR TICKET RESERVATION APP");
            add(header);

            HorizontalLayout registerGroup = new HorizontalLayout();
            registerGroup.add(usernameTF);
            registerGroup.add(passwordField);
            registerGroup.add(creditCardNO);
            registerGroup.add(name);
            registerGroup.add(creditCardHolder);
            registerUser.addClickListener(ClickEvent -> {registerUser(creditCardNO.getValue().intValue(), usernameTF.getValue(), passwordField.getValue(), name.getValue(), creditCardHolder.getValue());});
            registerGroup.add(registerUser);
            
            add(registerGroup);

            HorizontalLayout theatreGroup = new HorizontalLayout();
            theatreGroup.add(theatreName);
            addTheatre.addClickListener(ClickEvent ->{addTheatre(theatreName.getValue());});
            theatreGroup.add(addTheatre);

            add(theatreGroup);

            HorizontalLayout movieGroup = new HorizontalLayout();
            movieGroup.add(movieName);
            movieGroup.add(movieAnnounce);
            addMovie.addClickListener(ClickEvent ->{addMovie(movieName.getValue(), movieAnnounce.getValue());});
            movieGroup.add(addMovie);

            add(movieGroup);

            HorizontalLayout offeredMovieGroup = new HorizontalLayout();
            offeredMovieGroup.add(offeredMovieName);
            offeredMovieGroup.add(offeredMovieTheatre);
            addOfferedMovie.addClickListener(ClickEvent ->{addOfferedMovie(offeredMovieName.getValue(), offeredMovieTheatre.getValue());});
            offeredMovieGroup.add(addOfferedMovie);

            add(offeredMovieGroup);

            HorizontalLayout showtimeGroup = new HorizontalLayout();
            showtimeGroup.add(showtimeName);
            showtimeGroup.add(showtimeTheatre);
            showtimeGroup.add(showtime_date);
            showtimeGroup.add(showtime_time);
            addShowtime.addClickListener(ClickEvent ->{addShowtime(showtimeName.getValue(), showtimeTheatre.getValue(), showtime_date.getValue(), showtime_time.getValue());});
            showtimeGroup.add(addShowtime);

            add(showtimeGroup);

        }

        public void addMovie(String movieName, LocalDate announcDate){
            try {
                MoviesSingleton.getInstance().addMovie(movieName, announcDate);
                Dialog notify = new Dialog();
            notify.add(new Paragraph("Movie added"));
            notify.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void addShowtime(String movieName, String theatreName, LocalDate showtime_date, LocalTime showtime_time){
            try{
                boolean check = TheatresSingleton.getInstance().addShowtime(movieName, theatreName, showtime_date, showtime_time);
                if(check){
                    Dialog notify = new Dialog();
                    notify.add(new Paragraph("Showtime added"));
                    notify.open();
                }
                else{
                    Dialog notify = new Dialog();
                    notify.add(new Paragraph("Theatre or Movie doesn't exist"));
                    notify.open();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        public void addOfferedMovie(String movieName, String theatreName){
            try{
                boolean check = TheatresSingleton.getInstance().addOfferedMovie(movieName, theatreName);
                if(check){
                    Dialog notify = new Dialog();
                    notify.add(new Paragraph("Offered movie added"));
                    notify.open();
                }
                else{
                    Dialog notify = new Dialog();
                    notify.add(new Paragraph("Theatre or Movie does not exist"));
                    notify.open();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        public void registerUser(int creditCardNO, String username, String password, String name, String creditCardHolder){
            this.creditCardHolderSTRING = creditCardHolder;
            this.creditCardNOINT = creditCardNO;
            this.passwordString = password;
            this.nameSTRING = name;
            this.usernameSTRING = username;
            PaymentController paymentController = new PaymentController(20, this);
        }

        public void addTheatre(String theatreName){
            try {
                TheatresSingleton.getInstance().addTheatre(theatreName);
                Dialog notify = new Dialog();
            notify.add(new Paragraph("Theatre added"));
            notify.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paymentGood() {
            try{
                UsersSingleton.getInstance().addUser(this.usernameSTRING, this.passwordString, this.nameSTRING, this.creditCardNOINT, this.creditCardHolderSTRING, LocalDate.now());
            }catch(SQLException e){
                e.printStackTrace();
            }

            Dialog notify = new Dialog();
            notify.add(new Paragraph("You are now registered"));
            notify.open();
            
        }



    
    
}
       



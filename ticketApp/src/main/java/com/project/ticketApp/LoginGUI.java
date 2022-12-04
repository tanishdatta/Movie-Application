package com.project.ticketApp;
//stubs done

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class LoginGUI extends Dialog {
    private LoginController parentController;
    
    //start components...
    TextField usernameTF = new TextField("Username");
    PasswordField passwordField = new PasswordField("Password");
    Button login = new Button("Login");
    Button loginGuest = new Button("Login as guest");
    //end components

    
    //start important functions...
    public LoginGUI(LoginController parentController){
        this.parentController = parentController;//set parent control
        initLoginFields();//build username textfield and password field
        initButtons();//build submit button and login as guest button
    }
    
    private void verifyLogin(String username, String password){//called when submit button pressed
        parentController.verifyLogin(username, password);//call verifyLogin in logincontroller, passing in login info
    }
    private void guestLogin(){//called when logging in as guest
        parentController.guestLogin();//call guestLogin in logincontroller
    }
    //end important functions
    

    //start helper functions...
    private void initLoginFields() {
        add(usernameTF);
        add(passwordField);
    }
    private void initButtons() {
        HorizontalLayout buttons = new HorizontalLayout();

        login.addClickListener(ClickEvent -> {verifyLogin(usernameTF.getValue(), passwordField.getValue());});
        buttons.add(login);
        loginGuest.addClickListener(ClickEvent -> {guestLogin();});
        buttons.add(loginGuest);

        add(buttons);
    }
    //end helper functions

}

package com.project.ticketApp;
//stubs done

import com.vaadin.flow.component.dialog.Dialog;

public class LoginGUI extends Dialog {
    private LoginController parentController;

    public LoginGUI(LoginController parentController){
        //set parent control
        //build username textfield
        //build password field
        //build submit button and login as guest button
    }
    private void verifyLogin(String username, String password){
        //called when submit button pressed
        //call verifyLogin in logincontroller, passing in login info
    }
    private void guestLogin(){
        //called when logging in as guest
        //call guestLogin in logincontroller
    }
}

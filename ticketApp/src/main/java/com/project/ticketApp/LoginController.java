package com.project.ticketApp;

public class LoginController {
    private MainController parentController;
    private RegisteredUser user;
    private LoginGUI gui;

    public LoginController(MainController parentController){
        //instantiate and open logingui, passing in this
    }
    public void verifyLogin(String username, String password){
        //called by logingui when login info submitted
        //call verifyLogin in UsersSingleton (receive registereduser obj)
        //if user exists, call loginsuccess in main controller, passing in user obj
    }
    public void guestLogin(){
        //calledby logingui when logging in as regular user
        //call loginsuccess in main controller, passing in null
    }
}

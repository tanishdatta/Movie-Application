package com.project.ticketApp;
//stubs done
public class LoginController implements PaymentObserver{
    private MainController parentController;
    private RegisteredUser user;
    private LoginGUI gui;

    public LoginController(MainController parentController){
        //instantiate and open logingui, passing in this
    }
    public void verifyLogin(String username, String password){
        //called by logingui when login info submitted
        //call verifyLogin in UsersSingleton (receive registereduser obj)
        //if user exists,
        //if last payment is within a year
        //else instancate payment controller passing in user and $20
    }
    public void guestLogin(){
        //calledby logingui when logging in as regular user
        //call loginsuccess in main controller, passing in null
    }

    @Override
    public void paymentGood() {
        // called by payment controller
        // call loginsuccess in main controller, passing in user obj 
        
    }
}

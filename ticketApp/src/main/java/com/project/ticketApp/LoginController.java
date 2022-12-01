package com.project.ticketApp;
//stubs done
public class LoginController implements PaymentObserver{
    private MainController parentController;
    private RegisteredUser user;
    private LoginGUI gui;

    //need to add itself to paymentObserver

    public LoginController(MainController parentController){
        //instantiate and open logingui, passing in this
    }
    public void verifyLogin(String username, String password){
        //called by logingui when login info submitted
        //call verifyLogin in UsersSingleton (receive registeredUser obj)
        //if user exists
            //NESTED IF AND ELSE STATEMENTS
            //if last payment is within a year
                //call login success in registeredUser and pass in registeredUser object
            //else
                //set this.user as the user we got from the singleton
                // instantiate payment controller passing in user and $20
        //else error message
    }
    public void guestLogin(){
        //called by logingui when logging in as regular user
        //call loginsuccess in main controller, passing in null
    }

    @Override
    public void paymentGood() {
        // called by payment controller
        // call updateUserSubscription passing in the user object
        // call loginsuccess in main controller, passing in user obj 
        
    }
}

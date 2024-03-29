package com.project.ticketApp;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;

import java.time.LocalDate;

//stubs done
public class LoginController implements PaymentObserver{
    private MainController parentController;
    private RegisteredUser user;
    private LoginGUI gui;

    //need to add itself to paymentObserver

    public LoginController(MainController parentController){
        this.parentController = parentController;
        this.gui = new LoginGUI(this);
        gui.open();
        //instantiate and open logingui, passing in this
    }
    public void verifyLogin(String username, String password){
        //called by logingui when login info submitted
        //call verifyLogin in UsersSingleton (receive registeredUser obj)
        try {
            this.user = UsersSingleton.getInstance().verifyLogin(username, password);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        if(this.user != null){
            if(user.getLastPaid().isAfter(LocalDate.now().minusYears(1))){
                this.parentController.loginSuccess(this.user);
                gui.close();
            }

            else{
                Dialog notify = new Dialog();
                notify.add(new Paragraph("Subscription expired.  Please pay for subscription"));
                Button confirm = new Button("OK");
                confirm.addClickListener(ClickEvent ->{
                    PaymentController paymentController = new PaymentController(this.user, 20, this);
                    notify.close();
                    gui.close();
                });
                notify.add(confirm);
                Button nope = new Button("Take me back to login");
                nope.addClickListener(ClickEvent -> {
                    notify.close();
                });
                notify.add(nope);
                notify.open();
                
                
                
            }
            //if user exists
            //NESTED IF AND ELSE STATEMENTS
            //if last payment is within a year
            //call login success in registeredUser and pass in registeredUser object
            //else
            //set this.user as the user we got from the singleton
            // instantiate payment controller passing in user and $20
        }

        else{
            Dialog notify = new Dialog();
            notify.add(new Paragraph("Login information incorrect"));
            notify.open();
        }//else error message
    }
    public void guestLogin(){
        //called by logingui when logging in as regular user
        //call loginsuccess in main controller, passing in null
        parentController.loginSuccess(null);
        gui.close();
    }

    @Override
    public void paymentGood() {
        // called by payment controller
        try {
            UsersSingleton.getInstance().updateUserSubscription(this.user);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        this.parentController.loginSuccess(this.user);
        // call updateUserSubscription passing in the user object
        // call loginsuccess in main controller, passing in user obj 
        
    }
    public void adminLogin() {
        parentController.adminLogin();
    }
}

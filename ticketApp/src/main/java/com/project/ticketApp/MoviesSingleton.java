package com.project.ticketApp;

public class MoviesSingleton extends Singleton<Movie>{
    private static MoviesSingleton instance;

    public static MoviesSingleton getInstance(){
        return instance;
    }
    private MoviesSingleton(){
        //Instantiate movie objects in arraylist based on database
    }

    public Movie getMovie(String movieName){
        //Returns Movie object in array that corresponds with given String
        return null;
    }
    
}

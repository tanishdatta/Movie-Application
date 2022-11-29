package com.project.ticketApp;

import java.util.ArrayList;

public interface SeatCapStrategy{
    public boolean allowSeatBooking(ArrayList<ArrayList<boolean>> seatTable);

}
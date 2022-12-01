package com.project.ticketApp;

import java.util.ArrayList;

//Stub Finished
public class MaxHundredPercent implements SeatCapStrategy {

	@Override
	public boolean allowSeatBooking(ArrayList<ArrayList<Boolean>> seatTable) {
		//check % of seats in array that are full
		//return true if less than 100%
		return false;
	}

}
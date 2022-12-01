package com.project.ticketApp;

import java.util.ArrayList;

//Stub Finished
public class MaxTenPercent implements SeatCapStrategy{

	@Override
	public boolean allowSeatBooking(ArrayList<ArrayList<Boolean>> seatTable) {
		//check % of seats in array that are full
		//return true if less than 10%
		return false;
	}

}
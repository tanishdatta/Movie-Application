package com.project.ticketApp;

import java.util.ArrayList;

//Stub Finished
public class MaxHundredPercent implements SeatCapStrategy {

	@Override
	public boolean allowSeatBooking(ArrayList<ArrayList<Boolean>> seatTable) {
		//check % of seats in array that are full
		//return true if less than 100%
		int seatcount= 0;
		for (int y = 0; y <seatTable.size(); y++){
			for (int x = 0; x< seatTable.get(y).size(); x++){
				if (seatTable.get(y).get(x)== true){
					seatcount++;
				}
			}
		}

		if (seatcount == 100){
			return false;
		}
		else{
			return false;
		}
		
	}

}
package com.project.ticketApp;

import java.util.ArrayList;

//Stub Finished
public class MaxTenPercent implements SeatCapStrategy{

	@Override
	public boolean allowSeatBooking(ArrayList<ArrayList<Boolean>> seatTable) {
		//check % of seats in array that are full
		//return true if less than 10%
		int seatcount= 0;
		for (int y = 0; y <seatTable.size(); y++){
			for (int x = 0; x< seatTable.get(y).size(); x++){
				if (seatTable.get(y).get(x)== true){
					seatcount++;
				}
			}
		}

		if (seatcount > 10){
			return false;
		}
		else{
			return true;
		}

	}

}
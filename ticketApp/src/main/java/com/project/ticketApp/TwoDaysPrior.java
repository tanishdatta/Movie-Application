package com.project.ticketApp;
import java.time.LocalDate;
import java.util.ArrayList;
//Stub Finished
public class TwoDaysPrior implements MovieFilterStrategy{

	@Override
	public ArrayList<OfferedMovie> filterMovies(ArrayList<OfferedMovie> inputList) {
		for(OfferedMovie i : inputList){
			if(i.getMovie().getAnnouncementDate().isAfter(LocalDate.now())){
				inputList.remove(i);
			}
		}
		//If announcementDate is later than two days from now take it out
		//return the list
		return inputList;
	}

}
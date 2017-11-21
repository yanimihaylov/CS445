package Thalia;

import java.util.ArrayList;
import java.util.List;

public class requestShows {

	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
    private static List<Section> Sections = new ArrayList<Section>();
    
    private Section section = new Section();
    
    private requestResponse response = new requestResponse();
    

	
	public requestResponse autoShows(int wid, int sid, int count, int starting) {
		
		List<Seating> Seating = new ArrayList<Seating>();
		List<Seat> Seat = new ArrayList<Seat>();
		
		List<Seat> AvailableSeats = new ArrayList<Seat>();
		List<Seating> AvailableSeating = new ArrayList<Seating>();
		
		List<Seat> FoundSeats = new ArrayList<Seat>();
		List<Seating> FoundSeating = new ArrayList<Seating>();
		
		shows s = is.getShowDetail(wid);
		Sections = s.getSections();
		for(int i = 0; i<Sections.size(); i++) {
			if(Sections.get(i).getSid() == sid) {
				section = Sections.get(i);
			}
		}
		
		int price = section.getPrice();
		response.setTotal_amount(price*count);
		
		response.setInfo(s);
		response.setSid(sid);

		Seating = section.getSeating();
		
		int found = 0;
		
		for(int i = 0; i<Seating.size(); i++) {
			Seat = Seating.get(i).getSeats();
			found=0;
			AvailableSeats = new ArrayList<Seat>();
			
			for(int j = 1; j<Seat.size(); j++) {
				if(((Seat.get(j-1).getStatus()==true) && ((Seat.get(j).getCid()-Seat.get(j-1).getCid()) == 1)) && (Seat.get(j-1).getCid()>starting)){
					if(j==1 && count==1) {
						AvailableSeats.add(Seat.get(j-1));
						found++;

					}
					if(j==1 && count!=1) {
						AvailableSeats.add(Seat.get(j-1));
						found++;
						AvailableSeats.add(Seat.get(j));
						found++;
					}
					else if(j>1 && count!=1) {
						AvailableSeats.add(Seat.get(j));
						found++;
					}
					
					
					
					if(found == count) {
						Seating SeatObj = new Seating(i+1);
						SeatObj.setSeats(AvailableSeats);
						AvailableSeating.add(SeatObj);
						response.setSeating(AvailableSeating);
						response.setStatus("ok");
						return response;	

					}
				}
			}
		}
		response.setStatus("Error " + count + " contiguous seats not avalable");
		return response;		
	}
}
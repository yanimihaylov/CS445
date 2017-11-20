package Thalia;

import java.util.ArrayList;
import java.util.List;

public class requestShows {

	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
    private static List<Section> Sections = new ArrayList<Section>();
    
    private Section section = new Section();
    
    private requestResponse response = new requestResponse();
    

	
	public requestResponse autoShows(int wid, int sid, int count) {
		
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
				System.out.println(sid);
				section = Sections.get(i);
			}
		}
		
		response.setInfo(s);
		response.setSid(sid);
		
		int price = section.getPrice();
		response.setTotal_amount(price*count);
		Seating = section.getSeating();
		
		int found = 0;
		
		for(int i = 0; i<Seating.size(); i++) {
			Seat = Seating.get(i).getSeats();
			System.out.println("Row "+i);
			found=0;
			AvailableSeats = new ArrayList<Seat>();
			
			for(int j = 1; j<Seat.size(); j++) {
				if((Seat.get(j-1).getStatus()==true) || ((Seat.get(j).getCid()-Seat.get(j-1).getCid()) == 1) ){
					if(j==1 && count==1) {
						AvailableSeats.add(Seat.get(j-1));
						found++;
						System.out.println("if 1");

					}
					if(j==1 && count!=1) {
						AvailableSeats.add(Seat.get(j-1));
						found++;
						AvailableSeats.add(Seat.get(j));
						found++;
						System.out.println("if 2");
					}
					else if(j>1 && count!=1) {
						AvailableSeats.add(Seat.get(j));
						found++;
						System.out.println("if 1");
					}
					
					
					
					if(found == count) {
						System.out.println("found == count");
						Seating SeatObj = new Seating(i+1);
						SeatObj.setSeats(AvailableSeats);
						AvailableSeating.add(SeatObj);
						response.setSeating(AvailableSeating);
						return response;	

					}
				}
				System.out.println("Seat "+j);
			}
		}
		return response;		
	}
}

package Thalia;

import java.util.List;

import com.google.gson.JsonElement;

public interface InterfaceSeating {
	
	List<Section> getAllSeats();
	Section createSections(String sct_name, int sID, int price);
	
	Seating createSeating(int r);
	
	Seat createSeats(int id);
	
	Section getSectionDetail(int id);

}

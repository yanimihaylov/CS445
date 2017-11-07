package Thalia;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	private int sid;
	private String section_name;
	private Seating seats;
	

	public List<Seating> seating = new ArrayList<Seating>();
	
	public Section() {
		
	}
	public Section(String sct_name, int sID) {
		section_name = sct_name;
		sid = sID;
	}
	
	public boolean matchesId(int lid) {
		return(lid == this.sid);
	}
	
	public boolean isNil() {
        return false;
    }

}
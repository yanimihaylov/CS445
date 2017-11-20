package Thalia;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	private int sid;
	private String section_name;
	private int price;
	

	public List<Seating> seating = new ArrayList<Seating>();
	
	public Section() {
		
	}
	public Section(String sct_name, int sID, int pr) {
		section_name = sct_name;
		sid = sID;
		price = pr;
	}
	
	public boolean matchesId(int lid) {
		return(lid == this.sid);
	}
	
	public boolean isNil() {
        return false;
    }
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Seating> getSeating() {
		return seating;
	}
	public void setSeating(List<Seating> seating) {
		this.seating = seating;
	}
	
	public String toString() {
		String res = "Section name " + section_name + ", Section ID " + sid + ", Price " + price;
		return res;
	}

}
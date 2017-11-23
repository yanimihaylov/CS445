package Thalia;

import java.util.ArrayList;
import java.util.List;

public class shows {
	
	private int wid;
	
	private String name;
	private String web;
	private String date;
	private String time;
	
	private showInfo showInfo;
	private List<Section> seating_info = new ArrayList<Section>();
	
	public shows() {
		
	}
	
	public shows(String name, String web, String date, String time) {
		showInfo = new showInfo(name, web, date, time);
		
		this.wid = UniqueIdGenerator.getUniqueShowID();
	}
	
	
	public showInfo getShowInfo() {
		return showInfo;
	}
	
	
	public void setShowInfo(showInfo showInfo) {
		this.showInfo = showInfo;
	}

	public int getID() {
		return this.wid;
	}
	
	public boolean matchesId(int lid) {
		return(lid == this.wid);
	}
	
	public boolean isNil() {
        return false;
    }

	public String getName() {
		return name;
	}

	public String getWeb() {
		return web;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public List<Section> getSections(){
		return seating_info;
	}

	public void setSections(List<Section> sections) {
		this.seating_info = sections;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}
	
	public void add(int loc, Section sec) {
		seating_info.add(loc, sec);
	}
	
	public void set(int loc, Section sec) {
		seating_info.set(loc, sec);
	}

}

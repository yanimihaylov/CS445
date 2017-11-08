package Thalia;

import java.util.ArrayList;
import java.util.List;

public class shows {
	
	private int wid;
	
	private String name;
	private String web;
	private String date;
	private String time;
	
	private int sid;
	private double price;
	private List<Section> sections = new ArrayList<Section>();
	
	public shows() {
	}
	
	public shows(String name, String web, String date, String time/*, int sid, double price*/) {
		this.name = name;
		this.web = web;
		this.date = date;
		this.time = time;
		/*this.sid = sid;
		this.price = price;*/
		
		this.wid = UniqueIdGenerator.getUniqueID();
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

	public int getSid() {
		return sid;
	}

	public double getPrice() {
		return price;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}
	
	public void add(Section sec) {
		sections.add(sec);
	}

}

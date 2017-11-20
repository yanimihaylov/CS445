package Thalia;

import java.util.List;

public class orders {
	
	private int oid;
	
	private int wid;
	private int sid;
	private List<Seating> seats;
	private patron pat;

	public orders(int wid, int sid, String name, String phone, String email, String b_a, String cc_n, String cc_exp_d) {
		pat = new patron(name, phone, email, b_a, cc_n, cc_exp_d);
		
		this.oid = UniqueIdGenerator.getUniqueID();
		
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<Seating> getSeats() {
		return seats;
	}

	public void setSeats(List<Seating> seats) {
		this.seats = seats;
	}

	public patron getPat() {
		return pat;
	}

	public void setPat(patron pat) {
		this.pat = pat;
	}
}

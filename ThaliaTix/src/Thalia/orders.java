package Thalia;

import java.util.Date;
import java.util.List;

public class orders {
	
	private int oid;
	
	private int wid;
	private int sid;
	private showInfo showInfo;
	Date dateOrdered;
	private int orderAmount;
	private int numberOfTickets;
	private List<Seating> seats;
	private patron pat;   
	private List<ticket> tickets;

	public orders() {
		
	}
	
	public orders(int wID, int sID, String name, String phone, String email, String b_a, String cc_n, String cc_exp_d) {
		pat = new patron(name, phone, email, b_a, cc_n, cc_exp_d);
		sid = sID;
		wid = wID;
		
		dateOrdered = new Date();
		this.oid = UniqueIdGenerator.getUniqueOrderID();
		
	}
	
	public List<ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<ticket> tickets) {
		this.tickets = tickets;
	}

	public boolean isNil() {
        return false;
    }
	
	public boolean matchesId(int oid) {
		return(oid == this.oid);
	}
	
	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public showInfo getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(showInfo showInfo) {
		this.showInfo = showInfo;
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

	public showInfo getShowI() {
		return showInfo;
	}

	public void setShowI(showInfo showI) {
		this.showInfo = showI;
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
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTix) {
		this.numberOfTickets = numberOfTix;
	}

}

package Thalia;

public class ticket {
	
	private int tid;
	private int price;
	private String status;
	private int wid;
	private showInfo showInfo;
	private patron patronInfo;
	private int sid;
	private String section_name;
	private Seating seating;
	private int row;
	private int cid;
	
	public ticket() {
		
	}
	
	public ticket(int pr, int wID, int sID, String section_n) {
		price = pr;
		wid = wID;
		sid = sID;
		section_name = section_n;
		status = "open";
		
		this.tid = UniqueIdGenerator.getUniqueTicketID();
	}
	
	
	public boolean isNil() {
        return false;
    }
	
	public boolean matchesId(int tid) {
		return(tid == this.tid);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public showInfo getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(showInfo showInfo) {
		this.showInfo = showInfo;
	}

	public patron getPatronInfo() {
		return patronInfo;
	}

	public void setPatronInfo(patron patronInfo) {
		this.patronInfo = patronInfo;
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

	public Seating getSeating() {
		return seating;
	}

	public void setSeating(Seating seating) {
		this.seating = seating;
	}
}

package Thalia;

public class Seat{
		
		int cid;
		int seat;
		boolean status;
		//static int i = 1;
		
	public Seat(int id, int s) {
		seat = s;
		status = true;
		cid=id;
		//i++;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public int getCid() {
		return cid;
	}
	
	public int getSeat() {
		return seat;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}

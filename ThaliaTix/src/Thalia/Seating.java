package Thalia;

import java.util.ArrayList;
import java.util.List;

public class Seating{
		
		int row;
		public List<Seat> seats = new ArrayList<Seat>();
		
	public Seating(int r) {
		row = r;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	

}

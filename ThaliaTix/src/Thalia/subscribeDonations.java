package Thalia;

import java.util.ArrayList;
import java.util.List;

public class subscribeDonations {
	
		private int did;
		private int wid;
		private int count;
		private List<ticket> tickets = new ArrayList<ticket>();
		private patron patron_info;
		
		public subscribeDonations(int wID, int c) {
			wid = wID;
			count = c;

			this.did = UniqueIdGenerator.getUniqueDonationID();
		}
		
		public subscribeDonations() {
			
		}
		
		public boolean isNil() {
	        return false;
	    }
		
		public boolean matchesId(int did) {
			return(did == this.did);
		}
		
		public int getDid() {
			return did;
		}

		public void setDid(int did) {
			this.did = did;
		}

		public int getWid() {
			return wid;
		}

		public void setWid(int wid) {
			this.wid = wid;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public List<ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<ticket> tickets) {
			this.tickets = tickets;
		}

		public patron getPatron_info() {
			return patron_info;
		}

		public void setPatron_info(patron patron_info) {
			this.patron_info = patron_info;
		}
		
		
}

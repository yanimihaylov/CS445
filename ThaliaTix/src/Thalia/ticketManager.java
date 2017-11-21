package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ticketManager implements InterfaceTicket{
    private static List<ticket> Tickets = new ArrayList<ticket>();
    int location;

    
    public ticket createTicket(int price, int wid, int sid, String sectn_n) {
    		ticket tic = new ticket(price, wid, sid, sectn_n);
    		Tickets.add(tic);
    		return tic;
    }
    
    public List<ticket> getAllTickets(){
    		return Tickets;
    }
    
    private ticket findById(int tid) {
    	location = 0;
        Iterator<ticket> li = Tickets.listIterator();
        
        while(li.hasNext()) {
        		
        		ticket s = li.next();
        
        		if(s.matchesId(tid))
            		return(s);
        		
        		location++;
        }
        return(new NullTicket());
    }
    
	public ticket getTicketDetail(int tid) {
		return(findById(tid));
	}
}

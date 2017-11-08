package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowManager implements InterfaceShows {
	
    private static List<shows> Shows = new ArrayList<shows>();
    private int location;

    public List<shows> getAllShows() {
        return(Shows);
    }

    public shows createShow(String name, String web, String date, String time/*, int sid, double price*/) {
        shows s= new shows(name, web, date, time/*, sid, price*/);
        Shows.add(s);
        return(s);
    }

    private shows findById(int lid) {
    	location = 0;
        Iterator<shows> li = Shows.listIterator();
        
        while(li.hasNext()) {
        		
        		shows s = li.next();
        
        		if(s.matchesId(lid))
            		return(s);
        		
        		location++;
        }
        return(new NullShow());
    }
    
    public void updateShow(int id, shows s) {
    		shows rep = findById(id);
    		Shows.set(location, s);
    }

	public shows getShowDetail(int lid) {
		return(findById(lid));
	}
	
	
}

import java.util.*;

public class checkAccount{
	
	public int check(String u, String p, ArrayList<Account> l){

		
		if(u.equals(l.get(0).getUsername()) && p.equals(l.get(0).getPassword()))
		{
			return 0;
		}

		else{
			for(int i=1; i<l.size(); i++){
				if(u.equals(l.get(i).getUsername()) && p.equals(l.get(i).getPassword())){
					return i;
				}
			}
			return -1;
		}
	}

	public int checkExisting(Account a, ArrayList<Account> l){
		for(int i=0; i<l.size(); i++){
			if(a.getUsername().equals(l.get(i).getUsername()))
				return 1;
		}
		return 0;
	}
}
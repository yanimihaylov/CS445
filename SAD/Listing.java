
public class Listing {
	
	String category;
	String name;
	String startDate;
	String endDate;
	String description;
	
	public Listing(){
		String name="";
		String startDate="";
		String endDate="";
		String description="";
	}
	
	public Listing(String c, String n, String sd, String ed, String desc){
		category=c;
		name=n;
		startDate=sd;
		endDate=ed;
		description=desc;
	}
	
	public String getCategory(){
		return category;
	}

	public String getName(){
			return name;
	}
	
	public String getStartDate(){
		return startDate;
	}
	
	public String getEndDate(){
		return endDate;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setCategory(String ca){
		category=ca;
	}

	public void setName(String na){
		name=na;
	}
	
	public void setStartDate(String sDate){
		startDate=sDate;
	}
	
	public void setEndDate(String eDate){
		endDate=eDate;
	}

	public void setDescription(String des){
		description=des;
	}
	
	public String toString(){
		String str = ("\nCategory " + category + "\n " + name + "\n Start date (mm/dd/yy): " + startDate + 
						"\n End date (mm/dd/yy): " + endDate + 
						"\n Listing description: " + description);
		return str;
	}
}

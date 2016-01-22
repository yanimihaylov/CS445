import java.util.*;
public class HomePageFeatured extends Listing{
	
	public HomePageFeatured(String c, String n, Date sd, Date ed, String d){
		super(c, n, sd, ed, d);
	}
	
	public String toString(){
		String str = ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
		return str;
	}
}
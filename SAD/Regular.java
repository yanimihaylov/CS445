public class Regular extends Listing{
	
	public Regular(String c, String n, String sd, String ed, String d){
		super(c, n, sd, ed, d);
	}
	
	public String toString(){
		String str = ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
		return str;
	}
}
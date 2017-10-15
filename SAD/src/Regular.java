import java.util.Date;
public class Regular extends Listing{
	
	public Regular(String c, String n, Date sd, Date ed, String d){
		super(c, n, sd, ed, d);
	}
	
	public String toString(){
		return ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
	}
}
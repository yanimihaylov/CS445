import java.util.*;
public class Regular extends Listing{
	
<<<<<<< HEAD
	public Regular(String c, String n, Date sd, Date ed, String d){
=======
	public Regular(String c, String n, String sd, String ed, String d){
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
		super(c, n, sd, ed, d);
	}
	
	public String toString(){
		String str = ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
		return str;
	}
}
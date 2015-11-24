public class CategoryFeatured extends Listing{
	
	public CategoryFeatured(String n, String sd, String ed, String d){
		super(n, sd, ed, d);
	}
	
	public String toString(){
		String str = ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
		return str;
	}
}
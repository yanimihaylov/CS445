import java.util.*;
public class adminLogin extends Login{
	
	Login l = new Login();
	Scanner scan = new Scanner(System.in);
	
	public void displayOptions(){
		System.out.println("\n1. Create listing");
		System.out.println("2. Modify listing");
		System.out.println("3. Remove listing");
		System.out.println("4. View listings");
		System.out.println("5. Logout");
	}
	
	public void options(){
		displayOptions();
		String selection = scan.next();
		
		if(selection.equals("1")){
			createListing();
		}
		
		if(selection.equals("4")){
			viewListings();
		}
		
		if(selection.equals("5")){
			System.out.println("You have been logged out");
			System.exit(0);
		}
	}
	
	public void createListing(){
		Regular l1 = new Regular("Company 1","03/21/1994","04/21/1994","regular listing test");
		HomePageFeatured l2 = new HomePageFeatured("Company 2","03/21/1994","04/21/1994","Home Page Featured listing test");
		CategoryFeatured l3 = new CategoryFeatured("Company 3","03/21/1994","04/21/1994","Category Featured listing test");
		
		Listing[] listingArray = Login.getArray();
		
		listingArray[0]=l1;
		listingArray[1]=l2;
		listingArray[2]=l3;
		options();
	}
	
	public void viewListings(){
		for(int i=0; i<3; i++){
			System.out.println("\n"+listingArray[i].toString());
		}
		options();
	}
}

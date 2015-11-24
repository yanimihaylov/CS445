import java.util.*;
public class adminLogin extends Login{
	
	Login l = new Login();
	CreateListing cr = new CreateListing();
	Scanner scan = new Scanner(System.in);
	ArrayList<Listing> listingsArray = l.getArrayList();

	public void displayOptions(){
		System.out.println("\n1. Create listing");
		System.out.println("2. Modify listing");
		System.out.println("3. Remove listing");
		System.out.println("4. View listings");
		System.out.println("5. Logout");
	}
	
	public void options(){
		displayOptions();
		int selection = scan.nextInt();

		switch(selection){

			case 1:
				createListing();
				break;
			case 4:
				viewListings();
				break;
			case 5:
				System.out.println("You have been logged out");
				System.exit(0);

			default:
				System.out.println("Unrecognized input");
				options();
				break;
		}
	}
	
	public void createListing(){

		listingsArray.add(cr.createListing());
		options();
	}
	
	public void viewListings(){
		for(int i = 0; i<listingsArray.size(); i++)
		System.out.println(listingsArray.get(i).toString());

		options();
	}
}

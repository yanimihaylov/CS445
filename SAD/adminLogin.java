import java.util.*;
public class adminLogin extends Login{
	
	Login l = new Login();
	CreateListing cr = new CreateListing();
	readFile r = new readFile();
	modifyListing mod = new modifyListing();
	viewListing v = new viewListing();
	Scanner scan = new Scanner(System.in);
	ArrayList<Listing> listingsArray = new ArrayList<Listing>();

	public void displayOptions(){
		listingsArray.addAll(r.read());
		System.out.println("\n1. Create listing");
		System.out.println("2. Modify listing");
		System.out.println("3. Remove listing");
		System.out.println("4. View listings");
		System.out.println("5. Search");
		System.out.println("6. Logout");
	}
	
	public void options(){
		displayOptions();
		String selection = scan.next();

		switch(selection){

			case "1":
				createListing();
				break;

			case "2":
				modifyListing();
				break;

			case "3":
				removeListing();
				break;

			case "4":
				viewListings();
				break;

			case "5":
				search();
				break;

			case "6":
				System.out.println("You have been logged out");
				System.exit(0);

			default:
				System.out.println("\nUnrecognized input");
				options();
				break;
		}
	}

	public void readFile(){
		listingsArray.addAll(r.read());
		for(int i = 0; i<listingsArray.size(); i++)
			System.out.println(listingsArray.get(i).toString());
		options();
	}
	
	public void createListing(){

		listingsArray.add(cr.createListing());
		options();
	}

	public void removeListing(){

		System.out.println("Enter company name");
		String companyName = scan.next();
		boolean flag = false;
		int i=0;
		int location;
		while(flag == false || i<listingsArray.size()){
			if(listingsArray.get(i).getName().equalsIgnoreCase(companyName)){
				listingsArray.remove(i);
				flag = true;
			}
			i++;
		}
		System.out.println("Company deleted from database");
		options();
	}

	public void modifyListing(){

		System.out.println("Enter company name");
		String companyName = scan.next();
		boolean flag = false;
		int i=0;
		int location = 0;
		while(flag == false && i<listingsArray.size()){
			if(listingsArray.get(i).getName().equalsIgnoreCase(companyName)){
				location=i;
				flag = true;
			}
			i++;
		}
		listingsArray = mod.modify(listingsArray, i-1);
		System.out.println("\nCompany info modified");
		options();
	}

	public void search(){

		System.out.println("\nEnter company name");
		String companyName = scan.next();
		boolean flag = false;
		boolean found = false;
		int i=0;
		int location=0;

		while(flag == false && i<listingsArray.size()){
			if(listingsArray.get(i).getName().equalsIgnoreCase(companyName)){
				location=i;
				flag = true;
				found = true;
			}
			i++;
		}

		if(found == true)
			System.out.println(listingsArray.get(location).toString());
		else
			System.out.println("\nListing not found");

			options();
		
	}
	
	public void viewListings(){
		v.view(listingsArray);
		options();
	}
}

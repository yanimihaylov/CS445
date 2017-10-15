import java.util.ArrayList;
import java.util.Scanner;
public class adminLogin{
	
	Login l = new Login();
	CreateListing cr = new CreateListing();
	dataIO r = new dataIO();
	modifyListing mod = new modifyListing();
	viewListing v = new viewListing();
	Scanner scan = new Scanner(System.in);
	ArrayList<Listing> listingsArray = new ArrayList<Listing>();

	public void start(){
		listingsArray.clear();
		listingsArray.addAll(r.read());
		options();
	}

	public void displayOptions(){
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
				exit();
				break;

			default:
				System.out.println("\nUnrecognized input");
				options();
				break;
		}
	}

	public void exit(){
		System.out.println("1. Save and Exit\n2. Exit without saving changes\n3. Cancel");
		String selection = scan.next();

		switch(selection){

			case "1":
				r.write(listingsArray);
				System.out.println("Data has been saved.\nYou have been logged out.");
				return;

			case "2":
				System.out.println("Data has not been saved.\nYou have been logged out.");
				return;

			case "3":
				options();
				return;

			default:
				System.out.println("\nUnrecognized input");
				exit();
				break;
		}
	}

	public void data(){
		listingsArray.addAll(r.read());
		for(int i = 0; i<listingsArray.size(); i++)
			System.out.println(listingsArray.get(i).toString());
		options();
	}
	
	public void createListing(){
		Listing list = cr.createListing();
		list.setOwner(0);
		listingsArray.add(list);
		options();
	}

	public void removeListing(){
		v.viewHomePage(listingsArray);
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
		System.out.println("Company deleted from Database");
		options();
	}

	public void modifyListing(){
		v.viewHomePage(listingsArray);
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
		listingsArray = mod.modify(listingsArray, location);
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
		v.view(listingsArray, 0);
		options();
	}
}

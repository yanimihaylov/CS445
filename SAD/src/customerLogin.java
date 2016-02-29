import java.util.ArrayList;
import java.util.Scanner;
public class customerLogin{
	
	Login l = new Login();
	CreateListing cr = new CreateListing();
	dataIO r = new dataIO();
	modifyListing mod = new modifyListing();
	viewListing v = new viewListing();
	Scanner scan = new Scanner(System.in);
	ArrayList<Listing> listingsArray = new ArrayList<Listing>();
	int id;


	public void start(int pid){
		listingsArray.clear();
		listingsArray.addAll(r.read());
		v.viewHomePage(listingsArray);
		id=pid;
		options();
	}

	public void displayOptions(){
		System.out.println("\n1. Create listing\n2. View listings\n3. Search\n4. Logout");
	}

		public void options(){
		displayOptions();
		String selection = scan.next();

		switch(selection){

			case "1":
				createListing();
				break;

			case "2":
				viewListings();
				break;

			case "3":
				search();
				break;

			case "4":
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
			System.out.println(" \n" + listingsArray.get(location).getName()+"\n   "+listingsArray.get(location).getDescription()+"\n");
		else
			System.out.println("\nListing not found");

			options();
		
	}

	public void createListing(){
		Listing list = cr.createListing();

		if(list.getCategory().equalsIgnoreCase("-1")||(list.getCategory().equalsIgnoreCase("-1"))||
			(list.getDescription().equalsIgnoreCase("-1"))){

			System.out.println("Listing creation canceled.");
			options();
		}

		else{
			list.setOwner(id);
			listingsArray.add(list);
			options();
		}
	}

	public void viewListings(){
		v.view(listingsArray, id);
		options();
	}
}
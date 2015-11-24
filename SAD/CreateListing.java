import java.util.*;
public class CreateListing{
	public Listing createListing(){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter listing name");
		String name = scan.nextLine();

		System.out.println("Enter start date (mm/dd/yy)");
		String sd = scan.nextLine();

		System.out.println("Enter end date (mm/dd/yy)");
		String ed = scan.nextLine();		

		System.out.println("Enter a short description");
		String desc = scan.nextLine();

		System.out.println("Enter listing type");
		String type = scan.nextLine();

		if(type.equalsIgnoreCase("r")){
			Regular listing = new Regular(name,sd,ed,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("hpf")){
			HomePageFeatured listing = new HomePageFeatured(name,sd,ed,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("cf")){
			CategoryFeatured listing = new CategoryFeatured(name,sd,ed,desc);
			return listing;
		}

		else{
			createListing();
			Listing other = new Listing();
			return other;
		}

	}
}
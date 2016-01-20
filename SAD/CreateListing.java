import java.util.*;
public class CreateListing{
	public Listing createListing(){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter listing category (Services, Buying, Selling)");
		String cat = scan.nextLine();

		System.out.println("Enter listing name");
		String name = scan.nextLine();

		System.out.println("Enter start date (mm/dd/yy)");
		String sd = scan.nextLine();

		System.out.println("Enter end date (mm/dd/yy)");
		String ed = scan.nextLine();		

		System.out.println("Enter a short description");
		String desc = scan.nextLine();

		System.out.println("Enter listing type (Regular, HomePageFeatured, CategoryFeatured)");
		String type = scan.nextLine();


		if(type.equalsIgnoreCase("Regular")){
			Regular listing = new Regular(cat,name,sd,ed,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("HomePageFeatured")){
			HomePageFeatured listing = new HomePageFeatured(cat,name,sd,ed,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("CategoryFeatured")){
			CategoryFeatured listing = new CategoryFeatured(cat,name,sd,ed,desc);
			return listing;
		}

		else{
			System.out.println("Wrong type.");
			createListing();
			Listing other = new Listing();
			return other;
		}

	}
}
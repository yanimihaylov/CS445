import java.util.*;
import java.text.*;
public class CreateListing{

	Listing l = new Listing();
	public Listing createListing(){

		Scanner scan = new Scanner(System.in);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = new Date();
		Date startDate = new Date(); 
		Date endDate = new Date();

		System.out.println("Enter listing category (Services, Buying, Selling)");
		String cat = scan.nextLine();

		System.out.println("Enter listing name");
		String name = scan.nextLine();

		System.out.println("Enter start date (mm/dd/yy)");
		String sd = scan.nextLine();

		try
		{
			startDate = df.parse(sd);
			if(today.after(startDate)){
				System.out.println("The date cannot be before the current date.\nStarting over.");
				createListing();
			}
		}

		catch (Exception ex ){
			System.out.println(ex);
		}

		System.out.println("Enter end date (mm/dd/yy)");
		String ed = scan.nextLine();		

		try
		{
			endDate = df.parse(ed);
			if(startDate.after(endDate)){
				System.out.println("The start date cannot be after the end date.\nStarting over.");
				createListing();
			}			
		}

		catch (Exception ex ){
			System.out.println(ex);
		}

		System.out.println("Enter a short description");
		String desc = scan.nextLine();

		System.out.println("Enter listing type (Regular, HomePageFeatured, CategoryFeatured)");
		String type = scan.nextLine();

		if(cat.equalsIgnoreCase("-1")||name.equalsIgnoreCase("-1")||
			desc.equalsIgnoreCase("-1")||type.equalsIgnoreCase("-1")){

			Regular listing = new Regular(cat,name,startDate,endDate,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("Regular")){
			Regular listing = new Regular(cat,name,startDate,endDate,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("HomePageFeatured")){
			HomePageFeatured listing = new HomePageFeatured(cat,name,startDate,endDate,desc);
			return listing;
		}

		if(type.equalsIgnoreCase("CategoryFeatured")){
			CategoryFeatured listing = new CategoryFeatured(cat,name,startDate,endDate,desc);
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


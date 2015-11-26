import java.util.*;
public class viewListing{

	Scanner scan = new Scanner(System.in);

	public void view(ArrayList<Listing> list){
		System.out.println("\n1. View Listing by type\n2. Order alphabetically");
		String selection = scan.nextLine();

		switch (selection){
			case "1":
				viewByType(list);
				break;

			default:
				System.out.println("Unrecognized input");
				view(list);
				break;
		}
	}

	public void viewByType(ArrayList<Listing> l){
		System.out.println("\n1. Regular\n2. Category Featured\n3. Home Page Featured");
		String type = scan.nextLine();
		for(int i = 0; i<l.size(); i++){

			switch(type){
				case "1":
					if(l.get(i).getClass().getSimpleName().equalsIgnoreCase("Regular")){
						System.out.println(l.get(i).getName());
					}
					break;

				case "2":
					if(l.get(i).getClass().getSimpleName().equalsIgnoreCase("CategoryFeatured")){
						System.out.println(l.get(i).getName());
					}
					break;

				case "3":
					if(l.get(i).getClass().getSimpleName().equalsIgnoreCase("HomePageFeatured")){
						System.out.println(l.get(i).getName());
					}
					break;

				case "-1":
					break;

				default:
					System.out.println("Unrecognized input");
					viewByType(l);
					break;

			}
		}
	}
}
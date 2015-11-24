import java.util.*;
public class modifyListing{
	public ArrayList<Listing> modify(ArrayList<Listing> list, int location){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Select attribute to change\n1. Name\n2. Start Date\n3. End Date\n4. Description");
		System.out.println(location);
		int selection = scan1.nextInt();

		switch(selection){
			case 1:
				System.out.println("Enter name");
				String name = scan1.next();
				list.get(location).setName(name);
				break;

			case 2:
				System.out.println("Enter start date (mm/dd/yy)");
				String sd = scan1.next();
				list.get(location).setStartDate(sd);
				break;

			case 3:
				System.out.println("Enter end date (mm/dd/yy)");
				String ed = scan1.next();
				list.get(location).setEndDate(ed);
				break;

			case 4:
				System.out.println("Enter short description");
				String desc = scan1.next();
				list.get(location).setDescription(desc);
				break;

			default:
				break;
		}

		return list;
	}
}
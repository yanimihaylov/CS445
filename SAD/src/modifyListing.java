import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class modifyListing{
	public ArrayList<Listing> modify(ArrayList<Listing> list, int location){
		Scanner scan1 = new Scanner(System.in);
		Scanner scanName = new Scanner(System.in);
		Scanner scanDesc = new Scanner(System.in);
		scanName.useDelimiter("\n");
		scanDesc.useDelimiter("\n");
		System.out.println("Select attribute to change\n1. Name\n2. Start Date\n3. End Date\n4. Description");
		System.out.println(location);
		int selection = scan1.nextInt();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = new Date(); 
		Date endDate = new Date();

		switch(selection){
			case 1:
				System.out.println("Enter name");
				String name = scanName.next();
				list.get(location).setName(name);
				break;

			case 2:
				System.out.println("Enter start date (mm/dd/yy)");
				String sd = scan1.next();
				try{
					startDate = df.parse(sd);
					list.get(location).setStartDate(startDate);
				}
				catch (Exception ex ){
					System.out.println(ex);
				}
				break;


			case 3:
				System.out.println("Enter end date (mm/dd/yy)");
				String ed = scan1.next();
				try{
					endDate = df.parse(ed);
					list.get(location).setEndDate(endDate);
				}
				catch (Exception ex ){
					System.out.println(ex);
				}
				break;

			case 4:
				System.out.println("Enter short description");
				String desc = scanDesc.next();
				list.get(location).setDescription(desc);
				break;

			default:
				break;
		}

		return list;
	}
}
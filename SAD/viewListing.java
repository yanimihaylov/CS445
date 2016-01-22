import java.util.*;
public class viewListing{

	Scanner scan = new Scanner(System.in);
	int id;
	public void view(ArrayList<Listing> list, int pid){
		id=pid;
		System.out.println("\n1. View by Category\n2. View Home Page\n3. View your listings\n-1 to return");
		String selection = scan.nextLine();

		switch (selection){

			case "1":
				viewByCategory(list);
				break;

			case "2":
				viewHomePage(list);
				break;

			case "3":
				viewOwn(list, id);
				break;

			case "-1":
				break;

			default:
				System.out.println("Unrecognized input");
				view(list, id);
				break;
		}
	}

	public void viewHomePage(ArrayList<Listing> l){
		for(int i=0; i<l.size(); i++){
			if(l.get(i).getClass().getSimpleName().equalsIgnoreCase("HomePageFeatured")){
				System.out.println("\n " + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
			}
		}

		for(int i=0; i<l.size(); i++){
			if(!l.get(i).getClass().getSimpleName().equalsIgnoreCase("HomePageFeatured")){
				System.out.println("\n " + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
			}
		}
	}

	public void viewByCategory(ArrayList<Listing> l){
		System.out.println("\n1. Services\n2. Selling\n3. Buying\n-1 to return");
		String cat = scan.nextLine();
		for(int i=0; i<l.size(); i++){

			switch(cat){
				case "1":
					if(l.get(i).getCategory().equals("Services")){
						System.out.println(" \n" + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
					}
					break;

				case "2":
					if(l.get(i).getCategory().equals("Selling")){
						System.out.println(" \n" + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
					}
					break;

				case "3":
					if(l.get(i).getCategory().equals("Buying")){
						System.out.println(" \n" + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
					}
					break;

				case "-1":
					break;

				default:
					System.out.println("Unrecognized input");
					view(l, id);
					break;
			}
		}
	}

	public void viewOwn(ArrayList<Listing> l, int id){
		for(int i=0; i<l.size(); i++){
			if(l.get(i).getOwner()==id){
				System.out.println("\n " + l.get(i).getName()+"\n   "+l.get(i).getDescription()+"\n");
			}
		}
	}
}
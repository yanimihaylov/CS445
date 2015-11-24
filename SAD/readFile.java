import java.util.*;
import java.io.*;
public class readFile{
	public ArrayList<Listing> read(){

		ArrayList<Listing> list = new ArrayList<Listing>();
		
		try{
			File file = new File("data.txt");
			Scanner scan = new Scanner(file);
			

			while(scan.hasNextLine()){
				String line = scan.nextLine();

				StringTokenizer strtok = new StringTokenizer(line, ",");
				while(strtok.hasMoreTokens())
				{
					String type=strtok.nextToken();
					String name=strtok.nextToken();
					String sd=strtok.nextToken();
					String ed=strtok.nextToken();
					String desc=strtok.nextToken();

					if(type.equalsIgnoreCase("regular")){
						Regular listing = new Regular(name,sd,ed,desc);
						list.add(listing);
					}

					if(type.equalsIgnoreCase("HomePageFeatured")){
						HomePageFeatured listing = new HomePageFeatured(name,sd,ed,desc);
						list.add(listing);
					}

					if(type.equalsIgnoreCase("CategoryFeatured")){
						CategoryFeatured listing = new CategoryFeatured(name,sd,ed,desc);
						list.add(listing);
					}
				}
			}
		}

		catch(IOException e){
			System.out.println("Something is wrong with the file.");
		}
		
		return list;
	}
}
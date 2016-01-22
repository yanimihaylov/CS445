import java.util.*;
import java.io.*;
import java.text.*;
public class dataIO{
	public ArrayList<Listing> read(){

		ArrayList<Listing> list = new ArrayList<Listing>();
		
		try{
			File file = new File("data.txt");
			Scanner scan = new Scanner(file);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = new Date(); 
			Date endDate = new Date();
			

			while(scan.hasNextLine()){
				String line = scan.nextLine();

				StringTokenizer strtok = new StringTokenizer(line, "|");
				while(strtok.hasMoreTokens())
				{
					String type=strtok.nextToken();
					String category=strtok.nextToken();
					String name=strtok.nextToken();
					String sd=strtok.nextToken();
					String ed=strtok.nextToken();
					String desc=strtok.nextToken();
					int owner = Integer.parseInt(strtok.nextToken());

					try
					{
						endDate = df.parse(ed);
						startDate = df.parse(sd);
					}

					catch (Exception ex ){
						System.out.println(ex);
					}

					if(type.equalsIgnoreCase("regular")){
						Regular listing = new Regular(category, name,startDate,endDate,desc);
						listing.setOwner(owner);
						list.add(listing);
					}

					if(type.equalsIgnoreCase("HomePageFeatured")){
						HomePageFeatured listing = new HomePageFeatured(category, name,startDate,endDate,desc);
						listing.setOwner(owner);
						list.add(listing);
					}

					if(type.equalsIgnoreCase("CategoryFeatured")){
						CategoryFeatured listing = new CategoryFeatured(category, name,startDate,endDate,desc);
						listing.setOwner(owner);
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

	public void write(ArrayList<Listing> l)
	{
		OutputStreamWriter filestream;
		FileOutputStream file;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = new Date(); 
		Date endDate = new Date();

		try{
				file = new FileOutputStream("data.txt", false);
				filestream = new OutputStreamWriter(new BufferedOutputStream(file));

				for(int i=0; i<l.size(); i++){
					filestream.write(l.get(i).getClass().getSimpleName()+"|");
					filestream.write(l.get(i).getCategory()+"|");
					filestream.write(l.get(i).getName()+"|");
					filestream.write(df.format(l.get(i).getStartDate())+"|");
					filestream.write(df.format(l.get(i).getEndDate())+"|");
					filestream.write(l.get(i).getDescription()+"|");
					filestream.write(l.get(i).getOwner()+"|");
					filestream.write("\n");
				}
			filestream.flush();
			file.close();
		}

		catch(IOException ioe){
			System.out.println("Error writing to file.");
		}
	}
}
import java.util.*;
import java.io.*;
<<<<<<< HEAD
import java.text.*;
=======
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
public class dataIO{
	public ArrayList<Listing> read(){

		ArrayList<Listing> list = new ArrayList<Listing>();
		
		try{
			File file = new File("data.txt");
			Scanner scan = new Scanner(file);
<<<<<<< HEAD
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = new Date(); 
			Date endDate = new Date();
=======
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
			

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
<<<<<<< HEAD
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
=======

					if(type.equalsIgnoreCase("regular")){
						Regular listing = new Regular(category, name,sd,ed,desc);
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
						list.add(listing);
					}

					if(type.equalsIgnoreCase("HomePageFeatured")){
<<<<<<< HEAD
						HomePageFeatured listing = new HomePageFeatured(category, name,startDate,endDate,desc);
						listing.setOwner(owner);
=======
						HomePageFeatured listing = new HomePageFeatured(category, name,sd,ed,desc);
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
						list.add(listing);
					}

					if(type.equalsIgnoreCase("CategoryFeatured")){
<<<<<<< HEAD
						CategoryFeatured listing = new CategoryFeatured(category, name,startDate,endDate,desc);
						listing.setOwner(owner);
=======
						CategoryFeatured listing = new CategoryFeatured(category, name,sd,ed,desc);
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
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
<<<<<<< HEAD
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = new Date(); 
		Date endDate = new Date();
=======
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5

		try{
				file = new FileOutputStream("data.txt", false);
				filestream = new OutputStreamWriter(new BufferedOutputStream(file));

				for(int i=0; i<l.size(); i++){
					filestream.write(l.get(i).getClass().getSimpleName()+"|");
					filestream.write(l.get(i).getCategory()+"|");
					filestream.write(l.get(i).getName()+"|");
<<<<<<< HEAD
					filestream.write(df.format(l.get(i).getStartDate())+"|");
					filestream.write(df.format(l.get(i).getEndDate())+"|");
					filestream.write(l.get(i).getDescription()+"|");
					filestream.write(l.get(i).getOwner()+"|");
=======
					filestream.write(l.get(i).getStartDate()+"|");
					filestream.write(l.get(i).getEndDate()+"|");
					filestream.write(l.get(i).getDescription());
>>>>>>> 16ba5ff8ee3977cfbcd3ae4dd638813c3de44bd5
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
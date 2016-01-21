import java.util.*;
import java.io.*;
public class AccountDataIO{
	public ArrayList<Account> read(){

		ArrayList<Account> list = new ArrayList<Account>();
		
		try{
			File file = new File("AccountData.txt");
			Scanner scan = new Scanner(file);
			

			while(scan.hasNextLine()){
				String line = scan.nextLine();

				StringTokenizer strtok = new StringTokenizer(line, "|");
				while(strtok.hasMoreTokens())
				{
					String username=strtok.nextToken();
					String password=strtok.nextToken();
					Account acc = new Account(username, password);
					list.add(acc);
				}
			}
		}

		catch(IOException e){
			System.out.println("Something is wrong reading the file with accounts.");
		}
		
		return list;
	}

	public void write(ArrayList<Account> l)
	{
		OutputStreamWriter filestream;
		FileOutputStream file;

		try{
				file = new FileOutputStream("AccountData.txt", false);
				filestream = new OutputStreamWriter(new BufferedOutputStream(file));

				for(int i=0; i<l.size(); i++){
					filestream.write(l.get(i).getUsername()+"|");
					filestream.write(l.get(i).getPassword()+"\n");

				}
			filestream.flush();
			file.close();
		}

		catch(IOException ioe){
			System.out.println("Error writing to file.");
		}
	}
}
import java.util.*;
public class Login {
	
	static ArrayList<Listing> listingsArray = new ArrayList<Listing>();
	
	public void login(){
			Scanner scan = new Scanner(System.in);
			
			boolean b = false;
			adminLogin adlog = new adminLogin();

			

			System.out.println("Hello and welcome to the SAD!");
		while(b==false){
			
			System.out.println("Enter username:");
			String usr = scan.next();
			
			System.out.println("Enter password:");
			String psw = scan.next();
			
			if(usr.equals("admin") && psw.equals("pass"))
			{
					System.out.println("\nWelcome, admin.");
					adlog.start();
					b=true;
			}
			
			if(usr.equals("customer") && psw.equals("1234"))
			{
					System.out.println("Welcome, customer.");
					b=true;
			}
			
			else{
				System.out.println("Wrong username or password");
			}
		}
	}
	
	public static ArrayList<Listing> getArrayList(){
		return listingsArray;
	}
}
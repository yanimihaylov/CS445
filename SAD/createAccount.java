import java.util.*;
public class createAccount{
	public Account createAccount(){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter username");
		String usr = scan.nextLine();

		System.out.println("Enter password");
		String pass = scan.nextLine();

		System.out.println("Reenter password");
		String pass1 = scan.nextLine();

		if(!pass.equals(pass1)){
			System.out.println("Passwords do not match");
			createAccount();
		}

		Account acc = new Account(usr, pass);
		return acc;
	}
}
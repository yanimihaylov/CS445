import java.util.ArrayList;
import java.util.Scanner;
public class Login {

	ArrayList<Account> accountData = new ArrayList<Account>();
	Scanner scan = new Scanner(System.in);
	AccountDataIO adIO = new AccountDataIO();
	
	
	checkAccount ca = new checkAccount();
	createAccount cra = new createAccount();

	public void start(){
		System.out.println("\nHello and welcome to the SAD!");
		accountData.addAll(adIO.read());
		login();
	}

	public void login(){
			boolean a = true;
			adminLogin adlog = new adminLogin();
			customerLogin clog = new customerLogin();

		while(a){
			Scanner scan = new Scanner(System.in);


			System.out.println("\n1. Sign in\n2. Sign up\n3. Exit");	
			String selection = scan.next();

			switch(selection){

				case "1":
					System.out.println("/////Sign in/////");
					int out = signIN();
					if (out==0){
						System.out.println("\nWelcome, admin.");
						adlog.start();
					}

					if (out==-1){
						System.out.println("/////Wrong username or password/////");
					}

					else if(out!=0 && out!=-1){
						String name = accountData.get(out).getUsername();
						System.out.println("Welcome, "+name);
						clog.start(out);

					}
					break;

				case "2":
					System.out.println("/////Sign up/////");
					signUP();
					break;

				case "3":
					System.out.println("/////Exiting program/////");
					System.exit(0);
					break;

				default:
					System.out.println("\nUnrecognized input");
					break;
			}
		}
	}

	public int signIN(){
		//Console console = System.console();

		System.out.println("Enter username:");
		String usr = scan.next();
			
		//String psw = new String(console.readPassword("Please enter your password: "));
        System.out.println("Enter pass:");
		String psw = scan.next();
		int res = ca.check(usr, psw, accountData);
			
		if(res==0){
			return res;
		}
		
		if(res==-1){
			return -1;
		}

		else{
			return res;
		}
	}

	public void signUP(){
		Account acc = cra.createAccount();
		int checkAcc = ca.checkExisting(acc, accountData);
		if(checkAcc==0){
			accountData.add(acc);
			adIO.write(accountData);
			System.out.println("Account Created");
		}
		else
			System.out.println("Username already taken.");
		return;
	}
}


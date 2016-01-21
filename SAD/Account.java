public class Account{
	
	String username;
	String password;
	int accountID;
	static int id=0; 

	public Account(){
		username ="noNAME";
		password ="noPASS";
		id++;
		accountID=id;
	}

	public Account(String u, String p){
		username=u;
		password=p;
		id++;
		accountID=id;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public int getAccountID(){
		return accountID;
	}

	public void setUsername(String un){
		username=un;
	}

	public void setPassword(String pass){
		password=pass;
	}

	public void setAccountID(int aID){
		accountID=aID;
	}
}
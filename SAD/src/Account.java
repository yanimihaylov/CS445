public class Account {

    static int id = 0;
    String username;
    String password;
    int accountID;

    public Account() {
        username = "noNAME";
        password = "noPASS";
        id++;
        accountID = id;
    }

    public Account(String u, String p) {
        username = u;
        password = p;
        id++;
        accountID = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String un) {
        username = un;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int aID) {
        accountID = aID;
    }
}
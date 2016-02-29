package UnitTest;

import org.junit.Test;
import org.testng.AssertJUnit;

import java.util.ArrayList;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class LoginTest {

    @org.junit.Test
    public void testStart() throws Exception {
        AccountDataIO adIO = new AccountDataIO();
        ArrayList<Account> accountData = new ArrayList<Account>();
        accountData.addAll(adIO.read());

        AssertJUnit.assertEquals(accountData.get(0).getUsername(), "admin");
        AssertJUnit.assertEquals(accountData.get(0).getPassword(), "pass");

        AssertJUnit.assertEquals(accountData.get(1).getUsername(), "ymihaylo");
        AssertJUnit.assertEquals(accountData.get(1).getPassword(), "1234");
    }

    @Test
    public void testLogin() throws Exception {

    }

    @Test
    public void testSignIN() throws Exception {
        AccountDataIO adIO = new AccountDataIO();
        ArrayList<Account> accountData = new ArrayList<Account>();
        accountData.addAll(adIO.read());
        checkAccount ca = new checkAccount();
        Account a1 = new Account("test", "pass");

        AssertJUnit.assertEquals(ca.check("admin", "pass", accountData), 0);
        AssertJUnit.assertEquals(ca.check("ymihaylo", "1234", accountData), 1);
        AssertJUnit.assertEquals(ca.check("noname", "nopass", accountData), -1);
        AssertJUnit.assertEquals(ca.checkExisting(accountData.get(0), accountData), 1);
        AssertJUnit.assertEquals(ca.checkExisting(accountData.get(1), accountData), 1);
        AssertJUnit.assertEquals(ca.checkExisting(a1, accountData), 0);
    }

    @Test
    public void testSignUP() throws Exception {

    }
}
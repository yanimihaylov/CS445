package UnitTest;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class AccountTest {

    @Test
    public void Account() throws Exception{
        Account a1 = new Account();
        Assert.assertEquals(a1.getUsername(), "noNAME");
        Assert.assertEquals(a1.getPassword(), "noPASS");
    }

    @org.junit.Test
    public void testGetUsername() throws Exception {
        Account a1 = new Account("usr", "pass");
        Assert.assertEquals(a1.getUsername(), "usr");
    }

    @Test
    public void testSetUsername() throws Exception {
        Account a1 = new Account("usr", "pass");
        a1.setUsername("newUSR");
        Assert.assertEquals(a1.getUsername(), "newUSR");
    }

    @Test
    public void testGetPassword() throws Exception {
        Account a1 = new Account("usr", "pass");
        Assert.assertEquals(a1.getPassword(), "pass");
    }

    @Test
    public void testSetPassword() throws Exception {
        Account a1 = new Account("usr", "pass");
        a1.setPassword("newPASS");
        Assert.assertEquals(a1.getPassword(), "newPASS");
    }

    @Test
    public void testGetAccountID() throws Exception {
        Account a4 = new Account("usr", "pass");
        Assert.assertEquals(a4.getAccountID(), 3);
    }

    @Test
    public void testSetAccountID() throws Exception {
        Account a1 = new Account();
        a1.setAccountID(4);
        Assert.assertEquals(a1.getAccountID(), 4);
    }
}
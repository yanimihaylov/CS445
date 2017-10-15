package UnitTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
/**
 * Created by ymihaylo on 2/29/16.
 */
public class AccountDataIOTest {

    @Test
    public void testRead() throws Exception{
        AccountDataIO adIO = new AccountDataIO();
        ArrayList<Account> l = adIO.read();

        Account a1 = new Account("admin", "pass");
        Account a2 = new Account("ymihaylo", "1234");

        ArrayList<Account> l1 = new ArrayList<Account>();
        l1.add(a1);
        l1.add(a2);


        Assert.assertEquals(l.get(1).getUsername(), l1.get(1).getUsername());
        Assert.assertEquals(l.get(1).getPassword(), l1.get(1).getPassword());

        Assert.assertEquals(l.get(0).getUsername(), l1.get(0).getUsername());
        Assert.assertEquals(l.get(0).getPassword(), l1.get(0).getPassword());

    }
}

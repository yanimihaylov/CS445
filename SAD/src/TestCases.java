import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class TestCases {


    @Test
    public void testReadAcc() throws Exception{
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

    @Test
    public void Account() throws Exception{
        Account a1 = new Account();
        Assert.assertEquals(a1.getUsername(), "noNAME");
        Assert.assertEquals(a1.getPassword(), "noPASS");
    }

    @Test
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
        Assert.assertEquals(a4.getAccountID(), 10);
    }

    @Test
    public void testSetAccountID() throws Exception {
        Account a1 = new Account();
        a1.setAccountID(4);
        Assert.assertEquals(a1.getAccountID(), 4);
    }

    @Test
    public void testRead() throws Exception {
        dataIO dIO = new dataIO();
        ArrayList<Listing> l = dIO.read();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "01/22/2016";
        String ed = "01/22/2020";
        String tsd = "03/03/2014";
        String ted = "3/03/2015";

        Date start = df.parse(sd);
        Date end = df.parse(ed);

        Date tstart = df.parse(tsd);
        Date tend = df.parse(ted);

        HomePageFeatured l1 = new HomePageFeatured("Services", "Emergency", start, end, "Call 9-1-1");
        Regular l2 = new Regular("Selling", "MacBook", tstart, tend, "$700 obo");

        Assert.assertEquals(l.get(0).getDescription(), l1.getDescription());
        Assert.assertEquals(l.get(0).getName(), l1.getName());

        Assert.assertEquals(l.get(1).getDescription(), l2.getDescription());
        Assert.assertEquals(l.get(1).getName(), l2.getName());
    }

    @Test
    public void testWrite() throws Exception {

    }

    @Test
    public void testGetCategory() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        AssertJUnit.assertEquals(li.getCategory(), "cat");
    }

    @Test
    public void testGetName() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        AssertJUnit.assertEquals(li.getName(), "name");
    }

    @Test
    public void testGetStartDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        AssertJUnit.assertEquals(li.getStartDate(), start);
    }

    @Test
    public void testGetEndDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        AssertJUnit.assertEquals(li.getEndDate(), end);
    }

    @Test
    public void testGetDescription() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        AssertJUnit.assertEquals(li.getDescription(), "desc");
    }

    @Test
    public void testGetOwner() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        li.setOwner(1);
        AssertJUnit.assertEquals(li.getOwner(), 1);
    }

    @Test
    public void testSetName() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        li.setName("NA");
        AssertJUnit.assertEquals(li.getName(), "NA");
    }

    @Test
    public void testSetCategory() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        li.setCategory("CA");
        AssertJUnit.assertEquals(li.getCategory(), "CA");
    }

    @Test
    public void testSetStartDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        String newSD = "04/21/2016";
        Date newSDD = df.parse(newSD);
        li.setStartDate(newSDD);
        AssertJUnit.assertEquals(li.getStartDate(), newSDD);
    }

    @Test
    public void testSetEndDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        String newED = "04/21/2016";
        Date newEDD = df.parse(newED);
        li.setEndDate(newEDD);
        AssertJUnit.assertEquals(li.getEndDate(), newEDD);
    }

    @Test
    public void testSetDescription() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        li.setDescription("DE");
        AssertJUnit.assertEquals(li.getDescription(), "DE");
    }

    @Test
    public void testSetOwner() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Listing li = new Listing("cat", "name", start, end, "desc");
        li.setOwner(2);
        AssertJUnit.assertEquals(li.getOwner(), 2);
    }

    @Test
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

    @Test
    public void testToStringHPF() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        HomePageFeatured li = new HomePageFeatured("cat", "name", start, end, "desc");

        assertEquals(li.toString(), "Listing type: HomePageFeatured \nCategory " + "cat" + "\n " + "name" + "\n Start date (mm/dd/yy): " + start +
                "\n End date (mm/dd/yy): " + end +
                "\n Listing description: " + "desc");
    }

    @Test
    public void testToStringCF() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        CategoryFeatured li = new CategoryFeatured("cat", "name", start, end, "desc");

        assertEquals(li.toString(), "Listing type: CategoryFeatured \nCategory " + "cat" + "\n " + "name" + "\n Start date (mm/dd/yy): " + start +
                "\n End date (mm/dd/yy): " + end +
                "\n Listing description: " + "desc");
    }

    @Test
    public void testToStringRegular() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String sd = "03/21/2016";
        String ed = "03/21/2017";
        Date start = df.parse(sd);
        Date end = df.parse(ed);
        Regular li = new Regular("cat", "name", start, end, "desc");

        assertEquals(li.toString(), "Listing type: Regular \nCategory " + "cat" + "\n " + "name" + "\n Start date (mm/dd/yy): " + start +
                "\n End date (mm/dd/yy): " + end +
                "\n Listing description: " + "desc");
    }



    @Test
    public void testStartDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        Date startDate = new Date();
        Date endDate = new Date();

        String sd = "01/01/2001";
        startDate = df.parse(sd);

        String ed = "01/01/2000";
        endDate = df.parse(ed);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        if(today.after(startDate)){
            System.out.println("The date cannot be before the current date.\nStarting over.");
            assertEquals("The date cannot be before the current date.\nStarting over.\n", outContent.toString());
        }

    }

    @Test
    public void testEndDate() throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        Date startDate = new Date();
        Date endDate = new Date();

        String sd = "01/01/2001";
        startDate = df.parse(sd);

        String ed = "01/01/2000";
        endDate = df.parse(ed);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        if(startDate.after(endDate)){
            System.out.print("The start date cannot be after the end date.\nStarting over.");
            assertEquals("The start date cannot be after the end date.\nStarting over.", outContent.toString());
        }
    }
    
}

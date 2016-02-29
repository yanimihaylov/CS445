package UnitTest;

import org.junit.Test;
import org.testng.AssertJUnit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListingTest {

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
    public void testToString() throws Exception {
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
}
package UnitTest;
import dataIO;
import org.junit.Assert;
import org.junit.Test;
import
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class dataIOTest {

    @org.junit.Test
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
}
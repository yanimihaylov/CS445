import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class HomePageFeaturedTest {

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
}
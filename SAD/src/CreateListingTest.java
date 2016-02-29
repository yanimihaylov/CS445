import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class CreateListingTest {

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
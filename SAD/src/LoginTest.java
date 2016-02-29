import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by ymihaylo on 2/29/16.
 */
public class LoginTest {

    @org.junit.Test
    public void testSignIN() throws Exception {
        Login lo = new Login();

        assertEquals(lo.signIN(), 0);
    }

    @Test
    public void testSignUP() throws Exception {

    }
}
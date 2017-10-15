import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCreatureTest {
    @Test
    public void test_getName() throws Exception{

        Thing t1 = new Thing();
        assertEquals(t1.getName(), "noNAME");
    }


    @Test
    public void test_toString() throws Exception{

        Thing t1 = new Thing("testNAME");
        assertEquals(t1.toString(), "testNAME of class Thing");
    }

    @Test
    public void test_getCreatureName() throws Exception{
        Tiger t1 = new Tiger("testName");
        assertEquals(t1.getName(), "testName");
    }
}
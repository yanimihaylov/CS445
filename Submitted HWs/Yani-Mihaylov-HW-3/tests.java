import Button.Button;
import Lightbulb.Lightbulb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class tests {

    @Test
    public void test_switchOn() throws Exception{

        Button b1 = new Button();
        assertEquals(b1.switchOn(), "Button switched ON.");
    }

    @Test
    public void test_switchOff() throws Exception{

        Button b1 = new Button();
        assertEquals(b1.switchOff(), "Button switched OFF.");
    }

    @Test
    public void test_pushButton() throws Exception{

        Button b1 = new Button();
        assertEquals(b1.pushButton(), "Button pushed.");
    }

    @Test
    public void test_lightBulb_off() throws Exception{

        Lightbulb l1 = new Lightbulb();
        assertEquals(l1.off(), "Lighbulb OFF.");
    }

    @Test
    public void test_lightBulb_on() throws Exception{

        Lightbulb l1 = new Lightbulb();
        assertEquals(l1.on(), "Lighbulb ON.");
    }

    @Test
    public void test_lamp_on() throws Exception{

        TableLamp tl = new TableLamp();
        tl.turnOn();
        assertEquals(tl.button.toString(), "Button switched ON.");
        assertEquals(tl.light.toString(), "Lighbulb ON.");
    }

    @Test
    public void test_lamp_on_Push() throws Exception{

        TableLamp tl = new TableLamp();
        tl.turnOnPush();
        assertEquals(tl.button.toString(), "Button pushed.");
        assertEquals(tl.light.toString(), "Lighbulb ON.");
    }



    @Test
    public void test_lamp_off() throws Exception{

        TableLamp tl = new TableLamp();
        tl.turnOff();
        assertEquals(tl.button.toString(), "Button switched OFF.");
        assertEquals(tl.light.toString(), "Lighbulb OFF.");
    }

    @Test
    public void test_lamp_off_Push() throws Exception{

        TableLamp tl = new TableLamp();
        tl.turnOffPush();
        assertEquals(tl.button.toString(), "Button pushed.");
        assertEquals(tl.light.toString(), "Lighbulb OFF.");
    }

}
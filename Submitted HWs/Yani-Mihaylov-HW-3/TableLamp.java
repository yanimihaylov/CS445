import Button.Button;
import Lightbulb.Lightbulb;
public class TableLamp {

    Button b = new Button();
    Lightbulb l  = new Lightbulb();
    String button;
    String light;

    public TableLamp(){

    }

    //Part ii
    public void turnOn(){
        button = b.switchOn();
        light = l.on();

        System.out.println(button);
        System.out.println(light);
    }

    public void turnOff(){
        button = b.switchOff();
        light = l.off();

        System.out.println(button);
        System.out.println(light);
    }


    //Part iii
    public void turnOnPush(){
        button = b.pushButton();
        light = l.on();

        System.out.println(button);
        System.out.println(light);
    }

    public void turnOffPush(){
        button = b.pushButton();
        light = l.off();

        System.out.println(button);
        System.out.println(light);
    }


}

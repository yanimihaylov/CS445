import Button.Button;

public class Main{

	public static void main(String[]args){

		//Part i
		System.out.println("----Part i----");
		Button b1 = new Button();
		System.out.println(b1.switchOn());


		//Part ii
		System.out.println("----Part ii----");
		TableLamp tl = new TableLamp();
		tl.turnOn();
		tl.turnOff();


		//Part iii
		System.out.println("----Part iii----");
		TableLamp tl1 = new TableLamp();
		tl1.turnOnPush();
		tl1.turnOffPush();
	}
	
}
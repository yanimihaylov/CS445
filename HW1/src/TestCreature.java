public class TestCreature {
	public static final int CREATURE_COUNT=6;
	public static final int THING_COUNT=7;
	public static void main(String[]args){
		Thing [] thingArray = new Thing[THING_COUNT];
		Creature[] creatureArray = new Creature[CREATURE_COUNT];
		Tiger t1 = new Tiger("Shere Khan");
		Ant a1 = new Ant("Herbert");
		Bat b1 = new Bat("Vlad");
		Fly f1 = new Fly("Darwin");
		Thing banana = new Thing("Banana");
		Thing car = new Thing("Car");
		Thing shoe = new Thing("Shoe");
		thingArray[0]= t1;
		thingArray[1]=shoe;
		thingArray[2]=a1;
		thingArray[3]=banana;
		thingArray[4]=b1;
		thingArray[5]=car;
		thingArray[6]=f1;
		System.out.println("Things:");
		for(int i=0; i<thingArray.length; i++){
			if(thingArray[i].getClass().getSimpleName().equals("Thing"))
				System.out.println(thingArray[i].toString());
		}
		System.out.println("\n");
		System.out.println("Creatures:");
		for(int i=0; i<thingArray.length; i++){
			if(!thingArray[i].getClass().getSimpleName().equals("Thing"))
				System.out.println(thingArray[i].toString());
		}
		System.out.println("\n");
		f1.move();
		f1.eat(shoe);
		f1.whatDidYouEat();
		f1.eat(banana);
		f1.whatDidYouEat();
		t1.move();
	}
}
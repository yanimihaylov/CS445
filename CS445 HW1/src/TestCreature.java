
public class TestCreature {
	
		public static final int CREATURE_COUNT=6;
		public static final int THING_COUNT=10;
		
		public static void main(String[]args){
	
			Thing [] thingArray = new Thing[THING_COUNT];
			Creature[] creatureArray = new Creature[CREATURE_COUNT];
			
			Tiger t1 = new Tiger("Shere Khan");
			Ant a1 = new Ant("Herbert");
			Bat b1 = new Bat("Vlad");
			Fly f1 = new Fly("Darwin");
			
			Thing banana = new Thing("Banana");
			Thing car = new Thing("Car");
			
			thingArray[0]= t1;
			thingArray[1]=a1;
			thingArray[2]=b1;
			thingArray[3]=f1;
			thingArray[4]=banana;
			thingArray[5]=car;
			
			System.out.println("Things:");
			
			
			
		}
}

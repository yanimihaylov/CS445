
public class TestCreature {
	
		public static final int CREATURE_COUNT=6;
		public static final int THING_COUNT=10;
		
		public TestCreature(){
			
		}
		
		public static void main(String[]args){
	
			Tiger t1 = new Tiger("Shere Khan");
			
			Ant a2 = new Ant("Herbert");
			
			Bat b1 = new Bat("Vlad");
			
			Fly f1 = new Fly("Darwin");
			
			Thing banana = new Thing("Banana");
			Thing car = new Thing("Car");
			
			b1.eat(banana);
			
		}
}

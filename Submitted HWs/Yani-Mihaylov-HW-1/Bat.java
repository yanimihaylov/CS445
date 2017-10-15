
public class Bat extends Creature implements Flyer {

	public Bat(String n) {
		super(n);
	}

	@Override
	public void fly() {
		System.out.println(this.toString()+" is swooping through the dark.");
		
	}

	@Override
	public void move() {
		fly();
	}
	
	@Override
	public void eat(Thing aThing){
		if(aThing.getClass().getSimpleName().equals("Thing"))
			System.out.println(this.toString()+" won't eat a "+aThing.toString());
		
		else
			super.eat(aThing);
	}
	
}

public class Tiger extends Creature {
	public Tiger(String n){
		super(n);
	}
	@Override
	public void move() {
		System.out.println(this.toString()+" has just pounced");
	}
}

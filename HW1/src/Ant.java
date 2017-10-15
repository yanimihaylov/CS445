public class Ant extends Creature {
	public Ant(String n){
		super(n);
	}
	@Override
	public void move() {
		System.out.println(this.toString()+" is crawling around");
	}
}

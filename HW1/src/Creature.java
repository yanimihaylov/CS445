public abstract class Creature extends Thing{
	Thing eaten;
	public Creature(String n){
		super(n);
	}
	public Thing getEaten(){
		return eaten;
	}
	public void setEaten(Thing eatenThing){
		eaten=eatenThing;
	}
	public void eat(Thing aThing){
		eaten=aThing;
		System.out.println(this.toString()+" has just eaten "+aThing.toString());
	}
	public abstract void move();
	public void whatDidYouEat(){
		if(this.getEaten()!=null)
		System.out.println(this.toString()+" has eaten "+eaten.toString());
		else
			System.out.println(this.toString()+" has not eaten anything");
	}
}
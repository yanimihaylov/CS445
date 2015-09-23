
public class Thing{

	String name;
	
	public Thing(){
		name=" ";
	}
	
	public Thing(String n){
		name=n;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		String str = (name+" of "+getClass());
		return str;
	}
}
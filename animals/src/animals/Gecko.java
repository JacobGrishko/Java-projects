package animals;

public class Gecko extends reptile {
	public Gecko(String name, String color, int age, Owner owner)
	{
		this._name = name;
		this._color = color;
		this._age = age;
		this._owner = owner;
		this._type = "reptile";
		this._kind = "Gecko";
		this.specialAbility= true;
	}
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received flies.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the small cave in the terrarium.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " climb walls and crawl in the sand.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		Owner owner = this._owner;
 		
		Animal clone = new Gecko(name, color, age, owner);
		return clone;
	}
}

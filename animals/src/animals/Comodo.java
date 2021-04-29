package animals;

public class Comodo extends reptile{
	
	public Comodo(String name, String color, int age)
	{
		this._name = name;
		this._color = color;
		this._age = age;

		this._type = "reptile";
		this._kind = "Comodo";
		this.specialAbility= true;
	}
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received meat and fruits.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the cave.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " crawl like a badass.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		
		Animal clone = new Comodo(name, color, age);
		return clone;
	}
}

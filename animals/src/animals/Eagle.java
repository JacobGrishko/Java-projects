package animals;

public class Eagle extends bird {
	
	public Eagle(String name, String color, int age)
	{
		this._name = name;
		this._color = color;
		this._age = age;

		this._type = "Bird";
		this._kind = "Eagle";
		this.specialAbility= true;
	}
	
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received meat.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" was put in the high nest cage to sleep.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " fly and hunt.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		
		Animal clone = new Eagle(name, color, age);
		return clone;
	}
}




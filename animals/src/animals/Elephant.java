package animals;

public class Elephant extends Animal {
	public Elephant(String name, String color, int age)
	{
		this._name = name;
		this._color = color;
		this._age = age;
		this._type = "mammal";
		this._kind = "Elephant";

	}
	
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received Elephant food.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the yard.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		
		Animal clone = new Elephant(name, color, age);
		return clone;
	}
}

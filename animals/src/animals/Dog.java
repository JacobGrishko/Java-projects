package animals;

public class Dog extends Animal{
	public Dog(String name, String color, int age, Owner owner)
	{
		this._name = name;
		this._color = color;
		this._age = age;
		this._owner = owner;
		this._type = "mammal";
		this._kind = "Dog";

	}
	
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received dog food.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the dog house.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		Owner owner = this._owner;
 		
		Animal clone = new Dog(name, color, age, owner);
		return clone;
	}
}

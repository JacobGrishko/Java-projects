package animals;

public abstract class Mammal extends Animal {

	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received Mammal food.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the garden.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("No Special ability.");
	}
}

package animals;

public abstract class reptile extends Animal {

	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received raptile food.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+" went to sleep in the terrarium.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " do reptile stuf.");
	}


}

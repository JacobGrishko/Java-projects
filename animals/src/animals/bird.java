package animals;

public abstract class bird extends Animal{


	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received bird food.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+"went to sleep in the bird cage");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " do bird stuf.");
	}

}

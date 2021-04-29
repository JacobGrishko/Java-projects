package animals;

public class Parrot extends bird {

	public Parrot(String name, String color, int age, Owner owner)
	{
		this._name = name;
		this._color = color;
		this._age = age;
		this._owner = owner;
		this._type = "Bird";
		this._kind = "Parrot";
		this.specialAbility= true;
	}
	
	//food function
	@Override
	public void feed()
	{
		System.out.println(this._name+" received seeds.");
	}
	
	//sleep function
	@Override
	public void sleep()
	{
		System.out.println(this._name+"'s cage was coverd and it went to sleep.");
	}
	
	//special ability method
	@Override
	public void special()
	{
		System.out.println("Let "+this._name+ " sing and fly.");
	}
	
	@Override
	public  Animal clone()
	{
		String name = this._name;
 		String color = this._color;
 		int age = this._age;
 		String ownerName = this._owner.get_name();
 		String ownerNum = this._owner.get_phoneNo();
 		Owner cloneOwner = new Owner(ownerName, ownerNum);
 		
		Animal clone = new Parrot(name, color, age, cloneOwner);
		return clone;
	}
}

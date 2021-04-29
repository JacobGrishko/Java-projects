package animals;

public abstract class Animal {

	String _name;
	String _color;
	int _age;
	
	boolean specialAbility=false;
	String _type;
	String _kind;
	String _food;
	String _sleep;
	String _specialAbility;
	Owner _owner;

	
	//Feed function
	public void feed()
	{
		System.out.println(this._name+" received animal food.");
	}
	
	//sleep function
	public void sleep()
	{
		System.out.println(this._name+"went to sleep.");
	}

	//special ability method
	public void special()
	{
		if(this.specialAbility==true)
			System.out.println("Let "+this._name+ " do its thing");
	}
	
	//get name
	public String get_name(Animal animal) {
		return animal._name;
	}

	//set name
	public void set_name(String _name) {
		this._name = _name;
	}

	//get color
	public String get_color(Animal animal) {
		return animal._color;
	}

	//set color
	public void set_color(String _color) {
		this._color = _color;
	}

	//get age
	public int get_age(Animal animal) {
		return animal._age;
	}

	//set age
	public void set_age(int _age) {
		this._age = _age;
	}

	//print everything about an animal
	public String toString()
	{
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("This is a "+this._kind+" from the "+this._type+ " family, by the name "+this._name+". Its color is "+this._color+ " and it's age is "
							+this._age+".");
		if (this._specialAbility!=null)
			System.out.println(" and it's special ability is "+this._specialAbility);
		if (this._owner!=null)
			System.out.println("Owner:"+this._owner._name+" Phone numer: "+this._owner._phoneNo);
		return null;
	}
	
	//Are two animals equal
 	public boolean equals(Animal animal)
	{
		if(this._name==animal._name && this._color==animal._color && this._age==animal._age &&
				this._type==animal._type)
			return true;
		else
			return false;
	}
 	
 	public abstract Animal clone();
 	
}

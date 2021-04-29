
public class Person implements Comparable<Person>{

	private String _name;
	private int _id;
	private int _birthYear;
	
	//constructor
	public Person(String name, int id, int year) {
		// TODO Auto-generated constructor stub
		_name = name;
		_id = id;
		_birthYear = year;
	}

	//return name
	public String getPersonName() {
		return _name;
	}
	
	//compare to the person by birth year (age)
	@Override
	public boolean equals(Object Obj) {
		final Person other = (Person) Obj;
		if (this._birthYear> other._birthYear) {
			return true;
		}		
		else {
			return false;
		}	
	}

	
	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

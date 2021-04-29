package animals;

public class Owner {
	
	String _name;
	String _phoneNo;

	public Owner(String name, String phone)
	{
		this._name = name;
		this._phoneNo = phone;
	}
	
	public void set_name(String _name) {
		this._name = _name;
	}

	public void set_phoneNo(String _phoneNo) {
		this._phoneNo = _phoneNo;
	}
	
	public String get_name() {
		return _name;
	}

	public String get_phoneNo() {
		return _phoneNo;
	}


}

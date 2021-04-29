package philosophers;

public class PhilMain {
	
	//main method
	public static void main(String[] args) {
		PhilModel model = new PhilModel();
		PhilView view = new PhilView(model);
	}

}

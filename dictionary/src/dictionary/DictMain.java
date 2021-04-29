package dictionary;

public class DictMain {
	
	public static void main(String[] args) {

		DictModel model = new DictModel();
		DictView view = new DictView(model);
		DictController controller = new DictController(model, view);
	}

	
}

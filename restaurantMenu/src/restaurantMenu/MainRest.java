package restaurantMenu;

public class MainRest {

	public static void main(String[] args) {
		RestModel model = new RestModel();
		RestView view 	= new RestView(model);
		RestController controller = new RestController(model,view);
	}

}

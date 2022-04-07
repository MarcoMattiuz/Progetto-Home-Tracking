import model.Home;
import view.Window;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window frame = new Window();
		Home model = new Home("marco davide");
		Controller controller = new Controller(model, frame.getMain_Pane);
	}

}

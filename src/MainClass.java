import java.util.Scanner;
import java.util.concurrent.Semaphore;

import control.Controller;
import control.Ligths;
import model.Consume;
import model.Contract;
import model.Home;
import model.Room;
import view.Window;
import view.Window;

public class MainClass {

	public static void main(String[] args) {
		Home home = new Home("marco davide", new Contract("contratto", 3, 0.17, 0.58, 1.30));
		Controller controller = new Controller(home);
		Window frame = new Window(controller);
		controller.setWindow(frame);
		
		

	}

}
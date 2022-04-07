import java.util.Scanner;
import java.util.concurrent.Semaphore;

import control.Controller;
import model.Contract;
import model.Home;
import view.Window;
import view.Window;

public class MainClass {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(5);
		Home model = new Home("marco davide", new Contract("contratto", 3, 0.17, 0.58, 1.30));
		Controller controller = new Controller(model,sem);
		Window frame = new Window(controller);
		
		

	}

}
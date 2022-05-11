import java.util.Scanner;
import java.util.concurrent.Semaphore;

import control.Controller;
import control.ElettricOnOff;
import model.Consume;
import model.Contract;
import model.House;
import model.Room;
import view.Window;
import view.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class MainClass. 
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class MainClass {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		House home = new House("marco davide", new Contract("contratto", 3));
		Controller controller = new Controller(home);
		Window frame= new Window(controller);
		controller.setWindow(frame);
//		controller.generateHouse(1);
	}}
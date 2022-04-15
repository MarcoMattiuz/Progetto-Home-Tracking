package control;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import model.Consume;
import model.Contract;
import model.Home;
import model.Room;
import view.Main_Panel;

public class Controller extends Thread {

	public Home home;
	public Controller(Home home) {
		this.home = home;
		home.addRoom("1", new Room("soggiorno"));
		home.getRoom("1").addDevice(new ElettricOnOff("luce",1, new Consume(0.1, 0, 0, home.getContract()), home));
		home.getRoom("1").addDevice(new ElettricConstant("frigo",2, new Consume(0.4, 0, 0, home.getContract()), home));
	}
}

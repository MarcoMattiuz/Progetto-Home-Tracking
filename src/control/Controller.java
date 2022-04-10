package control;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import model.Consume;
import model.Contract;
import model.Home;
import model.Room;
import view.Main_Panel;

public class Controller extends Thread {

	private Home home;
	private Semaphore ligthSem; ////////////////
	private Semaphore fridgeSem;

	public Controller(Home home) {
		this.home = home;
		this.ligthSem = new Semaphore(1);
		this.fridgeSem = new Semaphore(1);
		home.addRoom("1", new Room("soggiorno"));
		home.getRoom("1").addDevice(new Ligths("luce", 1, new Consume(0.1, 0, 0, home.getContract()), home, ligthSem));
		home.getRoom("1")
				.addDevice(new Fridges("frigo", 2, new Consume(0.4, 0, 0, home.getContract()), home, fridgeSem));
	}
}

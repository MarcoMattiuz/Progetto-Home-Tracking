package control;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class Controller extends Thread{

	private Home md;
	public OnOffDevice ligth;
	public ConstantDevice fridge;
	public TimerDevice oven;
	private Semaphore sem;
	public OnOffDevice lampada;
	private TimerDevice microonde;
	public Controller(Home md, Semaphore sem) {
		this.md = md;
		this.sem = sem;
		ligth = new OnOffDevice("Piantana", 0, new Consume(0.06,0,0,md.getContract()), md, sem);
		lampada = new OnOffDevice("lampada", 0, new Consume(0.06,0,0,md.getContract()), md, sem);
		fridge = new ConstantDevice("frigo", 0, new Consume(0.3, 0, 0, md.getContract()), md, sem);
		oven = new TimerDevice("forno", 0, new Consume(1.5, 0, 0, md.getContract()), md, sem);
		microonde = new TimerDevice("microonde", 0, new Consume(1.5, 0, 0, md.getContract()), md, sem);
		oven.setTimer(40);
	}

}


package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class Fridges extends Device {

	private Semaphore fridgeSem;
	private boolean toggle;

	

	public Fridges(String deviceName, int code, Consume consume, Home md, Semaphore sem) {
		super(deviceName, code, consume, md);
		this.fridgeSem = sem;
		this.toggle = true;
		this.start();
	}

	public void toggle() {
		toggle = !toggle;
		if (toggle) {
			setTimer(0);
			getMd().addToPresentConsumptionKwh(this.getConsume().getKwh());
		} else {
			getMd().takeFromPresentConsumptionKwh(this.getConsume().getKwh());
		}
	}
	
	public boolean isToggle() {
		return toggle;
	}

	@Override
	public void run() {
		while (true) {
			try {
				fridgeSem.acquire();
				if(getTimer() % 5 == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());	
					System.out.println("--"+getDeviceName()+"--");
				}
				System.out.println("Timer: "+getTimer());
				System.out.println(getDeviceName()+":: "+getMd().getDailyConsumptionKwh());
				incrTimer();
				keepTime();
				fridgeSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

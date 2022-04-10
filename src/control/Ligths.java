package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class Ligths extends Device {

	private Semaphore ligthSem;
	private boolean toggle;
	private boolean firstOn;

	public Ligths(String deviceName, int code, Consume consume, Home md, Semaphore sem) {
		super(deviceName, code, consume, md);
		this.ligthSem = sem;
		this.toggle = false;
		this.firstOn = true;
	}

	public void toggle() {
		toggle = !toggle;
		if(firstOn) {
			this.start();
			firstOn = false;
		}
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
				ligthSem.acquire();
				if(getTimer() % 5 == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					System.out.println("--"+getDeviceName()+"--");
				}
				System.out.println("Timer: "+getTimer());
				System.out.println(getDeviceName()+":: "+getMd().getDailyConsumptionKwh());
				incrTimer();
				keepTime();
				ligthSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}

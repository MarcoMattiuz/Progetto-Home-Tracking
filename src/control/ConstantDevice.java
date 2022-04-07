package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class ConstantDevice extends Device {

	private boolean toggle; //true --> on //false --> off
	private Semaphore sem;
	/**
	 * 
	 * @param name
	 * @param code
	 * @param consume
	 */
	public ConstantDevice(String name, int code, Consume consume, Home md, Semaphore sem) {
		super(name, code, consume, md);
		this.sem = sem;
		this.toggle = true;
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
	
	@Override
	public void run() {
		while(toggle) {
			try {
				sem.acquire();
				System.out.println("--"+this.getDeviceName()+"--");
				incrTimer();
				System.out.println(this.getDeviceName()+": "+getTimer());
				if(getTimer() == 0 || getTimer() % 20 == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					getMd().addToDailyConsumption_Gmc(this.getConsume().getGmc());
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
					System.out.println("FRIGO Daily Kwh Consumption: " + getMd().getDailyConsumptionKwh());
				}
				keepTime();
				sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

}

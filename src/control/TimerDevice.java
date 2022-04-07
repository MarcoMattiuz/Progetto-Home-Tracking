package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class TimerDevice extends Device {

	private Semaphore sem;
	/**
	 * 
	 * @param name
	 * @param code
	 * @param consume
	 */
	public TimerDevice(String name, int code, Consume consume, Home md, Semaphore sem) {
		super(name, code, consume, md);
		this.sem = sem;
	}

	private void decrTimer() {
		this.setTimer(this.getTimer() - 1);
	}

	@Override
	public void run() {
		while (this.getTimer() > 0) {
			try {
				sem.acquire();
				System.out.println("--"+this.getDeviceName()+"--");
				decrTimer();
				System.out.println(this.getDeviceName()+": "+getTimer());
				if(getTimer() == 0 || getTimer() % 20 == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					getMd().addToDailyConsumption_Gmc(this.getConsume().getGmc());
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
					System.out.println("forno Daily Kwh Consumption: " + getMd().getDailyConsumptionKwh());
				}
				keepTime();
				sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

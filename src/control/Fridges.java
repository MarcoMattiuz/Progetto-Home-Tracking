package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class Fridges extends Device {

	public Fridges(String deviceName, int code, Consume consume, Home md) {
		super(deviceName, code, consume, md, true);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("CURRENTCONSUMPITON::"+getMd().getPresentConsumptionKwh());
			if (getTimer() % 5 == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh(), this);
				System.out.println("--" + getDeviceName() + "--");
			}
			System.out.println("Timer: " + getTimer());
//			System.out.println(getDeviceName() + ":: " + getMd().getDailyConsumptionKwh());
			incrTimer();
			keepTime();

		}
	}
}

package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class ElettricOnOff extends Device {
	private boolean firstOn;

	public ElettricOnOff(String deviceName, int code, Consume consume, Home md) {
		super(deviceName, code, consume, md, false);
		this.firstOn = true;
	}

	@Override
	public void toggle() {
		toggle = !toggle;
		if (firstOn) {
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

	@Override
	public void run() {
		while (true) {

			if (toggle) {
				System.out.println("CURRENTCONSUMPITON::" + getMd().getPresentConsumptionKwh());
				if (getTimer() % 5 == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					System.out.println("--" + getDeviceName() + "--");
				}
				System.out.println("Timer: " + getTimer());
//				System.out.println(getDeviceName()+":: "+getMd().getDailyConsumptionKwh());
				incrTimer();
				keepTime();
			} else {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

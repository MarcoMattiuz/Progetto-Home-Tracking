package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;

public class ElettricConstant extends Device {

	public ElettricConstant(String deviceName, int code, Consume consume, Home md) {
		super(deviceName, code, consume, md, true);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}

	//non si puo spegnere
	@Override
	public void run() {
		while (true) {
			System.out.println("CURRENTCONSUMPITON::"+getMd().getPresentConsumptionKwh());
			if (getTimer() % hour == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
				System.out.println("--" + getDeviceName() + "--");
			}
			System.out.println("Timer: " + getTimer());
//			System.out.println(getDeviceName() + ":: " + getMd().getDailyConsumptionKwh());
			incrTimer();
			keepTime();

		}
	}
}

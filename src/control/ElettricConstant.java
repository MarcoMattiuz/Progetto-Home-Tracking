package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class ElettricConstant.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class ElettricConstant extends Device {

	/**
	 * Instantiates a new elettric constant.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 */
	public ElettricConstant(String deviceName, int code, Consume consume, Home md, Controller contr) {
		super(deviceName, code, consume, md, true, contr);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}

	/**
	 * Run.
	 */
	//non si puo spegnere
	@Override
	public void run() {
		while (true) {
			if (getTimer() % hour == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
				contr.updateConsumption(getMd().getDailyConsumption());
				System.out.println("--" + getDeviceName() + "--" + getMd().getDailyConsumptionKwh());
			}
			incrTimer();
			keepTime();

		}
	}
}

package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class ElettricOnOff.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class ElettricOnOff extends Device {
	
	/** The first on. */
	private boolean firstOn;

	/**
	 * Instantiates a new elettric on off.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 */
	ElettricOnOff(String deviceName, int code, Consume consume, Home md, Controller contr) {
		super(deviceName, code, consume, md, false, contr);
		this.firstOn = true;
	}

	/**
	 * Toggle.
	 */
	@Override
	public void toggle() {  //prova a implementare con un semaforo
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

	/**
	 * Run.
	 */
	@Override
	public void run() {
		while (true) {
			if (toggle) {
				if (getTimer() % hour == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					System.out.println("--" + getDeviceName() + "--");
				}
				incrTimer();
				keepTime();
			} else {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

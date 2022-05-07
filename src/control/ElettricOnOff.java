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
	ElettricOnOff(String deviceName, int code, Consume consume, Home md, Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, false, contr,RoomKey);
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
			getMd().getRoom(roomKey).addToPresentConsumptionKwh(this.getConsume().getKwh());
		} else {
			getMd().takeFromPresentConsumptionKwh(this.getConsume().getKwh());
			getMd().getRoom(roomKey).takeFromPresentConsumptionKwh(this.getConsume().getKwh());
		}
	}

	/**
	 * Run.
	 */
	@Override
	public void run() {
		while (true) {
			contr.updateConsumption(getMd().getDailyConsumption());
			if (toggle) {
				if (getTimer() != 0 && getTimer() % hour == 0) {
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					getMd().getRoom(roomKey).addToDailyConsumptionKhw(this.getConsume().getKwh());
				}
				incrTimer();
				keepTime();
			} else {
				try {
					System.out.println("SPENTO");
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

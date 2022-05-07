package control;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class ElettricWaterOnOff.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class ElettricWaterOnOff extends Device {
	
	/** The first on. */
	private boolean firstOn;
	
	
	/**
	 * Instantiates a new elettric water on off.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 */
	public ElettricWaterOnOff(String deviceName, int code, Consume consume, Home md, Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, false, contr, RoomKey);
		this.firstOn = true;
	}
	
	
	/**
	 * Toggle.
	 */
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
			if (toggle) {
				if (getTimer() % hour == 0) {
					//casa
					getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
					//stanza
					getMd().getRoom(roomKey).addToDailyConsumptionKhw(this.getConsume().getKwh());
					getMd().getRoom(roomKey).addToDailyConsumption_Lh(this.getConsume().getLh());

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

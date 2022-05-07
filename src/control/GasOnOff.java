package control;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class GasOnOff.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class GasOnOff extends Device {
	
	/** The first on. */
	private boolean firstOn;

	/**
	 * Instantiates a new gas on off.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 */
	public GasOnOff(String deviceName, int code, Consume consume, Home md,Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, false, contr,RoomKey);
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
					getMd().addToDailyConsumption_Gmc(this.getConsume().getGmc());
					getMd().getRoom(roomKey).addToDailyConsumption_Gmc(this.getConsume().getGmc());
					System.out.println("--" + getDeviceName() + "--");
				}
				System.out.println("Timer: " + getTimer());
//				System.out.println(getDeviceName()+":: "+getMd().getDailyConsumptionKwh());
				incrTimer();
				keepTime();
			} else {
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

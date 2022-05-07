package control;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class WaterOnOff.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class WaterOnOff extends Device {

	/** The first on. */
	private boolean firstOn;
	
	/**
	 * Instantiates a new water on off.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 */
	public WaterOnOff(String deviceName, int code, Consume consume, Home md,Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, false, contr, RoomKey);
		this.firstOn = true;
	}

	/**
	 * Toggle.
	 */
	@Override
	public void toggle() {
		toggle = !toggle;
		if(firstOn) {
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
			if(toggle) {
				if(getTimer() % hour == 0) {
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
					getMd().getRoom(roomKey).addToDailyConsumption_Lh(this.getConsume().getLh());
					System.out.println("--"+getDeviceName()+"--");
				}
				System.out.println("Timer: "+getTimer());
				incrTimer();
				keepTime();
			}else {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

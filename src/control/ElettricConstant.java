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
	 * @param contr the contr
	 * @param RoomKey the room key
	 */
	public ElettricConstant(String deviceName, int code, Consume consume, Home md, Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, true, contr,RoomKey);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		md.getRoom(roomKey).addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}

	/**
	 * Run.
	 */
	//non si puo spegnere
	@Override
	public void run() {
		while (true) {
			contr.updateConsumption(getMd().getDailyConsumption()); 
			if (getTimer() != 0 && getTimer() % hour == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
				getMd().getRoom(roomKey).addToDailyConsumptionKhw(this.getConsume().getKwh());
				System.out.println("CASA: "+getMd().getDailyConsumption());
				System.out.println(roomKey+": "+ getMd().getRoom(roomKey).getDailyConsumption());
			}
			incrTimer();
			keepTime();

		}
	}
}

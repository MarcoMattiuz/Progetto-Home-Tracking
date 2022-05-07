package control;

import java.util.concurrent.Semaphore;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class GasElettricConstant.
 *
 * @author Marco&Davide <br>
 *         {@docRoot}
 * @version 4.21.0
 */
public class GasElettricConstant extends Device {

	/**
	 * Instantiates a new gas elettric constant.
	 *
	 * @param deviceName the device name
	 * @param code       the code
	 * @param consume    the consume
	 * @param md         the md
	 */
	private Semaphore test;

	public GasElettricConstant(String deviceName, int code, Consume consume, Home md, Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, true, contr, RoomKey);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		md.getRoom(roomKey).addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.test = new Semaphore(0);
		this.start();
	}

	/**
	 * Run.
	 */
	// non si puo spegnere
	@Override
	public void run() {
		while (true) {
			contr.updateConsumption(getMd().getDailyConsumption());
			if (getTimer() % hour == 0) {
				
				//casa
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
				getMd().addToDailyConsumption_Gmc(this.getConsume().getGmc());
				//stanza
				getMd().getRoom(roomKey).addToDailyConsumptionKhw(this.getConsume().getKwh()); 
				getMd().getRoom(roomKey).addToDailyConsumption_Gmc(this.getConsume().getGmc()); 
				System.out.println("CASA: "+getMd().getDailyConsumption());
				System.out.println(roomKey+": "+ getMd().getRoom(roomKey).getDailyConsumption());
//				System.out.println("--" + getDeviceName() + "--" + getMd().getDailyConsumptionKwh());
//				System.out.println("--" + getDeviceName() + "--" + getMd().getDailyConsumption_Gmc());
			}
			System.out.println("Timer: " + getTimer());
			incrTimer();
			keepTime();
		}
	}
}

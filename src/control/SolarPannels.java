package control;

import model.Consume;
import model.House;

// TODO: Auto-generated Javadoc
/**
 * The Class SolarPannels.
 */
public class SolarPannels extends Device {

	/**
	 * Instantiates a new solar pannels.
	 *
	 * @param deviceName the device name
	 * @param code       the code
	 * @param consume    the consume
	 * @param md         the md
	 * @param contr      the contr
	 * @param RoomKey    the room key
	 */
	public SolarPannels(String deviceName, int code, Consume consume, House md, Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, true, contr, RoomKey);
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
			contr.updateProfit();
			if (getTimer() != 0 && getTimer() % hour == 0) {
				System.out.println("PANNELLI: " + this.getPower());
				double prod = this.getConsume().getKwh() - ((Math.random() * (this.getConsume().getKwh()-1)) + 1);
				System.out.println("produzione: " + prod);
				getMd().addToDailyProducedKhw(prod);
			}
			incrTimer();
			keepTime();
		}
	}

	/**
	 * ritorna la potenza dei pannelli.
	 *
	 * @return the power
	 */
	public double getPower() {
		return this.getConsume().getKwh();
	}
}

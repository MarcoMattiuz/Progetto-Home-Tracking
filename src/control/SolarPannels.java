package control;

import model.Consume;
import model.Home;

// TODO: Auto-generated Javadoc
/**
 * The Class SolarPannels.
 */
public class SolarPannels extends Device{

  /**
   * Instantiates a new solar pannels.
   *
   * @param deviceName the device name
   * @param code the code
   * @param consume the consume
   * @param md the md
   */
  public SolarPannels(String deviceName, int code, Consume consume, Home md,Controller contr, String RoomKey) {
		super(deviceName, code, consume, md, true, contr, RoomKey);
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
				System.out.println("PANNELLI: "+ this.getPower());
				double prod = this.getConsume().getKwh() - ((Math.random()*3)+1);
				System.out.println("produzione: "+ prod);
				getMd().takeFromDailyConsumptionKhw(prod);
				getMd().getRoom(roomKey).takeFromDailyConsumptionKhw(prod); //questo serve per vedere quanto hanno prodotto i pannelli
				System.out.println("--" + getDeviceName() + "--" + getMd().getDailyConsumptionKwh());
			}
			System.out.println("Timer: " + getTimer());
			incrTimer();
			keepTime();
		}
	}
	
	public double getPower() {
		return this.getConsume().getKwh();
	}
}

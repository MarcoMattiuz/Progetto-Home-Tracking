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
  public SolarPannels(String deviceName, int code, Consume consume, Home md,Controller contr) {
		super(deviceName, code, consume, md, true, contr);
//		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}


	/**
	 * Run.
	 */
	//non si puo spegnere
	@Override
	public void run() {
		while (true) {
			System.out.println("CURRENTCONSUMPITON::"+getMd().getPresentConsumptionKwh());
			if (getTimer() % hour == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh() - ((Math.random()*3)+1));
				System.out.println("--" + getDeviceName() + "--");
			}
			System.out.println("Timer: " + getTimer());
			incrTimer();
			keepTime();
		}
	}
}

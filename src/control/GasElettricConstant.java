package control;

import model.Consume;
import model.Home;
/**
 * 
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class GasElettricConstant extends Device {

	/**
	 * 
	 * @param deviceName
	 * @param code
	 * @param consume
	 * @param md
	 */
	public GasElettricConstant(String deviceName, int code, Consume consume, Home md) {
		super(deviceName, code, consume, md, true);
		md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		this.start();
	}
	//non si puo spegnere
	@Override
	public void run() {
		while (true) {
			System.out.println("CURRENTCONSUMPITON::"+getMd().getPresentConsumptionKwh());
			if (getTimer() % hour == 0) {
				getMd().addToDailyConsumptionKhw(this.getConsume().getKwh());
				getMd().addToDailyConsumption_Gmc(this.getConsume().getGmc());
				System.out.println("--" + getDeviceName() + "--");
			}
			System.out.println("Timer: " + getTimer());
//			System.out.println(getDeviceName() + ":: " + getMd().getDailyConsumptionKwh());
			incrTimer();
			keepTime();
		}
	}
}

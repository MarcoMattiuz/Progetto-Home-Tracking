package control;

import model.Consume;
import model.Home;

public class WaterOnOff extends Device {

	private boolean firstOn;

	public WaterOnOff(String deviceName, int code, Consume consume, Home md) {
		super(deviceName, code, consume, md, false);
		this.firstOn = true;
	}

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

	@Override
	public void run() {
		while (true) {
			if(toggle) {
				if(getTimer() % hour == 0) {
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
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

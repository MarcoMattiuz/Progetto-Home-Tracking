package control;

import model.Consume;
import model.Home;

public class SinksShowers extends Device {

	private boolean firstOn;

	public SinksShowers(String deviceName, int code, Consume consume, Home md) {
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
				if(getTimer() % 5 == 0) {
					getMd().addToDailyConsumption_Lh(this.getConsume().getLh());
					System.out.println("--"+getDeviceName()+"--");
				}
				System.out.println("Timer: "+getTimer());
				incrTimer();
				keepTime();
			}else {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

package control;

import model.Consume;

public class TimerDevice extends Device {

	/**
	 * 
	 * @param name
	 * @param code
	 * @param consume
	 */
	public TimerDevice(String name, int code, Consume consume) {
		super(name, code, consume);
	}

	// setTimer

	private void decrTimer() {
		this.setTimer(this.getTimer() - 1);
	}

	@Override
	public void run() {
		while (this.getTimer() > 0) {
			// va avanti finchè il timer non scade e parte solo dopo che il timer è stato
			// decrTimer()
			//sleep(1000)
		}
	}

}

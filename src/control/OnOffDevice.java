package control;

import model.Consume;

public class OnOffDevice extends Device {

	private boolean toggle; //true --> on //false --> off
	/**
	 * @param name
	 * @param code
	 * @param consume
	 */
	public OnOffDevice(String name, int code, Consume consume) {
		super(name, code, consume);
		this.toggle = false;
	}
	
	public void toggle() {
		toggle = !toggle;
	}
	
	@Override
	public void run() {
		while(toggle) {
			
			//incrTimer()
			//sleep(1000);
		}
	}

}

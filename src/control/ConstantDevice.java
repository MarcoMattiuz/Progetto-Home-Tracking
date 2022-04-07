package control;

import model.Consume;

public class ConstantDevice extends Device {

	private boolean toggle; //true --> on //false --> off
	/**
	 * 
	 * @param name
	 * @param code
	 * @param consume
	 */
	public ConstantDevice(String name, int code, Consume consume) {
		super(name, code, consume);
		this.toggle = true;
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

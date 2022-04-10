package control;

import model.Consume;
import model.Home;

public abstract class Device extends Thread {
	private String deviceName;
	private int code; //incrementale
	private Consume consume;
	private Home md;
	private int timer; //contatore del tempo 
	
	/**
	 * Constructor
	 * @param deviceName
	 * @param code
	 * @param consume
	 */
	public Device(String deviceName, int code, Consume consume, Home md) {
		this.deviceName= deviceName;
		this.code = code;
		this.consume = consume;
		this.md = md;
		this.timer = 0;
	
	}
	
	/**
	 * 
	 * @return deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 
	 * @return code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * 
	 * @return consume
	 */
	public Consume getConsume() {
		return consume;
	}
	/**
	 * 
	 * @return timer
	 */
	protected int getTimer() {
		return timer;
	}
	/**
	 * 
	 * @param start_timer
	 */
	protected void setTimer(int start_timer) {
		timer = start_timer;
	}
	/**
	 * increments timer by 1
	 */
	protected void incrTimer() {
		timer++;
	}
	
	protected void keepTime() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Home getMd() {
		return md;
	}

	public abstract void toggle();

	public abstract boolean isToggle();
	
	
}

package control;

import model.Consume;

public class Device extends Thread {
	private String deviceName;
	private int code; //incrementale
	private Consume consume;
	private int timer; //contatore del tempo 
	
	/**
	 * Constructor
	 * @param deviceName
	 * @param code
	 * @param consume
	 */
	public Device(String deviceName, int code, Consume consume) {
		this.deviceName= deviceName;
		this.code = code;
		this.consume = consume;
		this.timer = 0;
		this.start();
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
	
	
}

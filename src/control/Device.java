package control;

import model.Consume;
import model.Home;
// TODO: Auto-generated Javadoc

/**
 * The Class Device.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public abstract class Device extends Thread {
	
	/** The device name. */
	private String deviceName;
	
	/** The code. */
	private int code; //incrementale
	
	/** The consume. */
	private Consume consume;
	
	/** The md. */
	private Home md;
	
	/** The timer. */
	private int timer; //contatore del tempo 
	
	/** The toggle. */
	protected boolean toggle;
	
	/** The hour. */
	protected int hour;
	
	/** The contr. */
	protected Controller contr;
	
	/** The room key. */
	protected String roomKey;
	
	/**
	 * Constructor.
	 *
	 * @param deviceName the device name
	 * @param code the code
	 * @param consume the consume
	 * @param md the md
	 * @param toggle the toggle
	 * @param contr the contr
	 * @param RoomKey the room key
	 */
	public Device(String deviceName, int code, Consume consume, Home md, boolean toggle, Controller contr, String RoomKey) {
		this.contr = contr;
		this.deviceName= deviceName;
		this.code = code;
		this.consume = consume;
		this.md = md;
		this.timer = 0;
		this.toggle = toggle;
		this.roomKey = RoomKey;
		this.hour = 60;
	}
	
	/**
	 * Gets the device name.
	 *
	 * @return deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Gets the consume.
	 *
	 * @return consume
	 */
	public Consume getConsume() {
		return consume;
	}
	
	protected double getPercentConsumption(double consume) {
		int percent = (100/hour) * (getTimer() % hour);
		double ret = consume - (consume/100) * percent;
		return ret;
	}
	/**
	 * Gets the timer.
	 *
	 * @return timer
	 */
	protected int getTimer() {
		return timer;
	}
	
	/**
	 * Sets the timer.
	 *
	 * @param start_timer the new timer
	 */
	protected void setTimer(int start_timer) {
		timer = start_timer;
	}
	
	/**
	 * increments timer by 1.
	 */
	protected void incrTimer() {
		timer++;
	}

	/**
	 * Keep time. metodo che viene utilizzato nei metodi run per tenere i tempo costante tra i dispositivi
	 */
	protected void keepTime() {
		try {
			sleep(500); //minuto
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the md.
	 *
	 * @return the md
	 */
	public Home getMd() {
		return md;
	}

	/**
	 * Toggle. metodo toggle di base
	 */
	public void toggle() {
		toggle = !toggle;
		if (toggle) {
			setTimer(0);
			md.addToPresentConsumptionKwh(this.getConsume().getKwh());
		} else {
			md.takeFromPresentConsumptionKwh(this.getConsume().getKwh());
		}
	}
	

	@Override
	public String toString() {
		return "Device [deviceName=" + deviceName + ", code=" + code + ", toggle=" + toggle + ", roomKey=" + roomKey
				+ "]";
	}

	/**
	 * Checks if is toggle.
	 *
	 * @return true, if is toggle
	 */
	public boolean isToggle() {
		return toggle;
	}
	
	
}

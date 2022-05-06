package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import control.Device;

// TODO: Auto-generated Javadoc
/**
 * The Class Home.
 *
 * @author Marco&Davide <br>
 *         {@docRoot}
 * @version 4.21.0
 */
public class Home {
	
	/** The house holder. */
	private String house_holder;
	
	/** The rooms. */
	private Map<String, Room> rooms;
	
	/** The contract. */
	private Contract contract;
	
	/** The daily consumption kwh. */
	private double dailyConsumption_Kwh;
	
	/** The present consumption kwh. */
	private double presentConsumption_Kwh;
	
	/** The daily consumption gmc. */
	private double dailyConsumption_Gmc;
	
	/** The daily consumption lh. */
	private double dailyConsumption_Lh;
	
	/** The money kwh. */
	private double money_kwh;
	
	/** The money gmh. */
	private double money_Gmh;
	
	/** The money lh. */
	private double money_Lh;

	/**
	 * Instantiates a new home.
	 *
	 * @param house_holder the house holder
	 * @param contract the contract
	 */
	public Home(String house_holder, Contract contract) {
		this.house_holder = house_holder;
		this.contract = contract;
		this.rooms = new HashMap<String, Room>();
		this.dailyConsumption_Kwh = 0;
		this.presentConsumption_Kwh = 0;
		this.setDailyConsumption_Gmc(0);
		this.setDailyConsumption_Lh(0);
		this.money_Gmh = 0;
		this.money_kwh = 0;
		this.money_Lh = 0;
	}

	/**
	 * Generate rooms. metodo che istanzia le case e viene richiamato nel controller
	 *
	 * @param num the num 
	 */
	public ArrayList<String> generateRooms(int num) {
		ArrayList<String> ret = new ArrayList<String>();
		switch (num) {
		case 7:
			rooms.put("camera-2", new Room("camera-2"));		ret.add("Camera 2");
		case 6:
			rooms.put("bagno-2", new Room("bagno-2"));			ret.add("Bagno 2");
		case 5:
			rooms.put("camera-1", new Room("camera-1"));		ret.add("Camera 1");
		case 4:
			rooms.put("soggiorno", new Room("soggiorno"));		ret.add("Soggiorno");
		case 3:
			rooms.put("bagno-1", new Room("bagno-1"));			ret.add("Bagno 1");
		case 2:
			rooms.put("cucina", new Room("cucina"));			ret.add("Cucina");
		default:
			rooms.put("taverna", new Room("taverna"));			ret.add("Taverna");
			break;
		}
		return ret;
	}

	/**
	 * Round avoid. arrotonda un double in base ai posti decimali inseriti
	 *
	 * @param value the value
	 * @param places the places
	 * @return Math.round(value * scale) / scale
	 */
	private static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	/**
	 * Adds the room.
	 *
	 * @param roomName the room name
	 * @param room the room
	 */
	public void addRoom(String roomName, Room room) {
		rooms.put(roomName, room);
	}

	/**
	 * Gets the room.
	 *
	 * @param key the key
	 * @return rooms.get(key)
	 * @see model.Home
	 */
	public Room getRoom(String key) {
		return rooms.get(key);
	}

	/**
	 * Gets the house holder.
	 *
	 * @return house_holder
	 */
	public String getHouse_holder() {
		return house_holder;
	}

	/**
	 * Gets the rooms.
	 *
	 * @return rooms
	 */
	public Map<String, Room> getRooms() {
		return rooms;
	}

	/**
	 * Gets the daily consumption kwh.
	 *
	 * @return dailyConsumption_Kwh
	 */
	public synchronized double getDailyConsumptionKwh() {
		return dailyConsumption_Kwh;
	}

	/**
	 * Sets the daily consumption kwh.
	 *
	 * @param consumption the new daily consumption kwh
	 */
	public synchronized void setDailyConsumptionKwh(double consumption) {
		this.dailyConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	/**
	 * Adds the to daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Take from daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Gets the present consumption kwh.
	 *
	 * @return presentConsumption_Kwh
	 */
	public synchronized double getPresentConsumptionKwh() {
		return presentConsumption_Kwh;

	}
	
	/**
	 * Sets the present consumption kwh.
	 *
	 * @param consumption the new present consumption kwh
	 */
	public synchronized void setPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Adds the to present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Take from present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Check limit kwh.
	 *
	 * @return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	 */
	public synchronized boolean CheckLimitKwh() {
		// se true tutti i thread devono essre interrotti
		return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	}

	/**
	 * Gets the contract.
	 *
	 * @return contract
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * Gets the daily consumption gmc.
	 *
	 * @return dailyConsumption_Gmc
	 */
	public synchronized double getDailyConsumption_Gmc() {
		return dailyConsumption_Gmc;
	}
	
	/**
	 * Sets the daily consumption gmc.
	 *
	 * @param dailyConsumption_Gmc the new daily consumption gmc
	 */
	public synchronized void setDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc = dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);
	}
	
	/**
	 * Adds the to daily consumption gmc.
	 *
	 * @param dailyConsumption_Gmc the daily consumption gmc
	 */
	public synchronized void addToDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc += dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}
	
	/**
	 * Take from daily consumption gmc.
	 *
	 * @param dailyConsumption_Gmc the daily consumption gmc
	 */
	public synchronized void takeFromDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc -= dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}
	
	/**
	 * Gets the daily consumption lh.
	 *
	 * @return dailyConsumption_Lh
	 */
	public synchronized double getDailyConsumption_Lh() {
		return dailyConsumption_Lh;
	}
	
	/**
	 * Sets the daily consumption lh.
	 *
	 * @param dailyConsumption_Lh the new daily consumption lh
	 */
	public synchronized void setDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh = dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	/**
	 * Adds the to daily consumption lh.
	 *
	 * @param dailyConsumption_Lh the daily consumption lh
	 */
	public synchronized void addToDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh += dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	/**
	 * Take from daily consumption lh.
	 *
	 * @param dailyConsumption_Lh the daily consumption lh
	 */
	public synchronized void takeFromDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh -= dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	/**
	 * Adds the to money kwh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Kwh(double ammount) {
		this.money_kwh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_kwh, 3);
	}
	
	/**
	 * Adds the to money gmh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Gmh(double ammount) {
		this.money_Gmh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_Gmh, 3);
	}
	
	/**
	 * Adds the to money lh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Lh(double ammount) {
		this.money_Lh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_Lh, 3);
	}
	
	/**
	 * Gets the money kwh.
	 *
	 * @return money_kwh
	 */
	public double getMoney_kwh() {
		return money_kwh;
	}
	
	/**
	 * Sets the money kwh.
	 *
	 * @param money_kwh the new money kwh
	 */
	public void setMoney_kwh(double money_kwh) {
		this.money_kwh = money_kwh;
	}
	
	/**
	 * Gets the money gmh.
	 *
	 * @return money_Gmh
	 */
	public double getMoney_Gmh() {
		return money_Gmh;
	}
	
	/**
	 * Sets the money gmh.
	 *
	 * @param money_Gmh the new money gmh
	 */
	public void setMoney_Gmh(double money_Gmh) {
		this.money_Gmh = money_Gmh;
	}
	
	/**
	 * Gets the money lh.
	 *
	 * @return money_Lh
	 */
	public double getMoney_Lh() {
		return money_Lh;
	}
	
	/**
	 * Sets the money lh.
	 *
	 * @param money_Lh the new money lh
	 */
	public void setMoney_Lh(double money_Lh) {
		this.money_Lh = money_Lh;
	}

}

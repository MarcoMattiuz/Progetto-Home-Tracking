package model;

import java.util.HashMap;
import java.util.Map;

import control.Device;

/**
 * 
 * @author Marco&Davide <br>
 *         {@docRoot}
 * @version 4.21.0
 */
public class Home {
	private String house_holder;
	private Map<String, Room> rooms;
	private Contract contract;
	private double dailyConsumption_Kwh;
	private double presentConsumption_Kwh;
	private double dailyConsumption_Gmc;
	private double dailyConsumption_Lh;
	private double money_kwh;
	private double money_Gmh;
	private double money_Lh;

	/**
	 * 
	 * @param house_holder
	 * @param contract
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
	 * 
	 * @param num
	 */
	public void generateRooms(int num) {
		switch (num) {
		case 7:
			rooms.put("camera-2", new Room("camera-2"));
		case 6:
			rooms.put("bagno-2", new Room("bagno-2"));
		case 5:
			rooms.put("camera-1", new Room("camera-1"));
		case 4:
			rooms.put("soggiorno", new Room("soggiorno"));
		case 3:
			rooms.put("bagno-1", new Room("bagno-1"));
		case 2:
			rooms.put("cucina", new Room("cucina"));
		default:
			rooms.put("taverna", new Room("taverna"));
			break;
		}
	}

	/**
	 * 
	 * @param value
	 * @param places
	 * @return Math.round(value * scale) / scale
	 */
	private static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	/**
	 * 
	 * @param roomName
	 * @param room
	 */
	public void addRoom(String roomName, Room room) {
		rooms.put(roomName, room);
	}

	/**
	 * 
	 * @param key
	 * @return rooms.get(key)
	 * @see model.Home
	 */
	public Room getRoom(String key) {
		return rooms.get(key);
	}

	/**
	 * 
	 * @return house_holder
	 */
	public String getHouse_holder() {
		return house_holder;
	}

	/**
	 * 
	 * @return rooms
	 */
	public Map<String, Room> getRooms() {
		return rooms;
	}

	/**
	 * 
	 * @return dailyConsumption_Kwh
	 */
	public synchronized double getDailyConsumptionKwh() {
		return dailyConsumption_Kwh;
	}

	/**
	 * 
	 * @param consumption
	 */
	public synchronized void setDailyConsumptionKwh(double consumption) {
		this.dailyConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	/**
	 * 
	 * @param consumption
	 */
	public synchronized void addToDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	/**
	 * 
	 * @param consumption
	 */
	public synchronized void takeFromDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	/**
	 * 
	 * @return presentConsumption_Kwh
	 */
	public synchronized double getPresentConsumptionKwh() {
		return presentConsumption_Kwh;

	}
	/**
	 * 
	 * @param consumption
	 */
	public synchronized void setPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	/**
	 * 
	 * @param consumption
	 */
	public synchronized void addToPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	/**
	 * 
	 * @param consumption
	 */
	public synchronized void takeFromPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	/**
	 * 
	 * @return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	 */
	public synchronized boolean CheckLimitKwh() {
		// se true tutti i thread devono essre interrotti
		return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	}

	/**
	 * 
	 * @return contract
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * 
	 * @return dailyConsumption_Gmc
	 */
	public synchronized double getDailyConsumption_Gmc() {
		return dailyConsumption_Gmc;
	}
	/**
	 * 
	 * @param dailyConsumption_Gmc
	 */
	public synchronized void setDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc = dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);
	}
	/**
	 * 
	 * @param dailyConsumption_Gmc
	 */
	public synchronized void addToDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc += dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}
	/**
	 * 
	 * @param dailyConsumption_Gmc
	 */
	public synchronized void takeFromDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc -= dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}
	/**
	 * 
	 * @return dailyConsumption_Lh
	 */
	public synchronized double getDailyConsumption_Lh() {
		return dailyConsumption_Lh;
	}
	/**
	 * 
	 * @param dailyConsumption_Lh
	 */
	public synchronized void setDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh = dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	/**
	 * 
	 * @param dailyConsumption_Lh
	 */
	public synchronized void addToDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh += dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	/**
	 * 
	 * @param dailyConsumption_Lh
	 */
	public synchronized void takeFromDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh -= dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	/**
	 * 
	 * @param ammount
	 */
	public synchronized void addToMoney_Kwh(double ammount) {
		this.money_kwh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_kwh, 3);
	}
	/**
	 * 
	 * @param ammount
	 */
	public synchronized void addToMoney_Gmh(double ammount) {
		this.money_Gmh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_Gmh, 3);
	}
	/**
	 * 
	 * @param ammount
	 */
	public synchronized void addToMoney_Lh(double ammount) {
		this.money_Lh += ammount;
		dailyConsumption_Kwh = roundAvoid(money_Lh, 3);
	}
	/**
	 * 
	 * @return money_kwh
	 */
	public double getMoney_kwh() {
		return money_kwh;
	}
	/**
	 * 
	 * @param money_kwh
	 */
	public void setMoney_kwh(double money_kwh) {
		this.money_kwh = money_kwh;
	}
	/**
	 * 
	 * @return money_Gmh
	 */
	public double getMoney_Gmh() {
		return money_Gmh;
	}
	/**
	 * 
	 * @param money_Gmh
	 */
	public void setMoney_Gmh(double money_Gmh) {
		this.money_Gmh = money_Gmh;
	}
	/**
	 * 
	 * @return money_Lh
	 */
	public double getMoney_Lh() {
		return money_Lh;
	}
	/**
	 * 
	 * @param money_Lh
	 */
	public void setMoney_Lh(double money_Lh) {
		this.money_Lh = money_Lh;
	}

}

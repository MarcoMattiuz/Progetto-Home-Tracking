package model;

import java.util.HashMap;
import java.util.Map;

import control.Device;

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

	public void generateRooms(int num) {
		switch(num) {
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
	private static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	public void addRoom(String roomName, Room room) {
		rooms.put(roomName, room);
	}

	public Room getRoom(String key) {
		return rooms.get(key);
	}

	public String getHouse_holder() {
		return house_holder;
	}

	public Map<String, Room> getRooms() {
		return rooms;
	}

	/**
	 * Kwh
	 */
	public synchronized double getDailyConsumptionKwh() {
		return dailyConsumption_Kwh;
	}

	public synchronized void setDailyConsumptionKwh(double consumption) {
		this.dailyConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized void addToDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized void takeFromDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized double getPresentConsumptionKwh() {
		return presentConsumption_Kwh;

	}

	public synchronized void setPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh = consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized void addToPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized void takeFromPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	public synchronized boolean CheckLimitKwh() {
		// se true tutti i thread devono essre interrotti
		return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	}

	/**
	 * 
	 * Contract
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * Gmc GAS
	 */
	public synchronized double getDailyConsumption_Gmc() {
		return dailyConsumption_Gmc;
	}

	public synchronized void setDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc = dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);
	}

	public synchronized void addToDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc += dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}

	public synchronized void takeFromDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc -= dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

	}

	public synchronized double getDailyConsumption_Lh() {
		return dailyConsumption_Lh;
	}

	public synchronized void setDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh = dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}

	public synchronized void addToDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh += dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}

	public synchronized void takeFromDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh -= dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}

	public synchronized void addToMoney_Kwh(double ammount) {
		this.money_kwh += ammount;
	}

	public synchronized void addToMoney_Gmh(double ammount) {
		this.money_Gmh += ammount;
	}

	public synchronized void addToMoney_Lh(double ammount) {
		this.money_Lh += ammount;
	}

	public double getMoney_kwh() {
		return money_kwh;
	}

	public void setMoney_kwh(double money_kwh) {
		this.money_kwh = money_kwh;
	}

	public double getMoney_Gmh() {
		return money_Gmh;
	}

	public void setMoney_Gmh(double money_Gmh) {
		this.money_Gmh = money_Gmh;
	}

	public double getMoney_Lh() {
		return money_Lh;
	}

	public void setMoney_Lh(double money_Lh) {
		this.money_Lh = money_Lh;
	}

}

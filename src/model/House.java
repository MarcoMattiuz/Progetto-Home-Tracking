package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Home.
 *
 * @author Marco&Davide <br>
 *         {@docRoot}
 * @version 4.21.0
 */
public class House extends Consumption {

	/** The house holder. */
	private String house_holder;

	/** The rooms. */
	private Map<String, Room> rooms;

	/** The contract. */
	private Contract contract;

	/** The money kwh. */
	private double money_kwh;

	/** The money gmh. */
	private double money_Gmh;

	/** The money lh. */
	private double money_Lh;

	/** The money gains. */
	private double money_gains;

	/**
	 * Instantiates a new home.
	 *
	 * @param house_holder the house holder
	 * @param contract     the contract
	 */
	public House(String house_holder, Contract contract) {
		this.house_holder = house_holder;
		this.contract = contract;
		this.rooms = new HashMap<String, Room>();
		this.money_Gmh = 0;
		this.money_kwh = 0;
		this.money_Lh = 0;
		this.money_gains = 0;
	}

	/**
	 * Generate rooms. metodo che istanzia le case e viene richiamato nel controller
	 *
	 * @param num     the num
	 * @param isSolar the is solar
	 * @return the array list
	 */
	public ArrayList<Room> generateRooms(int num, boolean isSolar) {
		ArrayList<Room> ret = new ArrayList<Room>();
		if (isSolar) {
			rooms.put("roof", new Room("roof"));
			ret.add(rooms.get("roof"));
		}
		switch (num) {
		case 7:
			rooms.put("bedroom-2", new Room("Bedroom 2"));
			ret.add(rooms.get("camera-2"));
		case 6:
			rooms.put("bathroom-2", new Room("Bathroom 2"));
			ret.add(rooms.get("bagno-2"));
		case 5:
			rooms.put("bedroom-1", new Room("Bedroom 1"));
			ret.add(rooms.get("camera-1"));
		case 4:
			rooms.put("livingroom", new Room("Livingroom"));
			ret.add(rooms.get("soggiorno"));
		case 3:
			rooms.put("bathroom-1", new Room("Bathroom 1"));
			ret.add(rooms.get("bagno-1"));
		case 2:
			rooms.put("kitchen", new Room("Kitchen"));
			ret.add(rooms.get("cucina"));
		default:
			rooms.put("tavern", new Room("Tavern"));
			ret.add(rooms.get("taverna"));
			break;
		}
		return ret;
	}

	/**
	 * Adds the room.
	 *
	 * @param roomName the room name
	 * @param room     the room
	 */
	public void addRoom(String roomName, Room room) {
		rooms.put(roomName, room);
	}

	/**
	 * Gets the room.
	 *
	 * @param key the key
	 * @return rooms.get(key)
	 * @see model.House
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
	 * Check limit kwh.
	 *
	 * @return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	 */
//	public synchronized boolean CheckLimitKwh() {
//		// se true tutti i thread devono essre interrotti
//		return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
//	}

	/**
	 * Gets the contract.
	 *
	 * @return contract
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * Adds the to money kwh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Kwh(double ammount) {
		this.money_kwh += ammount;
		dailyConsumption_Kwh = round(money_kwh);
	}

	/**
	 * Adds the to money gmh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Gmh(double ammount) {
		this.money_Gmh += ammount;
		dailyConsumption_Kwh = round(money_Gmh);
	}

	/**
	 * Adds the to money lh.
	 *
	 * @param ammount the ammount
	 */
	public synchronized void addToMoney_Lh(double ammount) {
		this.money_Lh += ammount;
		dailyConsumption_Kwh = round(money_Lh);
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

	/**
	 * calcola quanto bisogna pagare di ogni risorsa in base ai prezzi nel proprio contratto.
	 *
	 * @return the string
	 */
	public synchronized String calculateMoney() {
		System.out.println(contract.getPrice_kwh() + "   --    " + getDailyConsumptionKwh());
		money_kwh = contract.getPrice_kwh() * getDailyConsumptionKwh();
		money_kwh = round(money_kwh);
		System.out.println("MOMO" + money_kwh);
		money_Gmh = contract.getPrice_gmh() * getDailyConsumption_Gmc();
		money_Gmh = round(money_Gmh);
		money_Lh = contract.getPrice_lh() * getDailyConsumption_Lh();
		money_Lh = round(money_Lh);

		return "Costs: " + money_kwh + " $/kwh," + money_Gmh + " $/Gmh,: " + money_Lh + " $/Lh";
	}

	/**
	 * calcola i guadagni prodotti dai pannelli solari.
	 *
	 * @return the string
	 */
	public synchronized String calculateGains() {
		money_gains = dailyProduced_Kwh * contract.getPrice_kwh();
		money_gains = round(money_gains);
		return "Produced Electricity: " + dailyProduced_Kwh + "kW/h, Profit: " + money_gains + "$ in sold elettricity";
	}

	/**
	 * calcola i guadagni totati, la bolletta e la bolletta tolti i guadagni.
	 *
	 * @return the string
	 */
	public synchronized String calculateBill() {
		double bill = money_kwh + money_Gmh + money_Lh;
		double billPlusProduced = bill - money_gains;
		bill = round(bill);
		billPlusProduced = round(billPlusProduced);
		return "Total bill: " + bill + "$, Bill - [produced elettricity]: " + billPlusProduced + "$";
	}

}

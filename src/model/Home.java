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
public class Home extends Consumption{
	
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
		this.money_Gmh = 0;
		this.money_kwh = 0;
		this.money_Lh = 0;
	}

	/**
	 * Generate rooms. metodo che istanzia le case e viene richiamato nel controller
	 *
	 * @param num the num
	 * @param isSolar the is solar
	 * @return the array list
	 */
	public ArrayList<String> generateRooms(int num, boolean isSolar) {
		ArrayList<String> ret = new ArrayList<String>();
		if(isSolar) {
			rooms.put("roof", new Room("roof"));                    ret.add("Roof");
		}
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

package model;

import java.util.HashMap;
import java.util.Map;

public class Home {
	private String house_holder;
	private Map<String, Room> rooms;
	private Contract contract;
	private double dailyConsumption;
	private double presentConsumption;
	
	public Home(String house_holder, Contract contract) {
		this.house_holder = house_holder;
		this.contract = contract;
		this.rooms = new HashMap<String, Room>();
		this.dailyConsumption = 0;
		this.presentConsumption = 0;
	}

	public String getHouse_holder() {
		return house_holder;
	}


	public Map<String, Room> getRooms() {
		return rooms;
	}


	public double getDailyConsumption() {
		return dailyConsumption;
	}

	public void setDailyConsumption(double consumption) {
		this.dailyConsumption += consumption;
	}

	public double getPresentConsumption() {
		return presentConsumption;
	}


	public void setPresentConsumption(double consumption) {
		this.presentConsumption += consumption;
	}
	
	/**
	 * 
	 * @return true (if presentConsumption >= contract.getMax_kw()) false (if presentConsumption < contract.getMax_kw()) 
	 */
	public boolean CheckLimitKwh() {
		return presentConsumption >= contract.getMax_kw() ? true : false;
	}
	
	

	
	
	
}

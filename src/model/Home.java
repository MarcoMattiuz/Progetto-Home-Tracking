package model;

import java.util.HashMap;
import java.util.Map;

public class Home {
	private String house_holder;
	private Map<String, Room> rooms;
	private Contract contract;
	private double dailyConsumption_Kwh;
	private double presentConsumption_Kwh;
	private double dailyConsumption_Gmc;
	private double dailyConsumption_Lh;
	
	public Home(String house_holder, Contract contract) {
		this.house_holder = house_holder;
		this.contract = contract;
		this.rooms = new HashMap<String, Room>();
		this.dailyConsumption_Kwh = 0;
		this.presentConsumption_Kwh = 0;
		this.dailyConsumption_Gmc = 0;
		this.dailyConsumption_Lh = 0;
	}

	public String getHouse_holder() {
		return house_holder;
	}


	public Map<String, Room> getRooms() {
		return rooms;
	}


	public double getDailyConsumptionKwh() {
		return dailyConsumption_Kwh;
	}

	public void setDailyConsumptionKwh(double consumption) {
		this.dailyConsumption_Kwh = consumption;
	}

	public double getPresentConsumptionKwh() {
		return presentConsumption_Kwh;
	}


	public void setPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh = consumption;
	}
	
	/**
	 * 
	 * @return true (if presentConsumption >= contract.getMax_kw()) false (if presentConsumption < contract.getMax_kw()) 
	 */
	public boolean CheckLimitKwh() {
		return presentConsumption_Kwh >= contract.getMax_kw() ? true : false;
	}
	
	

	
	
	
}

package model;

import java.util.HashMap;
import java.util.Map;

public class Home {
	private String house_holder;
	private Map<String, Room> rooms;
	
	public Home(String house_holder) {
		this.house_holder = house_holder;
		this.rooms = new HashMap<String, Room>();
	}

	
	
	
}

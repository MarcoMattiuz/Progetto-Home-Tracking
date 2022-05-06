package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import control.Device;
// TODO: Auto-generated Javadoc

/**
 * The Class Room.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class Room {
	
	/** The name. */
	private String name;
	
	/** The devices. */
	private ArrayList<Device> devices;
	
	/**
	 * Instantiates a new room.
	 *
	 * @param name the name
	 */
	public Room(String name){
		this.name = name;
		this.devices = new ArrayList<Device>(10);
	}
	
	/**
	 * Gets the device by code.
	 *
	 * @param code the code
	 * @return found
	 */
	public Device getDeviceByCode(int code) {
		Device found = null;
		for (Device device : devices) {
			if(device.getCode() == code) {
				found = device;
			}
		}
		return found;
	}
	
	/**
	 * Adds the device.
	 *
	 * @param device the device
	 */
	public void addDevice(Device device) {
		devices.add(device);
	}
	
	/**
	 * Removes the device by code.
	 *
	 * @param code the code
	 */
	public void removeDeviceByCode(int code) {
		devices.removeIf(n -> (n.getCode() == code));
	}
	
	/**
	 * Removes all device by name.
	 *
	 * @param name the name
	 */
	public void removeAllDeviceByName(String name) {
		ArrayList<Device> arr = new ArrayList<Device>(10);
		for (Device device : devices) {
			if(device.getName().equals(name)) {
				arr.add(device);
			}
		}
		devices.removeAll(arr);
	}
	
}

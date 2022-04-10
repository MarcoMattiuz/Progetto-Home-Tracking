package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import control.Device;

public class Room {
	private String name;
	private ArrayList<Device> devices;
	
	public Room(String name){
		this.name = name;
		this.devices = new ArrayList<Device>(10);
	}
	
	public Device getDeviceByCode(int code) {
		Device found = null;
		for (Device device : devices) {
			if(device.getCode() == code) {
				found = device;
			}
		}
		return found;
	}
	public void addDevice(Device device) {
		devices.add(device);
	}
	
	public void removeDeviceByCode(int code) {
		devices.removeIf(n -> (n.getCode() == code));
	}
	
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

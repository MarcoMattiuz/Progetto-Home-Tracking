/*
 * 
 */
package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Consume;
import model.House;
import model.Room;
import view.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Controller.
 *
 * @author Marco&Davide <br>
 *         {@docRoot}
 * @version 4.21.0
 */
public class Controller extends Thread implements ActionListener, ListSelectionListener {

	/** The house. */
	private House house;

	/** The window. */
	private Window window;

	/** The rooms names. */
	private ArrayList<Room> rooms;

	/** The rooms names reversed. */
	private ArrayList<Room> roomsReversed;

	/** The rooms flag. */
	private Boolean roomsFlag;
	
	/** The house flag. */
	private Boolean houseFlag;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param h the h
	 */
	public Controller(House h) {
		this.house = h;
		roomsFlag=houseFlag=false;
	}

	/**
	 * Sets the window.
	 *
	 * @param win the new window
	 */
	public void setWindow(Window win) {
		this.window = win;
	}

	/**
	 * Genera la casa istanzia le stanze e i dispositivi e i pannelli.
	 *
	 * @param numRooms the num rooms
	 * @param isSolar  the is solar
	 * @param solar    the solar
	 * @param price_kwh the price kwh
	 * @param price_Gmh the price gmh
	 * @param price_Lh the price lh
	 * @return the array list
	 */
	public ArrayList<Room> generateHouse(int numRooms, boolean isSolar, int solar, double price_kwh,double price_Gmh,double price_Lh) {
		ArrayList<Room> rn = house.generateRooms(numRooms, isSolar);
		house.getContract().setPrices(price_kwh, price_Gmh, price_Lh);
		// solar � la potenza dell'impianto e viene messa come -consumo nei pannelli
		if (isSolar) {
			Room Roof = house.getRoom("Roof");
			Roof.addDevice(new SolarPannels("solar-panels", 01, new Consume(solar, 0, 0), house, this, "Roof"));
		}
		Collections.reverse(rn);
		window.initializeMenuItems(numRooms, rn, isSolar);
		switch (numRooms) {
		case 7:
			Room bedroom2 = house.getRoom("bedroom-2");
			bedroom2.addDevice(new ElettricOnOff("Led_Light", 21, new Consume(0.007, 0, 0), house, this, "bedroom-2"));
			bedroom2.addDevice(new ElettricOnOff("Led_Light", 22, new Consume(0.007, 0, 0), house, this, "bedroom-2"));
			bedroom2.addDevice(
					new ElettricOnOff("Computer-2", 23, new Consume(1.1, 0, 0), house, this, "bedroom-2"));
			window.addRoomPanel(new RoomPanel(this, bedroom2, rn.get(6).getRoomName()));
		case 6:
			Room bathroom2 = house.getRoom("bathroom-2");
			bathroom2.addDevice(new WaterOnOff("Sink", 13, new Consume(0, 0, 320), house, this, "bathroom-2"));
			bathroom2.addDevice(new WaterOnOff("Shower", 14, new Consume(0, 0, 520), house, this, "bathroom-2"));
			bathroom2.addDevice(new ElettricOnOff("Led_Light", 15, new Consume(0.056, 0, 0), house, this, "bathroom-2"));
			bathroom2.addDevice(new ElettricOnOff("Led_Light", 16, new Consume(0.067, 0, 0), house, this, "bathroom-2"));
			window.addRoomPanel(new RoomPanel(this, bathroom2, rn.get(5).getRoomName()));
		case 5:
			Room bedroom1 = house.getRoom("bedroom-1");
			bedroom1.addDevice(new ElettricOnOff("Led_Light", 17, new Consume(0.006, 0, 0), house, this, "bedroom-1"));
			bedroom1.addDevice(new ElettricOnOff("Led_Light", 18, new Consume(0.008, 0, 0), house, this, "bedroom-1"));
			bedroom1.addDevice(
					new ElettricOnOff("Computer_1", 19, new Consume(0.9, 0, 0), house, this, "bedroom-1"));
			bedroom1.addDevice(new ElettricOnOff("Television_1", 20, new Consume(0.3, 0, 0), house, this, "bedroom-1"));
			window.addRoomPanel(new RoomPanel(this, bedroom1, rn.get(4).getRoomName()));
		case 4:
			Room livingroom = house.getRoom("livingroom");
			livingroom.addDevice(new ElettricOnOff("Led_Light", 24, new Consume(0.007, 0, 0), house, this, "livingroom"));
			livingroom.addDevice(new ElettricOnOff("Led_Light", 25, new Consume(0.005, 0, 0), house, this, "livingroom"));
			livingroom.addDevice(new ElettricOnOff("Led_Light", 26, new Consume(0.004, 0, 0), house, this, "livingroom"));
			livingroom.addDevice(new ElettricOnOff("Television_OLed_Light_2", 27, new Consume(0.15, 0, 0), house, this, "livingroom"));
			livingroom.addDevice(
					new ElettricOnOff("Air_Conditioning", 28, new Consume(0.8, 0, 0), house, this, "livingroom"));
			window.addRoomPanel(new RoomPanel(this, livingroom, rn.get(3).getRoomName()));
		case 3:
			Room bathroom1 = house.getRoom("bathroom-1");
			bathroom1.addDevice(new WaterOnOff("Sink", 8, new Consume(0, 0, 350), house, this, "bathroom-1"));
			bathroom1.addDevice(new WaterOnOff("Shower", 9, new Consume(0, 0, 480), house, this, "bathroom-1"));
			bathroom1.addDevice(new ElettricOnOff("Led_Light", 10, new Consume(0.004, 0, 0), house, this, "bathroom-1"));
			bathroom1.addDevice(new ElettricOnOff("Led_Light", 11, new Consume(0.005, 0, 0), house, this, "bathroom-1"));
			bathroom1.addDevice(new ElettricOnOff("Heater", 12, new Consume(2.3, 0, 0), house, this, "bathroom-1"));
			window.addRoomPanel(new RoomPanel(this, bathroom1, rn.get(2).getRoomName()));
		case 2:
			Room kitchen = house.getRoom("kitchen");
			kitchen.addDevice(new ElettricOnOff("Oven", 1, new Consume(1.4, 0, 0), house, this, "kitchen"));
			kitchen.addDevice(new ElettricConstant("Fridge", 2, new Consume(1, 0, 0), house, this, "kitchen"));
			kitchen.addDevice(new ElettricOnOff("Led_Light", 3, new Consume(0.005, 0, 0), house, this, "kitchen"));
			kitchen.addDevice(new ElettricOnOff("Led_Light", 4, new Consume(0.004, 0, 0), house, this, "kitchen"));
			kitchen.addDevice(new ElettricOnOff("Toaster", 5, new Consume(0.5, 0, 0), house, this, "kitchen"));
			kitchen.addDevice(new WaterOnOff("Sink", 6, new Consume(0, 0, 400), house, this, "kitchen")); // 400 litri
																											// all'ora
			kitchen.addDevice(
					new ElettricWaterOnOff("Dishwasher", 7, new Consume(1.6, 0, 50), house, this, "kitchen")); // 50
																													// litri
			window.addRoomPanel(new RoomPanel(this, kitchen, rn.get(1).getRoomName()));

		default:
			Room tavern = house.getRoom("tavern");
			tavern.addDevice(new ElettricOnOff("Led_Light_1", 29, new Consume(0.055, 0, 0), house, this, "tavern"));
			tavern.addDevice(new ElettricOnOff("Led_Light_1", 30, new Consume(0.065, 0, 0), house, this, "tavern"));
			tavern.addDevice(new ElettricWaterOnOff("Washing_Machine", 32, new Consume(1.8, 0, 70), house, this, "tavern")); // 50
																															// litri
			tavern.addDevice(
					new GasElettricConstant("Water_Heater", 31, new Consume(1.2, 0.65, 0), house, this, "tavern"));
			window.addRoomPanel(new RoomPanel(this, tavern, rn.get(0).getRoomName()));
			if (isSolar) {
				Room Roof = house.getRoom("Roof");
				window.setRoof(new RoomPanel(this, Roof, "Roof"));
			}
			break;
		}
		window.reverse();
		return rn;
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean fieldflag = true;
		if (window.getContentPane() instanceof NoHousePanel) {
			if (e.getSource() == ((NoHousePanel) window.getContentPane()).getNameBtn()) {
				window.setCreateHousePanel();
			}

		} else if (window.getContentPane() instanceof CreateHousePanel) {
			if (e.getSource() == ((CreateHousePanel) window.getContentPane()).getProceedBtn()) {
				int progress = ((CreateHousePanel) window.getContentPane()).getIndexProgressBar();
				window.setCreateContractPanel();
				((CreateContractPanel) window.getContentPane()).setProgressBar(progress);
			} else if (e.getSource() == ((CreateHousePanel) window.getContentPane()).getBackBtn()) {
				window.setNoHousePanel();
				window.getJMenuBar().getMenu(0).hide(); // Nascondo il menu
			}

		} else if (window.getContentPane() instanceof CreateContractPanel) {
			if (e.getSource() == ((CreateContractPanel) window.getContentPane()).getProceedBtn()) {
				// Controlli su tutti i campi dati
				if (((CreateHousePanel) window.getHomePanel()).getHolderName().isBlank()) {
					window.showErrorMessage("The \"Holder name\" field cannot be empty!");
					fieldflag = false;
				} else if (((CreateHousePanel) window.getHomePanel()).getHouseName().isBlank()) {
					window.showErrorMessage("The \"House name\" field cannot be empty!");
					fieldflag = false;
				} else if (((CreateHousePanel) window.getHomePanel()).getRoomsNumber() == 0) {
					window.showErrorMessage("The \"Rooms number\" field cannot be 0!");
					fieldflag = false;
				} else if (((CreateHousePanel) window.getHomePanel()).getRoomsNumber() < 0) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be negative, do you want to make it positive?")) {
						((CreateHousePanel) window.getHomePanel())
								.setRoomsNumber(((CreateHousePanel) window.getHomePanel()).getRoomsNumber() * -1);
						fieldflag = false;

					} else {
						fieldflag = false;
					}
				} else if (((CreateHousePanel) window.getHomePanel()).getRoomsNumber() > 7) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be >7, do you want to set it to 7?")) {
						((CreateHousePanel) window.getHomePanel()).setRoomsNumber(7);
						fieldflag = false;
					} else {
						fieldflag = false;
					}
				} else if (((CreateHousePanel) window.getHomePanel()).wantSolarPanels() == 0) {
					window.showErrorMessage("You have to select one of the two buttons for the solar panels!");
					fieldflag = false;
				} else if (((CreateContractPanel) window.getContentPane()).getContractName().isBlank()) {
					window.showErrorMessage("The \"Contract name\" field cannot be empty!");
					fieldflag = false;
				} else if (((CreateContractPanel) window.getContentPane()).getePrice().isBlank()) {
					window.showErrorMessage("The \"Electricity Price\" field cannot be empty!");
					fieldflag = false;
				} else if (!((CreateContractPanel) window.getContentPane()).getePrice().isBlank()) {
					try {
						if (Float.valueOf(((CreateContractPanel) window.getContentPane()).getePrice()) == 0) {
							window.showErrorMessage("The \"Electricity Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((CreateContractPanel) window.getContentPane()).getePrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Electricity Price\" field cannot be negative, do you want to make it positive?")) {
								((CreateContractPanel) window.getContractPanel()).setePrice(((double) (Float
										.valueOf(((CreateContractPanel) window.getContractPanel()).getePrice()) * -1)));
								fieldflag = false;
								return; // Bruttino //si molto bruttino :(
							} else {
								fieldflag = false;
							}
						}
					} catch (Exception e2) {
						window.showErrorMessage("The \"Electricity Price\" field is not a number!");
						fieldflag = false;
						if (window.showBooleanErrorMessage("Do you think this is a mistake?")) {
							window.showErrorMessage(
									"Remember to use the \".\" instead of the \",\" for decimal numbers!");
						}
						return;
						/**/}
				}
				if (((CreateContractPanel) window.getContentPane()).getgPrice().isBlank()
						&& !(((CreateContractPanel) window.getContentPane()).getePrice().isBlank())
						&& ((Double.valueOf(((CreateContractPanel) window.getContentPane()).getePrice())) > 0)) {
					window.showErrorMessage("The \"Gas Price\" field cannot be empty!");
					fieldflag = false;
				} else if (!((CreateContractPanel) window.getContentPane()).getgPrice().isBlank()) {
					try {
						if (Float.valueOf(((CreateContractPanel) window.getContentPane()).getgPrice()) == 0) {
							window.showErrorMessage("The \"Gas Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((CreateContractPanel) window.getContentPane()).getgPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Gas Price\" field cannot be negative, do you want to make it positive?")) {
								((CreateContractPanel) window.getContractPanel()).setgPrice(((double) (Float
										.valueOf(((CreateContractPanel) window.getContractPanel()).getgPrice()) * -1)));
								fieldflag = false;
							} else {
								fieldflag = false;
							}
						}
					} catch (Exception e2) {
						if (!((CreateContractPanel) window.getContentPane()).getgPrice().isBlank()) {
							window.showErrorMessage("The \"Gas Price\" field is not a number!");
							fieldflag = false;
							if (window.showBooleanErrorMessage("Do you think this is a mistake?")) {
								window.showErrorMessage(
										"Remember to use the \".\" instead of the \",\" for decimal numbers!");
							}
						}
						return;
					}
				}
				if (((CreateContractPanel) window.getContentPane()).getwPrice().isBlank()
						&& !(((CreateContractPanel) window.getContentPane()).getgPrice().isBlank())
						&& ((Double.valueOf(((CreateContractPanel) window.getContentPane()).getgPrice())) > 0)) {
					window.showErrorMessage("The \"Water Price\" field cannot be empty!");
					fieldflag = false;
				} else {
					try {
						if (Float.valueOf(((CreateContractPanel) window.getContentPane()).getwPrice()) == 0) {
							window.showErrorMessage("The \"Water Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((CreateContractPanel) window.getContentPane()).getwPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Water Price\" field cannot be negative, do you want to make it positive?")) {
								((CreateContractPanel) window.getContractPanel()).setwPrice(((double) (Float
										.valueOf(((CreateContractPanel) window.getContractPanel()).getwPrice()) * -1)));
								fieldflag = false;
							}
							return;
						}
					} catch (Exception e21) {
						if (!((CreateContractPanel) window.getContentPane()).getwPrice().isBlank()) {
							window.showErrorMessage("The \"Water Price\" field is not a number!");
							fieldflag = false;
							if (window.showBooleanErrorMessage("Do you think this is a mistake?")) {
								window.showErrorMessage(
										"Remember to use the \".\" instead of the \",\" for decimal numbers!");
							}
							return;
						}
					}

					// Fine Controlli su tutti i campi dati, si pu� creare la casa adesso
					if (fieldflag) {
						rooms = generateHouse((window.getHomePanel()).getRoomsNumber(),
								(((CreateHousePanel) window.getHomePanel()).wantSolarPanels() == 1),
								(((CreateHousePanel) window.getHomePanel()).wantSolarPanels() == 1)
										? (window.showBooleanErrorMessage(""
												+ "Have you chosen to use the panels, \nthe base power is 3kw, do you want to have 6kw?\n"
												+ "")
														? 6
														: 3)
										: 0,
									Double.parseDouble(((CreateContractPanel) window.getContractPanel()).getePrice()),
									Double.parseDouble(((CreateContractPanel) window.getContractPanel()).getgPrice()),
									Double.parseDouble(((CreateContractPanel) window.getContractPanel()).getwPrice())
									);
						Collections.reverse(rooms);
						roomsReversed = rooms;
						Collections.reverse(rooms);
						String holderName = (window.getHomePanel()).getHolderName();
						String houseName = (window.getHomePanel()).getHouseName();
						window.setHousePanel();
						((HousePanel) window.getContentPane()).initializePanel(rooms, houseName, holderName);
					}
				}
			} else if (e.getSource() == ((CreateContractPanel) window.getContentPane()).getBackBtn()) {
				int progress = ((CreateContractPanel) window.getContentPane()).getIndexProgressBar();
				window.setCreateHousePanel();
				((CreateHousePanel) window.getContentPane()).setProgressBar(progress);
			}
		}
		if (window.getContentPane() instanceof RoomPanel) {
			if (e.getSource() == ((RoomPanel) window.getContentPane()).getBackBtn()) {
				window.setHousePanel();
				roomsFlag=false;
			}else if(e.getSource()==((RoomPanel) window.getContentPane()).getViewthingsbtn()) {
				roomsFlag=!roomsFlag;
			}
		}else if(window.getContentPane() instanceof HousePanel) {
			if(e.getSource()==((HousePanel) window.getContentPane()).getViewthingsbtn()) {
				houseFlag=!houseFlag;
			}
		}
	}

	/**
	 * apre il pannello della stanza selezionata dalla lista.
	 *
	 * @param e the e
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (window.getContentPane() instanceof HousePanel) {
			if (!(((HousePanel) window.getContentPane()).getList().getSelectedIndex() == -1)) {
				if (((HousePanel) window.getContentPane()).getList().getSelectedValue().equals(rooms.get(0)) == true) {
					// Taverna
					System.out.println("Taverna");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(0);
				} else if (((String) ((HousePanel) window.getContentPane()).getList().getSelectedValue().toString())
						.contains("Roof")) {
					// Roof
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoofPanel();
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(1)) == true) {
					// Cucina
					System.out.println("Cucina");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(1);
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(2)) == true) {
					// Bagno 1
					System.out.println("Bagno 1");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(2);
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(3)) == true) {
					// Soggiorno
					System.out.println("Soggiorno");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(3);
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(4)) == true) {
					// Camera 1
					System.out.println("Camera 1");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(4);
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(5)) == true) {
					// Bagno 2
					System.out.println("Bagno 2");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(5);
				} else if (((HousePanel) window.getContentPane()).getList().getSelectedValue()
						.equals(rooms.get(6)) == true) {
					// Camera 2
					System.out.println("Camera 2");
					((HousePanel) window.getContentPane()).getList().clearSelection();
					window.setRoomPanel(6);
				} else {
					throw new IllegalStateException("Selection error");
				}
			}
		} else if (window.getContentPane() instanceof RoomPanel) {
			ArrayList<Device> list = ((RoomPanel) window.getContentPane()).getRoom().getDevices();
			if ((((RoomPanel) window.getContentPane()).getList().getSelectedIndex() != -1)) {
				if ((list.get(
						((RoomPanel) window.getContentPane()).getList().getSelectedIndex()) instanceof ElettricOnOff
						|| list.get(
								((RoomPanel) window.getContentPane()).getList().getSelectedIndex()) instanceof GasOnOff
						|| list.get(((RoomPanel) window.getContentPane()).getList()
								.getSelectedIndex()) instanceof WaterOnOff
						|| list.get(((RoomPanel) window.getContentPane()).getList()
								.getSelectedIndex()) instanceof ElettricWaterOnOff)) {
					list.get(((RoomPanel) window.getContentPane()).getList().getSelectedIndex()).toggle();
					((RoomPanel) window.getContentPane()).getList().clearSelection();
				}
			}
		}
	}

	
	/**
	 * Update time. aggiorna il timer e calcola le ore e i minuti.
	 * 	Questo metodo viene aggiornato nei thread dei dispositivi
	 * costant perch� quei dispositivi ci sono sempre durante l'esecuzione del
	 * programma
	 *
	 * @param time the time
	 * @param hourt the hourt
	 */
	public void updateTime(int time, int hourt) {
		int hour = time / hourt;
		int minutes = time % hourt;
		window.getTime().setText("Time: " + "Hours: " + hour + " Minutes: " + minutes + "");
	}

	/**
	 * Update consumption. Questo metodo viene aggiornato nei thread dei dispositivi
	 * costant perch� quei dispositivi ci sono sempre durante l'esecuzione del
	 * programma e aggiorna i consumi nelle stanze a nella casa
	 *
	 * @param s the s
	 */
	public void updateConsumption(String s) {
		if (window.getContentPane() instanceof HousePanel) {
//			System.out.println(house.getDailyConsumption());
			((HousePanel) window.getContentPane()).getMoneyLabel().setText(house.calculateMoney());
			if(houseFlag) {
				((HousePanel) window.getContentPane()).getConsumptionLabel().setText(house.getPresentConsumption());
			}else {				
				((HousePanel) window.getContentPane()).getConsumptionLabel().setText(house.getDailyConsumption());
			}
		}else if(window.getContentPane() instanceof RoomPanel) {
			ArrayList<RoomPanel> arr = (window.getRoomPanels());
			if(roomsFlag) {				
				arr.forEach((x)->{
					if(x.getRoom().getDevices().get(0) instanceof SolarPannels) {
						x.getViewthingsbtn().hide();
					}
					x.getViewthingsbtn().setText("VIEW DAILY CONSUMPTION");
					x.getConsumptionLabel().setText(x.getRoom().getPresentConsumption());
					
				});
			}else {	
				arr.forEach((x)->{
					x.getViewthingsbtn().setText("VIEW PRESENT CONSUMPTION");
					x.getConsumptionLabel().setText(x.getRoom().getDailyConsumption());
				});
			}
		}
	}
	
	/**
	 * aggiorna i label con il profitto, viene aggiornato nei dispositivi constant.
	 */
	public void updateProfit() {
		if (window.getContentPane() instanceof HousePanel) {
//			System.out.println(house.getDailyConsumption());
			((HousePanel) window.getContentPane()).getProfitLabel().setText(house.calculateGains());
		}
	}
	
	/**
	 * aggiorna il label con la bolletta totale, viene aggiornato nei dispositivi constant.
	 */
	public void updateBill() {
		if (window.getContentPane() instanceof HousePanel) {
//			System.out.println(house.getDailyConsumption());
			((HousePanel) window.getContentPane()).getBillLabel().setText(house.calculateBill());
		}
	}
}

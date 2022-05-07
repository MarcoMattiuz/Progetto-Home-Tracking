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
import model.Home;
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
	private Home house;

	/** The window. */
	private Window window;

	/** The rooms names. */
	private ArrayList<Room> rooms;

	/** The rooms names reversed. */
	private ArrayList<Room> roomsReversed;

	/**
	 * Instantiates a new controller.
	 *
	 * @param h the h
	 */
	public Controller(Home h) {
		this.house = h;
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
	 * Generate house. genera la casa istanzia le stanze e i dispositivi
	 *
	 * @param numRooms the num rooms
	 * @param isSolar  the is solar
	 * @param solar    the solar
	 * @return the array list
	 */
	public ArrayList<Room> generateHouse(int numRooms, boolean isSolar, int solar) {
		ArrayList<Room> rn = house.generateRooms(numRooms, isSolar);
		// solar ï¿½ la potenza dell'impianto e viene messa come -consumo nei pannelli
		if (isSolar) {
			Room roof = house.getRoom("roof");
			roof.addDevice(new SolarPannels("pannelli-solari", 01, new Consume(solar, 0, 0), house, this, "roof"));
		}
		Collections.reverse(rn);
		window.initializeMenuItems(numRooms, rn, isSolar);
		switch (numRooms) {
		case 7:
			Room camera2 = house.getRoom("camera-2");
			camera2.addDevice(new ElettricOnOff("lampadaLED-3", 21, new Consume(0.007, 0, 0), house, this, "camera-2"));
			camera2.addDevice(new ElettricOnOff("lampadaLED-4", 22, new Consume(0.007, 0, 0), house, this, "camera-2"));
			camera2.addDevice(
					new ElettricOnOff("computerfisso-2", 23, new Consume(1.1, 0, 0), house, this, "camera-2"));
			window.addRoomPanel(new RoomPanel(this, camera2, rn.get(6).getRoomName()));
		case 6:
			Room bagno2 = house.getRoom("bagno-2");
			bagno2.addDevice(new WaterOnOff("lavandino", 13, new Consume(0, 0, 320), house, this, "bagno-2"));
			bagno2.addDevice(new WaterOnOff("doccia", 14, new Consume(0, 0, 520), house, this, "bagno-2"));
			bagno2.addDevice(new ElettricOnOff("luce-5", 15, new Consume(0.056, 0, 0), house, this, "bagno-2"));
			bagno2.addDevice(new ElettricOnOff("luce-6", 16, new Consume(0.067, 0, 0), house, this, "bagno-2"));
			window.addRoomPanel(new RoomPanel(this, bagno2, rn.get(5).getRoomName()));
		case 5:
			Room camera1 = house.getRoom("camera-1");
			camera1.addDevice(new ElettricOnOff("lampadaLED-1", 17, new Consume(0.006, 0, 0), house, this, "camera-1"));
			camera1.addDevice(new ElettricOnOff("lampadaLED-2", 18, new Consume(0.008, 0, 0), house, this, "camera-1"));
			camera1.addDevice(
					new ElettricOnOff("computerfisso-1", 19, new Consume(0.9, 0, 0), house, this, "camera-1"));
			camera1.addDevice(new ElettricOnOff("tvLED-1", 20, new Consume(0.3, 0, 0), house, this, "camera-1"));
			window.addRoomPanel(new RoomPanel(this, camera1, rn.get(4).getRoomName()));
		case 4:
			Room soggiorno = house.getRoom("soggiorno");
			soggiorno.addDevice(new ElettricOnOff("luceLED-7", 24, new Consume(0.007, 0, 0), house, this, "soggiorno"));
			soggiorno.addDevice(new ElettricOnOff("luceLED-8", 25, new Consume(0.005, 0, 0), house, this, "soggiorno"));
			soggiorno.addDevice(new ElettricOnOff("luceLED-9", 26, new Consume(0.004, 0, 0), house, this, "soggiorno"));
			soggiorno.addDevice(new ElettricOnOff("tvOLED-2", 27, new Consume(0.15, 0, 0), house, this, "soggiorno"));
			soggiorno.addDevice(
					new ElettricOnOff("condizionatore", 28, new Consume(0.8, 0, 0), house, this, "soggiorno"));
			window.addRoomPanel(new RoomPanel(this, soggiorno, rn.get(3).getRoomName()));
		case 3:
			Room bagno1 = house.getRoom("bagno-1");
			bagno1.addDevice(new WaterOnOff("lavandino", 8, new Consume(0, 0, 350), house, this, "bagno-1"));
			bagno1.addDevice(new WaterOnOff("doccia", 9, new Consume(0, 0, 480), house, this, "bagno-1"));
			bagno1.addDevice(new ElettricOnOff("luceLED-3", 10, new Consume(0.004, 0, 0), house, this, "bagno-1"));
			bagno1.addDevice(new ElettricOnOff("luceLED-4", 11, new Consume(0.005, 0, 0), house, this, "bagno-1"));
			bagno1.addDevice(new ElettricOnOff("stufetta", 12, new Consume(2.3, 0, 0), house, this, "bagno-1"));
			window.addRoomPanel(new RoomPanel(this, bagno1, rn.get(2).getRoomName()));
		case 2:
			Room cucina = house.getRoom("cucina");
			cucina.addDevice(new ElettricOnOff("forno", 1, new Consume(1.4, 0, 0), house, this, "cucina"));
			cucina.addDevice(new ElettricConstant("frigo", 2, new Consume(1, 0, 0), house, this, "cucina"));
			cucina.addDevice(new ElettricOnOff("luceLED-1", 3, new Consume(0.005, 0, 0), house, this, "cucina"));
			cucina.addDevice(new ElettricOnOff("luceLED-2", 4, new Consume(0.004, 0, 0), house, this, "cucina"));
			cucina.addDevice(new ElettricOnOff("tostapane", 5, new Consume(0.5, 0, 0), house, this, "cucina"));
			cucina.addDevice(new WaterOnOff("lavabo", 6, new Consume(0, 0, 400), house, this, "cucina")); // 400 litri
																											// all'ora
			cucina.addDevice(
					new ElettricWaterOnOff("lavastoviglie", 7, new Consume(1.6, 0, 50), house, this, "cucina")); // 50
																													// litri
			window.addRoomPanel(new RoomPanel(this, cucina, rn.get(1).getRoomName()));

		default:
			Room taverna = house.getRoom("taverna");
			taverna.addDevice(new ElettricOnOff("luce-10", 29, new Consume(0.055, 0, 0), house, this, "taverna"));
			taverna.addDevice(new ElettricOnOff("luce-11", 30, new Consume(0.065, 0, 0), house, this, "taverna"));
			taverna.addDevice(new ElettricWaterOnOff("lavatrice", 32, new Consume(1.8, 0, 70), house, this, "taverna")); // 50
																															// litri
			taverna.addDevice(
					new GasElettricConstant("caldaia", 31, new Consume(1.2, 0.65, 0), house, this, "taverna"));
			window.addRoomPanel(new RoomPanel(this, taverna, rn.get(0).getRoomName()));
			if (isSolar) {
				Room roof = house.getRoom("roof");
				window.setRoof(new RoomPanel(this, roof, "Roof"));
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
				window.setHomePanel();
			}

		} else if (window.getContentPane() instanceof HomePanel) {
			if (e.getSource() == ((HomePanel) window.getContentPane()).getProceedBtn()) {
				int progress = ((HomePanel) window.getContentPane()).getIndexProgressBar();
				window.setContractPanel();
				((ContractPanel) window.getContentPane()).setProgressBar(progress);
			} else if (e.getSource() == ((HomePanel) window.getContentPane()).getBackBtn()) {
				window.setNoHousePanel();
				window.getJMenuBar().getMenu(0).hide(); // Nascondo il menu
			}

		} else if (window.getContentPane() instanceof ContractPanel) {
			if (e.getSource() == ((ContractPanel) window.getContentPane()).getProceedBtn()) {
				// Controlli su tutti i campi dati
				if (((HomePanel) window.getHomePanel()).getHolderName().isBlank()) {
					window.showErrorMessage("The \"Holder name\" field cannot be empty!");
					fieldflag = false;
				} else if (((HomePanel) window.getHomePanel()).getHouseName().isBlank()) {
					window.showErrorMessage("The \"House name\" field cannot be empty!");
					fieldflag = false;
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() == 0) {
					window.showErrorMessage("The \"Rooms number\" field cannot be 0!");
					fieldflag = false;
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() < 0) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be negative, do you want to make it positive?")) {
						((HomePanel) window.getHomePanel())
								.setRoomsNumber(((HomePanel) window.getHomePanel()).getRoomsNumber() * -1);
						fieldflag = false;

					} else {
						fieldflag = false;
					}
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() > 7) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be >7, do you want to set it to 7?")) {
						((HomePanel) window.getHomePanel()).setRoomsNumber(7);
						fieldflag = false;
					} else {
						fieldflag = false;
					}
				} else if (((HomePanel) window.getHomePanel()).wantSolarPanels() == 0) {
					window.showErrorMessage("You have to select one of the two buttons for the solar panels!");
					fieldflag = false;
				} else if (((ContractPanel) window.getContentPane()).getContractName().isBlank()) {
					window.showErrorMessage("The \"Contract name\" field cannot be empty!");
					fieldflag = false;
				} else if (((ContractPanel) window.getContentPane()).getePrice().isBlank()) {
					window.showErrorMessage("The \"Electricity Price\" field cannot be empty!");
					fieldflag = false;
				} else if (!((ContractPanel) window.getContentPane()).getePrice().isBlank()) {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getePrice()) == 0) {
							window.showErrorMessage("The \"Electricity Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getePrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Electricity Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setePrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getePrice()) * -1)));
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
				if (((ContractPanel) window.getContentPane()).getgPrice().isBlank()
						&& !(((ContractPanel) window.getContentPane()).getePrice().isBlank())
						&& ((Double.valueOf(((ContractPanel) window.getContentPane()).getePrice())) > 0)) {
					window.showErrorMessage("The \"Gas Price\" field cannot be empty!");
					fieldflag = false;
				} else if (!((ContractPanel) window.getContentPane()).getgPrice().isBlank()) {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice()) == 0) {
							window.showErrorMessage("The \"Gas Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Gas Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setgPrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getgPrice()) * -1)));
								fieldflag = false;
							} else {
								fieldflag = false;
							}
						}
					} catch (Exception e2) {
						if (!((ContractPanel) window.getContentPane()).getgPrice().isBlank()) {
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
				if (((ContractPanel) window.getContentPane()).getwPrice().isBlank()
						&& !(((ContractPanel) window.getContentPane()).getgPrice().isBlank())
						&& ((Double.valueOf(((ContractPanel) window.getContentPane()).getgPrice())) > 0)) {
					window.showErrorMessage("The \"Water Price\" field cannot be empty!");
					fieldflag = false;
				} else {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice()) == 0) {
							window.showErrorMessage("The \"Water Price\" cannot be 0!");
							fieldflag = false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Water Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setwPrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getwPrice()) * -1)));
								fieldflag = false;
							}
							return;
						}
					} catch (Exception e21) {
						if (!((ContractPanel) window.getContentPane()).getwPrice().isBlank()) {
							window.showErrorMessage("The \"Water Price\" field is not a number!");
							fieldflag = false;
							if (window.showBooleanErrorMessage("Do you think this is a mistake?")) {
								window.showErrorMessage(
										"Remember to use the \".\" instead of the \",\" for decimal numbers!");
							}
							return;
						}
					}

					// Fine Controlli su tutti i campi dati, si puï¿½ creare la casa adesso
					if (fieldflag) {
						rooms = generateHouse((window.getHomePanel()).getRoomsNumber(),
								(((HomePanel) window.getHomePanel()).wantSolarPanels() == 1),
								(((HomePanel) window.getHomePanel()).wantSolarPanels() == 1)
										? (window.showBooleanErrorMessage(""
												+ "Hai scelto di utilizzare i pannelli,\nla potenza base è di 3kw, desideri avere 6 kw?")
														? 6
														: 3)
										: 0);
						Collections.reverse(rooms);
						roomsReversed = rooms;
						Collections.reverse(rooms);
						String holderName = (window.getHomePanel()).getHolderName();
						String houseName = (window.getHomePanel()).getHouseName();
						window.setHousePanel();
						((HousePanel) window.getContentPane()).initializePanel(rooms, houseName, holderName);
					}
				}
			} else if (e.getSource() == ((ContractPanel) window.getContentPane()).getBackBtn()) {
				int progress = ((ContractPanel) window.getContentPane()).getIndexProgressBar();
				window.setHomePanel();
				((HomePanel) window.getContentPane()).setProgressBar(progress);
			}
		}
		if (window.getContentPane() instanceof RoomPanel) {
			if (e.getSource() == ((RoomPanel) window.getContentPane()).getBackBtn()) {
				window.setHousePanel();
			}
		}
	}

	/**
	 * Value changed.
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
						.contains("roof")) {
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

	public void updateTime(int time) {
		int hour = time / 60;
		int minutes = time % 60;
		window.getTime().setText("Time: " + "-hours: " + hour + " minutes: " + minutes + "-");
	}

	/**
	 * Update consumption. Questo metodo viene aggiornato nei thread dei dispositivi
	 * costant perchè quei dispositivi ci sono sempre durante l'esecuzione del
	 * programma
	 *
	 * @param s the s
	 */
	public void updateConsumption(String s) {
		if (window.getContentPane() instanceof HousePanel) {
//			System.out.println(house.getDailyConsumption());
			((HousePanel) window.getContentPane()).getConsumptionLabel().setText(house.getDailyConsumption());
		}
		if (window.getContentPane() instanceof RoomPanel) {
			ArrayList<RoomPanel> arr = (window.getRoomPanels());
			arr.forEach((x) -> {
				x.getConsumptionLabel().setText(x.getRoom().getDailyConsumption());
			});

		}

	}
}

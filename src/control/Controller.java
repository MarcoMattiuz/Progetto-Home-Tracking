package control;

import java.util.concurrent.Semaphore;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Consume;
import model.Home;
import model.Room;
import view.*;

public class Controller extends Thread implements ActionListener, AncestorListener {

	private Home house;
	private Window window;
	private Semaphore ligthSem; ////////////////
	private Semaphore fridgeSem;

	public Controller(Home h) {
		this.house = h;
	}

	public void setWindow(Window win) {
		this.window = win;
	}

	public void generateHouse(int numRooms) {
		house.generateRooms(numRooms);
		window.initializeMenuItems(numRooms);
		switch (numRooms) {
		case 7:
			Room camera2 = house.getRoom("camera-2");
			camera2.addDevice(new ElettricOnOff("lampadaLED-3", 21, new Consume(0.007, 0, 0), house));
			camera2.addDevice(new ElettricOnOff("lampadaLED-4", 22, new Consume(0.007, 0, 0), house));
			camera2.addDevice(new ElettricOnOff("computerfisso-2", 23, new Consume(1.1, 0, 0), house));
		
		case 6:
			Room bagno2 = house.getRoom("bagno-2");
			bagno2.addDevice(new WaterOnOff("lavandino", 13, new Consume(0, 0, 320), house));
			bagno2.addDevice(new WaterOnOff("doccia", 14, new Consume(0, 0, 520), house));
			bagno2.addDevice(new ElettricOnOff("luce-5", 15, new Consume(0.056, 0, 0), house));
			bagno2.addDevice(new ElettricOnOff("luce-6", 16, new Consume(0.067, 0, 0), house));
		case 5:
			Room camera1 = house.getRoom("camera-1");
			camera1.addDevice(new ElettricOnOff("lampadaLED-1", 17, new Consume(0.006, 0, 0), house));
			camera1.addDevice(new ElettricOnOff("lampadaLED-2", 18, new Consume(0.008, 0, 0), house));
			camera1.addDevice(new ElettricOnOff("computerfisso-1", 19, new Consume(0.9, 0, 0), house));
			camera1.addDevice(new ElettricOnOff("tvLED-1", 20, new Consume(0.3, 0, 0), house));
		case 4:
			Room soggiorno = house.getRoom("soggiorno");
			soggiorno.addDevice(new ElettricOnOff("luceLED-7", 24, new Consume(0.007, 0, 0), house));
			soggiorno.addDevice(new ElettricOnOff("luceLED-8", 25, new Consume(0.005, 0, 0), house));
			soggiorno.addDevice(new ElettricOnOff("luceLED-9", 26, new Consume(0.004, 0, 0), house));
			soggiorno.addDevice(new ElettricOnOff("tvOLED-2", 27, new Consume(0.15, 0, 0), house));
			soggiorno.addDevice(new ElettricOnOff("condizionatore", 28, new Consume(0.8, 0, 0), house));
		case 3:
			Room bagno1 = house.getRoom("bagno-1");
			bagno1.addDevice(new WaterOnOff("lavandino", 8, new Consume(0, 0, 350), house));
			bagno1.addDevice(new WaterOnOff("doccia", 9, new Consume(0, 0, 480), house));
			bagno1.addDevice(new ElettricOnOff("luceLED-3", 10, new Consume(0.004, 0, 0), house));
			bagno1.addDevice(new ElettricOnOff("luceLED-4", 11, new Consume(0.005, 0, 0), house));
			bagno1.addDevice(new ElettricOnOff("stufetta", 12, new Consume(2.3, 0, 0), house));
		case 2:
			Room cucina = house.getRoom("cucina");
			cucina.addDevice(new ElettricOnOff("forno", 1, new Consume(1.4, 0, 0), house));
			cucina.addDevice(new ElettricConstant("frigo", 2, new Consume(1, 0, 0), house));
			cucina.addDevice(new ElettricOnOff("luceLED-1", 3, new Consume(0.005, 0, 0), house));
			cucina.addDevice(new ElettricOnOff("luceLED-2", 4, new Consume(0.004, 0, 0), house));
			cucina.addDevice(new ElettricOnOff("tostapane", 5, new Consume(0.5, 0, 0), house));
			cucina.addDevice(new WaterOnOff("lavabo", 6, new Consume(0, 0, 400), house)); // 400 litri all'ora
			cucina.addDevice(new ElettricWaterOnOff("lavastoviglie", 7, new Consume(1.6, 0, 50), house)); // 50 litri
		default:
			Room taverna = house.getRoom("taverna");
			taverna.addDevice(new ElettricOnOff("luce-10", 29, new Consume(0.055, 0, 0), house));
			taverna.addDevice(new ElettricOnOff("luce-11", 30, new Consume(0.065, 0, 0), house));
			taverna.addDevice(new GasElettricConstant("caldaia", 31, new Consume(1.2, 0.65, 0), house));
			break;
		}
	}

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
					fieldflag=false;
				} else if (((HomePanel) window.getHomePanel()).getHouseName().compareTo("") == 0
						|| ((HomePanel) window.getHomePanel()).getHouseName().compareTo(" ") == 0) {
					window.showErrorMessage("The \"House name\" field cannot be empty!");
					fieldflag=false;
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() == 0) {
					window.showErrorMessage("The \"Rooms number\" field cannot be 0!");
					fieldflag=false;
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() < 0) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be negative, do you want to make it positive?")) {
						((HomePanel) window.getHomePanel())
								.setRoomsNumber(((HomePanel) window.getHomePanel()).getRoomsNumber() * -1);
						fieldflag=false;
						

					}else {
						fieldflag=false;
					}
				} else if (((HomePanel) window.getHomePanel()).getRoomsNumber() > 7) {
					if (window.showBooleanErrorMessage(
							"The \"Rooms number\" field cannot be >7, do you want to set it to 7?")) {
						((HomePanel) window.getHomePanel())
								.setRoomsNumber(7);
						fieldflag=false;
					}else {
						fieldflag=false;
					}
				} else if (((HomePanel) window.getHomePanel()).wantSolarPanels() == 0) {
					window.showErrorMessage("You have to select one of the two buttons for the solar panels!");
					fieldflag=false;
				} else if (((ContractPanel) window.getContentPane()).getContractName().isBlank()) {
					window.showErrorMessage("The \"Contract name\" field cannot be empty!");
					fieldflag=false;
				} else if (((ContractPanel) window.getContentPane()).getePrice().isBlank()) {
					window.showErrorMessage("The \"Electricity Price\" field cannot be empty!");
					fieldflag=false;
				} else if (!((ContractPanel) window.getContentPane()).getePrice().isBlank()) {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getePrice()) == 0) {
							window.showErrorMessage("The \"Electricity Price\" cannot be 0!");
							fieldflag=false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getePrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Electricity Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setePrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getePrice()) * -1)));
								fieldflag=false;
								return; // Bruttino 
							}else {
								fieldflag=false;
							}
						}
					} catch (Exception e2) {
						window.showErrorMessage("The \"Electricity Price\" field is not a number!");
						fieldflag=false;
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
					fieldflag=false;
				} else if (!((ContractPanel) window.getContentPane()).getgPrice().isBlank()) {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice()) == 0) {
							window.showErrorMessage("The \"Gas Price\" cannot be 0!");
							fieldflag=false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Gas Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setgPrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getgPrice()) * -1)));
								fieldflag=false;
							}else {
								fieldflag=false;
							}
						}
					} catch (Exception e2) {
						if (!((ContractPanel) window.getContentPane()).getgPrice().isBlank()) {
							window.showErrorMessage("The \"Gas Price\" field is not a number!");
							fieldflag=false;
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
					fieldflag=false;
				} else {
					try {
						if (Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice()) == 0) {
							window.showErrorMessage("The \"Water Price\" cannot be 0!");
							fieldflag=false;
						} else if ((Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice()) < 0)) {
							if (window.showBooleanErrorMessage(
									"The \"Water Price\" field cannot be negative, do you want to make it positive?")) {
								((ContractPanel) window.getContractPanel()).setwPrice(((double) (Float
										.valueOf(((ContractPanel) window.getContractPanel()).getwPrice()) * -1)));
								fieldflag=false;
							}
							return;
						}
					} catch (Exception e21) {
						if (!((ContractPanel) window.getContentPane()).getwPrice().isBlank()) {
							window.showErrorMessage("The \"Water Price\" field is not a number!");
							fieldflag=false;
							if (window.showBooleanErrorMessage("Do you think this is a mistake?")) {
								window.showErrorMessage(
										"Remember to use the \".\" instead of the \",\" for decimal numbers!");
							}
							return;
						}
					}
		
			// Fine Controlli su tutti i campi dati, si pu� creare la casa adesso
					if(fieldflag) { 
						generateHouse(((HomePanel) window.getHomePanel()).getRoomsNumber());
						window.setHousePanel();
					}
				}
		}else if (e.getSource() == ((ContractPanel) window.getContentPane()).getBackBtn()) {
				int progress = ((ContractPanel) window.getContentPane()).getIndexProgressBar();
				window.setHomePanel();
				((HomePanel) window.getContentPane()).setProgressBar(progress);
			}
		}
		
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}
}

package control;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Consume;
import model.Contract;
import model.Home;
import model.Room;
import view.Main_Panel;
import view.*;

public class Controller extends Thread implements ActionListener {

	private Home home;
	private Window window;
	private Semaphore ligthSem; ////////////////
	private Semaphore fridgeSem;

	public Controller(Home home) {
		this.home = home;
		
//		this.ligthSem = new Semaphore(1);
//		this.fridgeSem = new Semaphore(1);
//		home.addRoom("1", new Room("soggiorno"));
//		home.getRoom("1").addDevice(new Ligths("luce", 1, new Consume(0.1, 0, 0, home.getContract()), home, ligthSem));
//		home.getRoom("1")
//				.addDevice(new Fridges("frigo", 2, new Consume(0.4, 0, 0, home.getContract()), home, fridgeSem));
	}
	
	public void setWindow(Window win) {
		this.window = win;
	}
	
	private void generateHouse() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(window.getContentPane() instanceof NoHousePanel) {
			if(e.getSource()==((NoHousePanel) window.getContentPane()).getNameBtn()) {
				window.setHomePanel();
			}
		
			
		}else if(window.getContentPane() instanceof HomePanel) {
			if(e.getSource()==((HomePanel) window.getContentPane()).getProceedBtn()) {
				int progress = ((HomePanel) window.getContentPane()).getIndexProgressBar();
				window.setContractPanel();
				((ContractPanel) window.getContentPane()).setProgressBar(progress);
			}else if(e.getSource()==((HomePanel) window.getContentPane()).getBackBtn()) {
				window.setNoHousePanel();
				window.getJMenuBar().getMenu(0).hide();	// Nascondo il menu
			}	 
		
			
		}else if(window.getContentPane() instanceof ContractPanel) {
			if(e.getSource()==((ContractPanel) window.getContentPane()).getProceedBtn()) {
				// Controlli su tutti i campi dati
				if(((HomePanel) window.getHomePanel()).getHolderName().isBlank()){
					window.showErrorMessage("The \"Holder name\" field cannot be empty!");
				}else if(((HomePanel) window.getHomePanel()).getHouseName().compareTo("")==0||((HomePanel) window.getHomePanel()).getHouseName().compareTo(" ")==0){
					window.showErrorMessage("The \"House name\" field cannot be empty!");
				}else if(((HomePanel) window.getHomePanel()).getRoomsNumber()==0) {
					window.showErrorMessage("The \"Rooms number\" field cannot be 0!");
				}else if(((HomePanel) window.getHomePanel()).getRoomsNumber()<0){
					if(window.showBooleanErrorMessage("The \"Rooms number\" field cannot be negative, do you want to make it positive?")){
						((HomePanel) window.getHomePanel()).setRoomsNumber(((HomePanel) window.getHomePanel()).getRoomsNumber()*-1);
	
					}
				}else if(((HomePanel) window.getHomePanel()).wantSolarPanels()==0){
					window.showErrorMessage("You have to select one of the two buttons for the solar panels!");
				}else if(((ContractPanel) window.getContentPane()).getContractName().isBlank()){
					window.showErrorMessage("The \"Contract name\" field cannot be empty!");
				}else if(((ContractPanel) window.getContentPane()).getePrice().isBlank()) {
					window.showErrorMessage("The \"Electricity Price\" field cannot be empty!");
				}else if(!((ContractPanel) window.getContentPane()).getePrice().isBlank()){
					try {
					if(Float.valueOf(((ContractPanel) window.getContentPane()).getePrice())==0) {
						window.showErrorMessage("The \"Electricity Price\" cannot be 0!");
					}else if((Float.valueOf(((ContractPanel) window.getContentPane()).getePrice())<0)) {
						if(window.showBooleanErrorMessage("The \"Electricity Price\" field cannot be negative, do you want to make it positive?")){
							((ContractPanel) window.getContractPanel()).setePrice(((double) (Float.valueOf(((ContractPanel) window.getContractPanel()).getePrice())*-1)));
							return;
						}
					}
				}catch(Exception e2){
					window.showErrorMessage("The \"Electricity Price\" field is not a number!");
					if(window.showBooleanErrorMessage("Do you think this is a mistake?")) {
						window.showErrorMessage("Remember to use the \".\" instead of the \",\" for decimal numbers!");
					}
					return;
			/**/}
			}
			if(((ContractPanel) window.getContentPane()).getgPrice().isBlank()&&!(((ContractPanel) window.getContentPane()).getePrice().isBlank())&&((Double.valueOf(((ContractPanel) window.getContentPane()).getePrice()))>0)) {
					window.showErrorMessage("The \"Gas Price\" field cannot be empty!");
			}else if(!((ContractPanel) window.getContentPane()).getgPrice().isBlank()){
			try {
				if(Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice())==0) {
					window.showErrorMessage("The \"Gas Price\" cannot be 0!");
				}else if((Float.valueOf(((ContractPanel) window.getContentPane()).getgPrice())<0)) {
					if(window.showBooleanErrorMessage("The \"Gas Price\" field cannot be negative, do you want to make it positive?")){
						((ContractPanel) window.getContractPanel()).setgPrice(((double) (Float.valueOf(((ContractPanel) window.getContractPanel()).getgPrice())*-1)));
					}
				}
			}catch(Exception e2) {
				if(!((ContractPanel) window.getContentPane()).getgPrice().isBlank()){
					window.showErrorMessage("The \"Gas Price\" field is not a number!");
					if(window.showBooleanErrorMessage("Do you think this is a mistake?")) {
						window.showErrorMessage("Remember to use the \".\" instead of the \",\" for decimal numbers!");
					}
				}
				return;
			}
			}
			if(((ContractPanel) window.getContentPane()).getwPrice().isBlank()&&!(((ContractPanel) window.getContentPane()).getgPrice().isBlank())&&((Double.valueOf(((ContractPanel) window.getContentPane()).getgPrice()))>0)) {
						window.showErrorMessage("The \"Water Price\" field cannot be empty!");
			}else {
				try {
					if(Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice())==0) {
					window.showErrorMessage("The \"Water Price\" cannot be 0!");
				}else if((Float.valueOf(((ContractPanel) window.getContentPane()).getwPrice())<0)) {
					if(window.showBooleanErrorMessage("The \"Water Price\" field cannot be negative, do you want to make it positive?")){
						((ContractPanel) window.getContractPanel()).setwPrice(((double) (Float.valueOf(((ContractPanel) window.getContractPanel()).getwPrice())*-1)));
					}
					return;
				}	
			}catch(Exception e21) {
					if(!((ContractPanel) window.getContentPane()).getwPrice().isBlank()){
						window.showErrorMessage("The \"Water Price\" field is not a number!");
						if(window.showBooleanErrorMessage("Do you think this is a mistake?")) {
							window.showErrorMessage("Remember to use the \".\" instead of the \",\" for decimal numbers!");
						}
				}
			}
			}
	}
				// Fine Controlli su tutti i campi dati, si può creare la casa adesso
//				window.setContentPane(null);
		else if(e.getSource()==((ContractPanel) window.getContentPane()).getBackBtn()) {
				int progress = ((ContractPanel) window.getContentPane()).getIndexProgressBar();
				window.setHomePanel();
				((HomePanel) window.getContentPane()).setProgressBar(progress);
			}	
		}
	}
}

	
		
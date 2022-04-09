package control;

import model.Home;
import view.Main_Panel;

public class Controller {

	private Home md;
	private Main_Panel mainPanel;
	
	public Controller(Home md, Main_Panel mainPane) {
		this.md = md;
		this.mainPanel = mainPane; 
	}
}

package control;

import model.Home;

public class Controller {

	private Home md;
	private Main_Pane mainPane;
	
	public Controller(Home md, Main_Pane mainPane) {
		this.md = md;
		this.mainPane = mainPane; 
	}
}

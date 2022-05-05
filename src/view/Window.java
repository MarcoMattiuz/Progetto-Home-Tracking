package view;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller;
import model.Home;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.JMRuntimeException;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Window.
 */
public class Window extends JFrame implements ActionListener,WindowListener{
	
	/** The title. */
	private final String title;
	
	/** The opened. */
	private Boolean opened;					// Se � true la finestra � gi� stata aperta una volta
	
	/** The ft 1. */
	private Boolean ft1;
	
	/** The ft 2. */
	private Boolean ft2;	
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The home panel. */
	private JPanel homePanel;
	
	/** The contract panel. */
	private JPanel contractPanel;
	
	/** The no house panel. */
	private JPanel noHousePanel;
	
	/** The house btn. */
	private JButton houseBtn;
	
	/** The controller. */
	private Controller controller;
	
	/** The exit btn. */
	private JButton exitBtn;
	
	/** The menu. */
	private JMenu menu;
	
	/** The house panel. */
	private HousePanel housePanel;
	
	/**
	 * Instantiates a new window.
	 *
	 * @param controller the controller
	 */
	public Window(Controller controller) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noHousePanel=new NoHousePanel(controller);
		housePanel = new HousePanel(controller);
		title="HOME TRACKING V1";
		this.controller=controller;
		setVisible(true);
		opened=false;
		ft1=ft2=true;
		this.controller = controller;
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.WHITE);
		setBounds(500, 500, 466, 307);
		addWindowListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		setJMenuBar(menuBar);
		menu = new JMenu("Menu");
		menu.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.setHorizontalAlignment(SwingConstants.TRAILING);
		menu.setBackground(Color.DARK_GRAY);
		menuBar.add(menu);
		
		houseBtn = new JButton("House");
		houseBtn.setMaximumSize(new Dimension(85, 23));
		houseBtn.setMinimumSize(new Dimension(85, 23));
		houseBtn.addActionListener((ActionListener) this);
		menu.add(houseBtn);
		setTitle(title);
		homePanel=new HomePanel(controller);
		contractPanel= new ContractPanel(controller);
		menu.hide();
	}
	
	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(Controller controller) {
		throw new IllegalStateException();
	}
	
	/**
	 * Sets the no house panel.
	 */
	public void setNoHousePanel() {
		setContentPane(noHousePanel);
		
	}
	
	/**
	 * Sets the house panel.
	 */
	public void setHousePanel() {
		noHousePanel=contractPanel=homePanel=null;
		setContentPane(housePanel);
		setBounds(500, 500, 505, 380);
	}
	
	/**
	 * Window opened.
	 *
	 * @param e the e
	 */
	public void windowOpened(WindowEvent e) {
		setNoHousePanel();
		((NoHousePanel) getContentPane()).setTitleName(JOptionPane.showInputDialog("Welcome, please enter your name here"));
	}

	/**
	 * Window closing.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(1);
	}

	/**
	 * Window closed.
	 *
	 * @param e the e
	 */
	@Override
	public void windowClosed(WindowEvent e) {

	}

	/**
	 * Window iconified.
	 *
	 * @param e the e
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		if(JOptionPane.showConfirmDialog(this, "Desideri uscire?")==JOptionPane.YES_OPTION)
			System.exit(1); else setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/**
	 * Window deiconified.
	 *
	 * @param e the e
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	/**
	 * Window activated.
	 *
	 * @param e the e
	 */
	@Override
	public void windowActivated(WindowEvent e) {		
	}

	/**
	 * Window deactivated.
	 *
	 * @param e the e
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==houseBtn) {
			setHomePanel();
		}else if(e.getSource()==exitBtn) {
//			System.exit(EXIT_ON_CLOSE);
			windowIconified(null);
		}
	}
	
	/**
	 * Initialize menu items.
	 *
	 * @param numberOfRooms the number of rooms
	 */
	public void initializeMenuItems(int numberOfRooms) {
		switch (numberOfRooms) {
		case 7:
			JButton cameraBBtn = new JButton("Camera 2");
			cameraBBtn.setMaximumSize(new Dimension(85, 23));
			cameraBBtn.setMinimumSize(new Dimension(85, 23));
			cameraBBtn.addActionListener((ActionListener) this);
			menu.add(cameraBBtn);
		case 6:
			JButton bagnoBBtn = new JButton("Bagno 2");
			bagnoBBtn.setMaximumSize(new Dimension(85, 23));
			bagnoBBtn.setMinimumSize(new Dimension(85, 23));
			bagnoBBtn.addActionListener((ActionListener) this);
			menu.add(bagnoBBtn);
		case 5:
			JButton cameraABtn = new JButton("Camera 1");
			cameraABtn.setMaximumSize(new Dimension(85, 23));
			cameraABtn.setMinimumSize(new Dimension(85, 23));
			cameraABtn.addActionListener((ActionListener) this);
			menu.add(cameraABtn);
		case 4:
			JButton soggiornoBtn = new JButton("Soggiorno");
			soggiornoBtn.setMaximumSize(new Dimension(85, 23));
			soggiornoBtn.setMinimumSize(new Dimension(85, 23));
			soggiornoBtn.addActionListener((ActionListener) this);
			menu.add(soggiornoBtn);
		case 3:
			JButton bagnoABtn = new JButton("Bagno 1");
			bagnoABtn.setMaximumSize(new Dimension(85, 23));
			bagnoABtn.setMinimumSize(new Dimension(85, 23));
			bagnoABtn.addActionListener((ActionListener) this);
			menu.add(bagnoABtn);
		case 2:
			JButton cucinaBtn = new JButton("Cucina");
			cucinaBtn.setMaximumSize(new Dimension(85, 23));
			cucinaBtn.setMinimumSize(new Dimension(85, 23));
			cucinaBtn.addActionListener((ActionListener) this);
			menu.add(cucinaBtn);
		default:
			JButton tavernaBtn = new JButton("Taverna");
			tavernaBtn.setMaximumSize(new Dimension(85, 23));
			tavernaBtn.setMinimumSize(new Dimension(85, 23));
			tavernaBtn.addActionListener((ActionListener) this);
			menu.add(tavernaBtn);
			exitBtn = new JButton("Exit");
			exitBtn.setMaximumSize(new Dimension(85, 70));
			menu.add(exitBtn);
			exitBtn.addActionListener(this);
			
		}
	}
	
	/**
	 * Sets the disable all menu buttons.
	 *
	 * @param bool the new disable all menu buttons
	 */
	public void setDisableAllMenuButtons(Boolean bool) {
	}
	
	/**
	 * Sets the home panel.
	 */
	public void setHomePanel() {
		menu.show();
		menu.setPopupMenuVisible(true);
		menu.setPopupMenuVisible(false);
		setBounds(500, 500, 466, 307);
		//getContentPane().setVisible(false);
		setContentPane(homePanel);
	}
	
	/**
	 * Sets the contract panel.
	 */
	public void setContractPanel() {
		menu.show();
		menu.setPopupMenuVisible(true);
		menu.setPopupMenuVisible(false);
		setBounds(500, 500, 466, 307);
	//	getContentPane().setVisible(false);
		setContentPane(contractPanel);
	}
	
	/**
	 * Gets the content pane.
	 *
	 * @return the content pane
	 */
	@Override
	public Container getContentPane() {
		// TODO Auto-generated method stub
		return super.getContentPane();
	}

	/**
	 * Gets the home panel.
	 *
	 * @return the home panel
	 */
	public JPanel getHomePanel() {
		return homePanel;
	}

	/**
	 * Gets the contract panel.
	 *
	 * @return the contract panel
	 */
	public JPanel getContractPanel() {
		return contractPanel;
	}

	/**
	 * Gets the no house panel.
	 *
	 * @return the no house panel
	 */
	public JPanel getNoHousePanel() {
		return noHousePanel;
	}

	/**
	 * Show error message.
	 *
	 * @param message the message
	 */
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(getContentPane(), message);
	}
	
	/**
	 * Show boolean error message.
	 *
	 * @param message the message
	 * @return true, if successful
	 */
	public boolean showBooleanErrorMessage(String message) {
		if(JOptionPane.showConfirmDialog(getContentPane(), message)==JOptionPane.YES_OPTION) {
			return true;
		}else {
			return false;
		}
	}
}

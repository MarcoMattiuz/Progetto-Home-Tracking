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

public class Window extends JFrame implements ActionListener,WindowListener{
	
	private final String title;
	private Boolean opened;					// Se � true la finestra � gi� stata aperta una volta
	private Boolean ft1;
	private Boolean ft2;	
	private JPanel contentPane;
	private JPanel homePanel;
	private JPanel contractPanel;
	private JPanel noHousePanel;
	private JButton houseBtn;
	private Controller controller;
	private JButton exitBtn;
	private JMenu menu;
	private HousePanel housePanel;
	
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
	
	public void setController(Controller controller) {
		throw new IllegalStateException();
	}
	
	public void setNoHousePanel() {
		setContentPane(noHousePanel);
		
	}
	
	public void setHousePanel() {
		noHousePanel=contractPanel=homePanel=null;
		setContentPane(housePanel);
		setBounds(500, 500, 505, 380);
	}
	
	public void windowOpened(WindowEvent e) {
		setNoHousePanel();
		((NoHousePanel) getContentPane()).setTitleName(JOptionPane.showInputDialog("Welcome, please enter your name here"));
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(1);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {
		if(JOptionPane.showConfirmDialog(this, "Desideri uscire?")==JOptionPane.YES_OPTION)
			System.exit(1); else setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==houseBtn) {
			setHomePanel();
		}else if(e.getSource()==exitBtn) {
//			System.exit(EXIT_ON_CLOSE);
			windowIconified(null);
		}
	}
	
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
	
	public void setDisableAllMenuButtons(Boolean bool) {
	}
	
	public void setHomePanel() {
		menu.show();
		menu.setPopupMenuVisible(true);
		menu.setPopupMenuVisible(false);
		setBounds(500, 500, 466, 307);
		//getContentPane().setVisible(false);
		setContentPane(homePanel);
	}
	
	public void setContractPanel() {
		menu.show();
		menu.setPopupMenuVisible(true);
		menu.setPopupMenuVisible(false);
		setBounds(500, 500, 466, 307);
	//	getContentPane().setVisible(false);
		setContentPane(contractPanel);
	}
	
	@Override
	public Container getContentPane() {
		// TODO Auto-generated method stub
		return super.getContentPane();
	}

	public JPanel getHomePanel() {
		return homePanel;
	}

	public JPanel getContractPanel() {
		return contractPanel;
	}

	public JPanel getNoHousePanel() {
		return noHousePanel;
	}

	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(getContentPane(), message);
	}
	
	public boolean showBooleanErrorMessage(String message) {
		if(JOptionPane.showConfirmDialog(getContentPane(), message)==JOptionPane.YES_OPTION) {
			return true;
		}else {
			return false;
		}
	}
}

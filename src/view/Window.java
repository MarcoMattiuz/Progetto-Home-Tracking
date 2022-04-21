package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.PanelBuilder;

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
	private Boolean opened;					// Se è true la finestra è già stata aperta una volta
	private Boolean ft1;
	private Boolean ft2;	
	private JPanel contentPane;
	private JPanel homePanel;
	private JPanel contractPanel;
	private JPanel noHousePanel;
	private JButton homeBtn;
	private Controller controller;
	private JButton roomsBtn;
	private JButton exitBtn;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton optBtn;
	private JMenu menu;
	
	public Window(Controller controller) {
		noHousePanel=new NoHousePanel(controller);
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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menu = new JMenu("Menu");
		menu.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.setHorizontalAlignment(SwingConstants.TRAILING);
		menu.setBackground(Color.DARK_GRAY);
		menuBar.add(menu);
		
		homeBtn = new JButton("Home");
		homeBtn.setMaximumSize(new Dimension(70, 23));
		homeBtn.setMinimumSize(new Dimension(70, 23));
		homeBtn.addActionListener((ActionListener) this);
		menu.add(homeBtn);
		
		roomsBtn = new JButton("Rooms");
		roomsBtn.setMinimumSize(new Dimension(70, 23));
		roomsBtn.setMaximumSize(new Dimension(70, 23));
		menu.add(roomsBtn);
		roomsBtn.addActionListener(this);
		
		btnNewButton = new JButton("n");
		btnNewButton.setMinimumSize(new Dimension(70, 23));
		btnNewButton.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton);
		
		btnNewButton_2 = new JButton("n");
		btnNewButton_2.setMinimumSize(new Dimension(70, 23));
		btnNewButton_2.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("n");
		btnNewButton_3.setMinimumSize(new Dimension(70, 23));
		btnNewButton_3.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_3);
		
		exitBtn = new JButton("Exit");
		exitBtn.setMaximumSize(new Dimension(70, 70));
		menu.add(exitBtn);
		exitBtn.addActionListener(this);
		
		optBtn = new JButton("Options");
		optBtn.setMinimumSize(new Dimension(70, 23));
		optBtn.setMaximumSize(new Dimension(70, 23));
		menu.add(optBtn);
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
		if(e.getSource()==homeBtn) {
			setHomePanel();
		}else if(e.getSource()==roomsBtn) {
			setBounds(500, 500, 466, 307);
			//getContentPane().setVisible(false);
			setContentPane(contractPanel);
			menu.setPopupMenuVisible(false);menu.setSelected(false);
		}else if(e.getSource()==exitBtn) {
//			System.exit(EXIT_ON_CLOSE);
			windowIconified(null);
		}
	}
	
	public void setDisableAllMenuButtons(Boolean bool) {
		if(bool) {
			btnNewButton.setVisible(false);
		}
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
	
}

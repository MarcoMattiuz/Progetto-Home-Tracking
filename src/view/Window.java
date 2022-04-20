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

public class Window extends JFrame implements ActionListener,WindowListener{
	
	private final String title;
	private Boolean opened;					// Se è true la finestra è già stata aperta una volta
	private Boolean ft1;
	private Boolean ft2;	
	private JPanel contentPane;
	private JPanel homePanel;
	private JPanel contractPanel;
	private JButton home_btn;
	private Controller controller;
	private JButton rooms_btn;
	private JButton exit_btn;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JMenu menu;
	
	public Window(Controller controller) {
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
		
		home_btn = new JButton("Home");
		home_btn.setMaximumSize(new Dimension(70, 23));
		home_btn.setMinimumSize(new Dimension(70, 23));
		home_btn.addActionListener((ActionListener) this);
		menu.add(home_btn);
		
		rooms_btn = new JButton("Rooms");
		rooms_btn.setMinimumSize(new Dimension(70, 23));
		rooms_btn.setMaximumSize(new Dimension(70, 23));
		menu.add(rooms_btn);
		rooms_btn.addActionListener(this);
		
		btnNewButton = new JButton("n");
		btnNewButton.setMinimumSize(new Dimension(70, 23));
		btnNewButton.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton);
		
		btnNewButton_1 = new JButton("n");
		btnNewButton_1.setMinimumSize(new Dimension(70, 23));
		btnNewButton_1.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("n");
		btnNewButton_2.setMinimumSize(new Dimension(70, 23));
		btnNewButton_2.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("n");
		btnNewButton_3.setMinimumSize(new Dimension(70, 23));
		btnNewButton_3.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("n");
		btnNewButton_4.setMinimumSize(new Dimension(70, 23));
		btnNewButton_4.setMaximumSize(new Dimension(70, 23));
		menu.add(btnNewButton_4);
		
		exit_btn = new JButton("Exit");
		exit_btn.setMaximumSize(new Dimension(70, 70));
		menu.add(exit_btn);
		exit_btn.addActionListener(this);
		setTitle(title);
		homePanel=new homePanel(controller);
		contractPanel= new contractPanel(controller);
		menu.hide();
	}
	
	public void setController(Controller controller) {
		throw new IllegalStateException();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		setContentPane(new NoHousePanel(controller));
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
		if(e.getSource()==home_btn) {
			setHomePanel();
		}else if(e.getSource()==rooms_btn) {
			setBounds(500, 500, 466, 307);
			//getContentPane().setVisible(false);
			setContentPane(contractPanel);
			menu.setPopupMenuVisible(false);menu.setSelected(false);
		}else if(e.getSource()==exit_btn) {
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
		setBounds(500, 500, 466, 307);
		getContentPane().setVisible(false);
		setContentPane(new contractPanel(controller));
	}
	
	@Override
	public Container getContentPane() {
		// TODO Auto-generated method stub
		return super.getContentPane();
	}
	
}

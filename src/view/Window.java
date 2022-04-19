package view;

import java.awt.*;
import java.awt.EventQueue;

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
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Window extends JFrame implements ActionListener,WindowListener{

	private Boolean opened;					// Se è true la finestra è già stata aperta una volta
	private JPanel contentPane;
	private JButton home_btn;
	private Controller controller;
	private JButton rooms_btn;
	private JButton exit_btn;
	
	public Window(Controller controller) {
		opened=false;
		this.controller = controller;
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setType(Type.POPUP);
		setBackground(Color.WHITE);
		setBounds(100, 100, 466, 527);
		addWindowListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		mnNewMenu.setHorizontalAlignment(SwingConstants.TRAILING);
		mnNewMenu.setBackground(Color.DARK_GRAY);
		menuBar.add(mnNewMenu);
		
		home_btn = new JButton("Home");
		home_btn.addActionListener((ActionListener) this);
		mnNewMenu.add(home_btn);
		
		rooms_btn = new JButton("Rooms");
		mnNewMenu.add(rooms_btn);
		rooms_btn.addActionListener(this);
		
		exit_btn = new JButton("Exit");
		mnNewMenu.add(exit_btn);
		exit_btn.addActionListener(this);
		contentPane = new homePanel(controller);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		setTitle("Home Tracking 1.0");
		setVisible(true);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		if(!opened) {
			opened=true;
			
			setContentPane(new homePanel(controller));
		}
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		if(JOptionPane.showConfirmDialog(this, "Desideri uscire?")==JOptionPane.YES_OPTION)
			System.exit(0); else setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==home_btn) {
			setBounds(100, 100, 466, 449);
			contentPane.setVisible(true);
			setContentPane(contentPane);
		}else if(e.getSource()==rooms_btn) {
			contentPane.setVisible(false);
			setContentPane(new contractPanel());
			setBounds(100, 100, 400, 400);
		}else if(e.getSource()==exit_btn) {
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
}

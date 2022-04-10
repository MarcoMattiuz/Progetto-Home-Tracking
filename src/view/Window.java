package view;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Window extends JFrame implements ActionListener,WindowListener{

	private Main_Panel contentPane;
	private JButton close;
	private Controller controller;
	public Window(Controller controller) {
		this.controller = controller;
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setType(Type.POPUP);
		setBackground(Color.WHITE);
		setBounds(100, 100, 437, 266);
		addWindowListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(Color.DARK_GRAY);
		menuBar.add(mnNewMenu);
		
		close = new JButton("Exit");
		close.addActionListener((ActionListener) this);
		mnNewMenu.add(close);
		contentPane = new Main_Panel(this.controller);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		setTitle("Home Tracking 1.0");
		setVisible(true);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
		if(e.getSource()==close) {
			System.exit(0);
		}		
	}
	
}

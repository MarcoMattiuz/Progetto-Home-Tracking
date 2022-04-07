package view;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Finestra extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JButton close;

	public Finestra() {
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 611, 396);
		addWindowListener(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		close = new JButton("New button");
		close.addActionListener((ActionListener) this);
		mnNewMenu.add(close);
		contentPane = new Main_Panel();
		contentPane.setBackground(Color.GRAY);
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
		if(JOptionPane.showConfirmDialog(this, "Desideri uscire?")==JOptionPane.YES_OPTION)
			System.exit(0); else setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
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

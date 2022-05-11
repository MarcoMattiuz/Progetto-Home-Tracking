package view;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Controller;

import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
//import net.miginfocom.swing.MigLayout;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;

// TODO: Auto-generated Javadoc
/**
 * The Class NoHousePanel.
 */
public class NoHousePanel extends JPanel{

	/**
	 * Create the panel.
	 */
	private Controller controller;
	
	/** The name. */
	String name;
	
	/** The name btn. */
	private JButton nameBtn;
	
	/** The title label. */
	private JLabel titleLabel;
	
	/**
	 * Instantiates a new no house panel.
	 *
	 * @param controller the controller
	 */
	public NoHousePanel(Controller controller) {
		setSize(new Dimension(430, 244));
		this.controller=controller;
		setLayout(new BorderLayout(0, 0));
		
		titleLabel = new JLabel("\"\"");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		nameBtn = new JButton("Create House");
		nameBtn.setFont(new Font("Arial", Font.PLAIN, 11));
		nameBtn.addActionListener(controller);
		nameBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(nameBtn);
		nameBtn.addActionListener(controller);
	//	controller.actionPerformed(null);
		}
	
		/**
		 * Gets the name btn.
		 *
		 * @return the name btn
		 */
		public JButton getNameBtn() {
			return nameBtn;
		}
	
	/**
	 * Sets the title name.
	 *
	 * @param name the new title name
	 */
	public void setTitleName(String name) {
		this.name=name;
		titleLabel.setText("Welcome "+name.toUpperCase()+"!");
		JOptionPane.showMessageDialog(this, "Hello "+name+", it looks like you haven't created a house yet,\n"
				+ "click on the button \"Create House\" to generate a new one");
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}

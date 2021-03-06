package view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Controller;
import model.Room;

import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.DebugGraphics;
import javax.swing.DefaultListModel;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ListSelectionModel;

// TODO: Auto-generated Javadoc
/**
 * The Class HousePanel.
 */
public class HousePanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private Controller controller;
	
	/** The list. */
	private JList list;
	
	/** The consumption label. */
	private JLabel consumptionLabel;
	
	/** The viewthingsbtn. */
	private JButton viewthingsbtn;
	
	/** The title label. */
	private JLabel titleLabel;
	
	/** The model. */
	private DefaultListModel model;
	
	/** The money label. */
	private JLabel moneyLabel;
	
	/** The profif label. */
	private JLabel profitLabel;
	
	/** The bill label. */
	private JLabel billLabel;
	
	/**
	 * Gets the bill label.
	 *
	 * @return the bill label
	 */
	public JLabel getBillLabel() {
		return billLabel;
	}

	/**
	 * Sets the bill label.
	 *
	 * @param billLabel the new bill label
	 */
	public void setBillLabel(JLabel billLabel) {
		this.billLabel = billLabel;
	}

	/**
	 * Gets the profit label.
	 *
	 * @return the profit label
	 */
	public JLabel getProfitLabel() {
		return profitLabel;
	}

	/**
	 * Sets the profit label.
	 *
	 * @param profitLabel the new profit label
	 */
	public void setProfitLabel(JLabel profitLabel) {
		this.profitLabel = profitLabel;
	}

	/**
	 * Instantiates a new house panel.
	 *
	 * @param controller the controller
	 */
	@SuppressWarnings("unchecked")
	public HousePanel(Controller controller) {
		model = new DefaultListModel<>();
		setSize(new Dimension(505, 328));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));

		titleLabel = new JLabel("House Panel");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[35.00][grow][35.00]", "[8.00][180.00,grow][16.00px:n][16.00px:n][8][16.00px:n][16.00px:n][]"));
		
		list = new JList<>();
		list.setFixedCellWidth(300);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setBorder(null);
		list.setBackground(SystemColor.control);
		panel.add(list, "flowx,cell 1 1,alignx left,aligny top");
		
		consumptionLabel = new JLabel("");
		consumptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(consumptionLabel, "cell 1 2,alignx center,aligny center");
		
		viewthingsbtn = new JButton("VIEW PRESENT CONSUMPTION");
		viewthingsbtn.setFont(new Font("Arial", Font.PLAIN, 11));
		
		moneyLabel = new JLabel("");
		moneyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(moneyLabel, "cell 1 3,alignx center,aligny center");
		
		profitLabel = new JLabel("");
		profitLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(profitLabel, "cell 1 5,alignx center,aligny center");
		
		billLabel = new JLabel("");
		billLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(billLabel, "cell 1 6,alignx center,aligny center");
		panel.add(viewthingsbtn, "cell 1 7,alignx center");
		setListener();
	}

	/**
	 * Sets the listener.
	 */
	public void setListener() {
		viewthingsbtn.addActionListener(controller);
		viewthingsbtn.addActionListener(this);
		list.addListSelectionListener(controller);
	}
	
	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public JList getList() {
		return list;
	}

	/**
	 * Initialize panel.
	 *
	 * @param roomsNames the rooms names
	 * @param houseName the house name
	 * @param holderName the holder name
	 */
	public void initializePanel(ArrayList<Room> roomsNames, String houseName, String holderName) {
		roomsNames.stream().forEach((s)->{
            model.addElement(s);
        });
		titleLabel.setText(titleLabel.getText()+" -> House \""+houseName+"\" owned by \""+holderName+"\"");
		
	}

	/**
	 * Gets the consumption label.
	 *
	 * @return the consumption label
	 */
	public JLabel getConsumptionLabel() {
		return consumptionLabel;
	}

	/**
	 * Sets the consumption label.
	 *
	 * @param consumptionLabel the new consumption label
	 */
	public void setConsumptionLabel(JLabel consumptionLabel) {
		this.consumptionLabel = consumptionLabel;
	}

	/**
	 * Gets the viewthingsbtn.
	 *
	 * @return the viewthingsbtn
	 */
	public JButton getViewthingsbtn() {
		return viewthingsbtn;
	}
	

	/**
	 * Sets the viewthingsbtn.
	 *
	 * @param viewthingsbtn the new viewthingsbtn
	 */
	public void setViewthingsbtn(JButton viewthingsbtn) {
		this.viewthingsbtn = viewthingsbtn;
	}

	/**
	 * Gets the title label.
	 *
	 * @return the title label
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * Sets the title label.
	 *
	 * @param titleLabel the new title label
	 */
	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
	
	/**
	 * Gets the money label.
	 *
	 * @return the money label
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewthingsbtn) {
			if(viewthingsbtn.getText().compareTo("VIEW PRESENT CONSUMPTION")==0) {
				viewthingsbtn.setText("VIEW DAILY CONSUMPTION");
			}else {
				viewthingsbtn.setText("VIEW PRESENT CONSUMPTION");
			}
		}
	}
}

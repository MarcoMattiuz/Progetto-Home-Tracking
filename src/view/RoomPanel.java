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
public class RoomPanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private Controller controller;
	
	/** The room. */
	private Room room;
	
	/** The list. */
	private JList list;
	
	/** The consumption label. */
	private JLabel consumptionLabel;
	
	/** The viewthingsbtn. */
	private JButton viewThingsBtn;
	
	/** The title label. */
	private JLabel titleLabel;
	
	/** The model. */
	private DefaultListModel model;
	
	/** The back btn. */
	private JButton backBtn;
	
	/**
	 * Instantiates a new room panel.
	 *
	 * @param controller the controller
	 * @param room the room
	 * @param roomName the room name
	 */
	@SuppressWarnings("unchecked")
	public RoomPanel(Controller controller, Room room, String roomName) {
		this.room=room;
		model = new DefaultListModel<>();
		
		setSize(new Dimension(505, 328));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));

		titleLabel = new JLabel("Room Panel");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("4334");
		panel.setName("");
		panel.setBorder(null);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[35.00][grow][35.00]", "[8.00][218.00,grow][69.00px:n][][]"));
		
		list = new JList<>();
		list.setFixedCellWidth(300);
		list.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setBorder(null);
		list.setBackground(SystemColor.control);
		panel.add(list, "flowx,cell 1 1,alignx left,aligny top");
		
		consumptionLabel = new JLabel("");
		consumptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(consumptionLabel, "cell 1 2,alignx center,aligny center");
		
		backBtn = new JButton("BACK");
		backBtn.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(backBtn, "flowx,cell 1 4,alignx center");
		
		viewThingsBtn = new JButton("VIEW CURRENT CONSUMPTION");
		viewThingsBtn.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(viewThingsBtn, "cell 1 4,alignx center");
		setListener();
		(room.getDevices()).stream().forEach((s)->{
			model.addElement(s);
			if(s.toString().contains("panels")) {
				panel.remove(viewThingsBtn);
				panel.remove(consumptionLabel);
			}
		});
		titleLabel.setText(titleLabel.getText()+" -> \""+roomName+"\"");
	}

	/**
	 * Sets the listener.
	 */
	public void setListener() {
		viewThingsBtn.addActionListener(controller);
		viewThingsBtn.addActionListener(this);
		list.addListSelectionListener(controller);
		backBtn.addActionListener(controller);
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
	 * Gets the back btn.
	 *
	 * @return the back btn
	 */
	public JButton getBackBtn() {
		return backBtn;
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
		return viewThingsBtn;
	}

	/**
	 * Sets the viewthingsbtn.
	 *
	 * @param viewthingsbtn the new viewthingsbtn
	 */
	public void setViewthingsbtn(JButton viewthingsbtn) {
		this.viewThingsBtn = viewthingsbtn;
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
	 * Gets the room.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return room;
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
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewThingsBtn) {
			if(viewThingsBtn.getText().compareTo("VIEW CURRENT CONSUMPTION")==0) {
				viewThingsBtn.setText("VIEW DAILY CONSUMPTION");
			}else {
				viewThingsBtn.setText("VIEW PRESENT CONSUMPTION");
			}
		}
	}
}

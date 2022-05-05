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
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import java.awt.Color;

public class RoomPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	Controller controller;
	private int progressState;

	@SuppressWarnings("unchecked")
	public RoomPanel(Controller controller) {
		setSize(new Dimension(505, 328));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));

		JLabel titleLabel = new JLabel("ROOM PANEL -");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[35.00][grow][35.00]", "[8.00][218.00,grow][69.00px:n][][]"));
		
		JList list = new JList();
		list.setBorder(null);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"STANZA 1 PROVA", "STANZA 2 PROVA", "STANZA 3 PROVA", "STANZA 4 PROVA", "STANZA 5 PROVA", "STANZA 6 PROVA", "STANZA 7 PROVA", "STANZA 8 PROVA", "STANZA 9 PROVA", "STANZA 10 PROVA", "STANZA 11 PROVA", "STANZA 12 PROVA"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBackground(SystemColor.control);
		panel.add(list, "flowx,cell 1 1,alignx left,aligny top");
		
		JLabel consumptionLabel = new JLabel("NaN");
		panel.add(consumptionLabel, "cell 1 2");
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.setForeground(Color.BLACK);
		panel.add(btnNewButton_1, "flowx,cell 1 4,alignx center");
		
		JButton viewthingsbtn = new JButton("VIEW CURRENT CONSUMPTION");
		viewthingsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(viewthingsbtn, "cell 1 4,alignx center");
		
		JButton btnNewButton = new JButton("STOP");
		btnNewButton.setForeground(Color.BLACK);
		panel.add(btnNewButton, "cell 1 4,alignx center");
		setListener();
	}

	public void setListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

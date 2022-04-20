package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.DebugGraphics;
import javax.swing.JSlider;

public class contractPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Controller controller;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public contractPanel(Controller controller) {
		setSize(new Dimension(430, 244));
		this.controller=controller;
		setLayout(new BorderLayout(0, 0));
		
		JLabel titleLabel = new JLabel("CREATING A NEW HOME -> CONTRACT");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(466, 400));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[82.00][41.00][][349.00,grow]", "[30.00][30.00][30.00:30.00][30.00][10.00][:37.00:30px,grow][10.00][]"));
		
		JLabel lblNewLabel = new JLabel("Contract Name");
		panel.add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 0,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Electricity Price");
		panel.add(lblNewLabel_1, "cell 0 1");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "flowx,cell 3 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gas Price");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "flowx,cell 3 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Water Price");
		panel.add(lblNewLabel_3, "cell 0 3");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "flowx,cell 3 3,growx");
		textField_3.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar, "cell 0 7 4 1,growx");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		splitPane.setBorder(null);
		splitPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.add(splitPane, "cell 0 5 4 1,alignx center,growy");
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setMinimumSize(new Dimension(71, 23));
		btnNewButton_2.setMaximumSize(new Dimension(71, 23));
		splitPane.setLeftComponent(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Proceed");
		splitPane.setRightComponent(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u20AC/kWh");
		panel.add(lblNewLabel_4, "cell 3 1,alignx trailing");
		
		JLabel lblNewLabel_5 = new JLabel("\u20AC/Smc");
		lblNewLabel_5.setMinimumSize(new Dimension(31, 14));
		lblNewLabel_5.setMaximumSize(new Dimension(31, 14));
		panel.add(lblNewLabel_5, "cell 3 2,alignx trailing");
		
		JLabel lblNewLabel_6 = new JLabel("\u20AC/mq");
		lblNewLabel_6.setMinimumSize(new Dimension(31, 14));
		lblNewLabel_6.setMaximumSize(new Dimension(31, 14));
		panel.add(lblNewLabel_6, "cell 3 3,alignx trailing");

	}
}

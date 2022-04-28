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

public class ContractPanel extends JPanel implements DocumentListener {

	/**
	 * Create the panel.
	 */
	Controller controller;
	private JTextField contractNameTfd;
	private JTextField ePriceTfd;
	private JTextField gPriceTfd;
	private JTextField wPriceTfd;
	private JButton backBtn;
	private JButton proceedBtn;
	private JProgressBar progressBar;
	private int progressState;

	public ContractPanel(Controller controller) {
		setSize(new Dimension(430, 244));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));

		JLabel titleLabel = new JLabel("CREATING A NEW HOME -> CONTRACT");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(466, 400));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[82.00][41.00][][349.00,grow]",
				"[30.00][30.00][30.00:30.00][30.00][10.00][:37.00:30px,grow][10.00][]"));

		JLabel contractNameLabel = new JLabel("Contract Name");
		panel.add(contractNameLabel, "cell 0 0");

		contractNameTfd = new JTextField();
		panel.add(contractNameTfd, "cell 3 0,growx,aligny center");
		contractNameTfd.setColumns(10);

		JLabel ePriceLabel = new JLabel("Electricity Price");
		panel.add(ePriceLabel, "cell 0 1");

		ePriceTfd = new JTextField();
		panel.add(ePriceTfd, "flowx,cell 3 1,growx");
		ePriceTfd.setColumns(10);

		JLabel gPriceLabel = new JLabel("Gas Price");
		panel.add(gPriceLabel, "cell 0 2");

		gPriceTfd = new JTextField();
		panel.add(gPriceTfd, "flowx,cell 3 2,growx");
		gPriceTfd.setColumns(10);

		JLabel wPriceLabel = new JLabel("Water Price");
		panel.add(wPriceLabel, "cell 0 3");

		wPriceTfd = new JTextField();
		panel.add(wPriceTfd, "flowx,cell 3 3,growx");
		wPriceTfd.setColumns(10);

		progressBar = new JProgressBar();
		panel.add(progressBar, "cell 0 7 4 1,growx");

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		splitPane.setBorder(null);
		splitPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.add(splitPane, "cell 0 5 4 1,alignx center,growy");

		backBtn = new JButton("Back");
		backBtn.setMinimumSize(new Dimension(71, 23));
		backBtn.setMaximumSize(new Dimension(71, 23));
		splitPane.setLeftComponent(backBtn);

		proceedBtn = new JButton("Proceed");
		splitPane.setRightComponent(proceedBtn);

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
		setListener();
	}

	public void setListener() {
		contractNameTfd.getDocument().addDocumentListener(this);
		ePriceTfd.getDocument().addDocumentListener(this);
		gPriceTfd.getDocument().addDocumentListener(this);
		wPriceTfd.getDocument().addDocumentListener(this);
		backBtn.addActionListener(controller);
		proceedBtn.addActionListener(controller);
	}

	public void setProgressBar(int progressState) {
		progressBar.setValue(progressState);
		this.progressState = progressState;
	}

	public int getIndexProgressBar() {
		return progressState;
	}

	private void updateProgressBar(int i) {
		if (i >= 0) {
			progressState += 13;
		} else {
			progressState -= 13;
			if (progressState < 0) {
				progressState = 0;
			}
		}
		progressBar.setValue(progressState);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == contractNameTfd.getDocument()) {
			if (contractNameTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		} else if (e.getDocument() == ePriceTfd.getDocument()) {
			if (ePriceTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		} else if (e.getDocument() == gPriceTfd.getDocument()) {
			if (gPriceTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		} else if (e.getDocument() == wPriceTfd.getDocument()) {
			if (wPriceTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == contractNameTfd.getDocument()) {
			if (contractNameTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		} else if (e.getDocument() == ePriceTfd.getDocument()) {
			if (ePriceTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		} else if (e.getDocument() == gPriceTfd.getDocument()) {
			if (gPriceTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		} else if (e.getDocument() == wPriceTfd.getDocument()) {
			if (wPriceTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		insertUpdate(e);

	}

	public String getContractName() {
		return contractNameTfd.getText();
	}

	public String getePrice() {
		return ePriceTfd.getText();
	}

	public void setePrice(Double x) {
		ePriceTfd.setText(String.valueOf(x));
		updateProgressBar(1);
	}

	public void setgPrice(Double x) {
		gPriceTfd.setText(String.valueOf(x));
		updateProgressBar(1);
	}

	public void setwPrice(Double x) {
		wPriceTfd.setText(String.valueOf(x));
		updateProgressBar(1);
	}

	public String getgPrice() {
		return gPriceTfd.getText();
	}

	public String getwPrice() {
		return wPriceTfd.getText();
	}

	public JButton getProceedBtn() {
		return proceedBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}
}

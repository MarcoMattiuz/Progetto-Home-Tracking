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

public class HousePanel extends JPanel implements DocumentListener {

	/**
	 * Create the panel.
	 */
	Controller controller;
	private int progressState;

	@SuppressWarnings("unchecked")
	public HousePanel(Controller controller) {
		setSize(new Dimension(512, 443));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));

		JLabel titleLabel = new JLabel("HOUSE PANEL");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[35.00][grow][35.00]", "[8.00][329.00,grow][69.00px:n][][]"));
		
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
		
		JButton btnNewButton = new JButton("STOP");
		panel.add(btnNewButton, "flowx,cell 1 4");
		
		JButton btnNewButton_1 = new JButton("START");
		panel.add(btnNewButton_1, "cell 1 4");
		
		JButton btnNewButton_2 = new JButton("VIEW CURRENT CONSUMPTION");
		panel.add(btnNewButton_2, "cell 1 4");
		setListener();
	}

	public void setListener() {
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

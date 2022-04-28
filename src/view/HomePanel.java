package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import control.Controller;
import javax.swing.event.*;
import javax.swing.plaf.ProgressBarUI;
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
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.DebugGraphics;

@SuppressWarnings("serial")

public class HomePanel extends JPanel implements ActionListener, DocumentListener, ChangeListener {

	private int progressState;
	private Controller controller;
	private JTextField holderNameTfd;
	private JButton yesBtn;
	private JButton noBtn;
	private JButton backBtn;
	private JButton proceedBtn;
	int flag;
	boolean flag2;
	private JTextField houseNameTfd;
	private JProgressBar progressBar;
	private JSpinner spinner;

	public HomePanel(Controller controller) {
		progressState = 0;
		setSize(new Dimension(430, 244));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));
		flag = 1;
		flag2 = false;
		JLabel titleLabel = new JLabel("CREATING A NEW HOME -> HOUSE");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(466, 400));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[82.00][41.00][][349.00,grow]",
				"[30.00][30.00][30.00:30.00][30.00][10.00][:37.00:30px,grow][10.00][]"));

		JLabel holderNameLabel = new JLabel("Holder Name");
		panel.add(holderNameLabel, "cell 0 0");

		holderNameTfd = new JTextField();
		holderNameTfd.getDocument().addDocumentListener(this);

		panel.add(holderNameTfd, "cell 3 0,growx,aligny center");
		holderNameTfd.setColumns(10);

		JLabel houseNameLabel = new JLabel("House Name");
		panel.add(houseNameLabel, "cell 0 1");

		houseNameTfd = new JTextField();
		panel.add(houseNameTfd, "cell 3 1,growx");
		houseNameTfd.setColumns(10);
		houseNameTfd.getDocument().addDocumentListener(this);
		JLabel rnLabel = new JLabel("Rooms Number");
		panel.add(rnLabel, "cell 0 2");

		spinner = new JSpinner();
		panel.add(spinner, "cell 3 2,alignx left,aligny center");

		JLabel sPLabel = new JLabel("Solar Panels");
		panel.add(sPLabel, "cell 0 3");

		yesBtn = new JButton("Yes");
		panel.add(yesBtn, "flowx,cell 3 3");

		noBtn = new JButton("No");
		panel.add(noBtn, "cell 3 3");

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
		setListener();
	}

	private void setListener() {
		yesBtn.addActionListener(controller);
		yesBtn.addActionListener(this);
		noBtn.addActionListener(controller);
		noBtn.addActionListener(this);
		backBtn.addActionListener(controller);
		backBtn.addActionListener(this);
		proceedBtn.addActionListener(controller);
		proceedBtn.addActionListener(this);
		spinner.addChangeListener(this);
	}

	public JButton getYesBtn() {
		return yesBtn;
	}

	public void setYesBtn(JButton yesBtn) {
		this.yesBtn = yesBtn;
	}

	public JButton getNoBtn() {
		return noBtn;
	}

	public void setNoBtn(JButton noBtn) {
		this.noBtn = noBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JButton getProceedBtn() {
		return proceedBtn;
	}

	public void setProceedBtn(JButton proceedBtn) {
		this.proceedBtn = proceedBtn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yesBtn) {
			if (flag == 0) {
				noBtn.show();
				flag = 1;
				yesBtn.setSelected(false);
				updateProgressBar(-1);
			} else {
				noBtn.hide();
				flag = 0;
				yesBtn.setSelected(true);
				updateProgressBar(1);
			}
		} else if (e.getSource() == noBtn) {
			if (flag == 0) {
				yesBtn.show();
				noBtn.setSelected(false);
				updateProgressBar(-1);
				flag = 1;
			} else {
				yesBtn.hide();
				updateProgressBar(1);
				noBtn.setSelected(true);
				flag = 0;
			}
		} else if (e.getSource() == backBtn) {
			// JOptionPane.showMessageDialog(this, "You can't go back!");
		}
	}

	private void updateProgressBar(int i) {
		if (i >= 0) {
			progressState += 12;
		} else {
			progressState -= 12;
			if (progressState < 0) {
				progressState = 0;
			}
		}
		progressBar.setValue(progressState);
	}

	public void setProgressBar(int progressState) {
		progressBar.setValue(progressState);
		this.progressState = progressState;
	}

	public int getIndexProgressBar() {
		return progressState;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == holderNameTfd.getDocument()) {
			if (holderNameTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		} else if (e.getDocument() == houseNameTfd.getDocument()) {
			if (houseNameTfd.getText().length() == 1) {
				updateProgressBar(1);
			}
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == holderNameTfd.getDocument()) {
			if (holderNameTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		} else if (e.getDocument() == houseNameTfd.getDocument()) {
			if (houseNameTfd.getText().compareTo("") == 0) {
				updateProgressBar(-1);
			}
		}

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (spinner.getValue().equals(0)) {
			updateProgressBar(-1);
			flag2 = false;
		} else {
			if (!flag2) {
				updateProgressBar(1);
				flag2 = true;
			}
		}
	}

	public int getProgressState() {
		return progressState;
	}

	public String getHolderName() {
		return holderNameTfd.getText();
	}

	public String getHouseName() {
		return houseNameTfd.getText();
	}

	public int getRoomsNumber() {
		return (int) spinner.getValue();
	}

	public void setRoomsNumber(int number) {
		spinner.setValue(number);
	}

	public int wantSolarPanels() { // 1 Vuole, 0 non selezionato, -1 non vuole
		if (yesBtn.isSelected() && !noBtn.isSelected()) {
			return 1;
		} else if (!yesBtn.isSelected() && noBtn.isSelected()) {
			return -1;
		}
		return 0;
	}
}

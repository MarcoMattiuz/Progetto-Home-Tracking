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

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
@SuppressWarnings("serial")

public class CreateHousePanel extends JPanel implements ActionListener, DocumentListener, ChangeListener {

	/** The progress state. */
	private int progressState;
	
	/** The controller. */
	private Controller controller;
	
	/** The holder name tfd. */
	private JTextField holderNameTfd;
	
	/** The house name tfd. */
	private JTextField houseNameTfd;
	
	/** The yes btn. */
	private JButton yesBtn;
	
	/** The no btn. */
	private JButton noBtn;
	
	/** The back btn. */
	private JButton backBtn;
	
	/** The proceed btn. */
	private JButton proceedBtn;
	
	/** The flag. */
	private int flag;
	
	/** The flag 2. */
	private boolean flag2;
	
	
	/** The progress bar. */
	private JProgressBar progressBar;
	
	/** The spinner. */
	private JSpinner spinner;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param controller the controller
	 */
	public CreateHousePanel(Controller controller) {
		progressState = 0;
		setSize(new Dimension(430, 244));
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));
		flag = 1;
		flag2 = false;
		JLabel titleLabel = new JLabel("Creating a new House -> The House");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
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

	/**
	 * Sets the listener.
	 */
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

	/**
	 * Gets the yes btn.
	 *
	 * @return the yes btn
	 */
	public JButton getYesBtn() {
		return yesBtn;
	}

	/**
	 * Sets the yes btn.
	 *
	 * @param yesBtn the new yes btn
	 */
	public void setYesBtn(JButton yesBtn) {
		this.yesBtn = yesBtn;
	}
	
	public JTextField getHolderNameTfd() {
		return holderNameTfd;
	}

	/**
	 * Gets the no btn.
	 *
	 * @return the no btn
	 */
	public JButton getNoBtn() {
		return noBtn;
	}

	/**
	 * Sets the no btn.
	 *
	 * @param noBtn the new no btn
	 */
	public void setNoBtn(JButton noBtn) {
		this.noBtn = noBtn;
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
	 * Sets the back btn.
	 *
	 * @param backBtn the new back btn
	 */
	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	/**
	 * Gets the proceed btn.
	 *
	 * @return the proceed btn
	 */
	public JButton getProceedBtn() {
		return proceedBtn;
	}

	/**
	 * Sets the proceed btn.
	 *
	 * @param proceedBtn the new proceed btn
	 */
	public void setProceedBtn(JButton proceedBtn) {
		this.proceedBtn = proceedBtn;
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
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

	/**
	 * Update progress bar.
	 *
	 * @param i the i
	 */
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

	/**
	 * Sets the progress bar.
	 *
	 * @param progressState the new progress bar
	 */
	public void setProgressBar(int progressState) {
		progressBar.setValue(progressState);
		this.progressState = progressState;
	}

	/**
	 * Gets the index progress bar.
	 *
	 * @return the index progress bar
	 */
	public int getIndexProgressBar() {
		return progressState;
	}

	/**
	 * Insert update.
	 *
	 * @param e the e
	 */
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

	/**
	 * Removes the update.
	 *
	 * @param e the e
	 */
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

	/**
	 * Changed update.
	 *
	 * @param e the e
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	/**
	 * State changed.
	 *
	 * @param e the e
	 */
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

	/**
	 * Gets the progress state.
	 *
	 * @return the progress state
	 */
	public int getProgressState() {
		return progressState;
	}

	/**
	 * Gets the holder name.
	 *
	 * @return the holder name
	 */
	public String getHolderName() {
		return holderNameTfd.getText();
	}

	/**
	 * Gets the house name.
	 *
	 * @return the house name
	 */
	public String getHouseName() {
		return houseNameTfd.getText();
	}

	/**
	 * Gets the rooms number.
	 *
	 * @return the rooms number
	 */
	public int getRoomsNumber() {
		return (int) spinner.getValue();
	}

	/**
	 * Sets the rooms number.
	 *
	 * @param number the new rooms number
	 */
	public void setRoomsNumber(int number) {
		spinner.setValue(number);
	}

	/**
	 * Want solar panels.
	 *
	 * @return the int
	 */
	public int wantSolarPanels() { // 1 Vuole, 0 non selezionato, -1 non vuole
		if (yesBtn.isSelected() && !noBtn.isSelected()) {
			return 1;
		} else if (!yesBtn.isSelected() && noBtn.isSelected()) {
			return -1;
		}
		return 0;
	}
}

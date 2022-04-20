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

public class homePanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	Controller controller;
	private JTextField textField;
	private JTextField textField_1;
	private JButton yesBtn;
	private JButton noBtn;
	private JButton backBtn;
	private JButton proceedBtn;
	
	int flag;
	
	public homePanel(Controller controller) {
		setSize(new Dimension(430, 244));
		this.controller=controller;
		setLayout(new BorderLayout(0, 0));
		flag=1;
		JLabel titleLabel = new JLabel("CREATING A NEW HOME -> HOUSE");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(466, 400));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[82.00][41.00][][349.00,grow]", "[30.00][30.00][30.00:30.00][30.00][10.00][:37.00:30px,grow][10.00][]"));
		
		JLabel lblNewLabel = new JLabel("Holder Name");
		panel.add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 0,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("House Name");
		panel.add(lblNewLabel_1, "cell 0 1");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 3 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rooms Number");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		JSpinner spinner = new JSpinner();
		panel.add(spinner, "cell 3 2,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Solar Panels");
		panel.add(lblNewLabel_3, "cell 0 3");
		
		yesBtn = new JButton("Yes");
		panel.add(yesBtn, "flowx,cell 3 3");
		yesBtn.addActionListener(this);
		
		noBtn = new JButton("No");
		panel.add(noBtn, "cell 3 3");
		noBtn.addActionListener(this);
		
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar, "cell 0 7 4 1,growx");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		splitPane.setBorder(null);
		splitPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.add(splitPane, "cell 0 5 4 1,alignx center,growy");
		
		backBtn = new JButton("Back");
		backBtn.setMinimumSize(new Dimension(71, 23));
		backBtn.setMaximumSize(new Dimension(71, 23));
		splitPane.setLeftComponent(backBtn);
		
		proceedBtn = new JButton("Proceed");
		splitPane.setRightComponent(proceedBtn);

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
		if(e.getSource()==yesBtn) {
			if(flag==0) {
				noBtn.show();
				flag=1;
				yesBtn.setSelected(false);
			}else {
				noBtn.hide();
				flag=0;
				yesBtn.setSelected(true);
			}
		}else {
			if(flag==0) {
				yesBtn.show();
				noBtn.setSelected(false);
				flag=1;
			}else {
				yesBtn.hide();
				noBtn.setSelected(true);
				flag=0;
			}
		}
	}
}

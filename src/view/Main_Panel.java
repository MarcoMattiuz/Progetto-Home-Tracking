package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Main_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Main_Panel() {
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ciao");
		add(lblNewLabel, BorderLayout.CENTER);

	}

}

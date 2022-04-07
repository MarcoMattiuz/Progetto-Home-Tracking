package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Panel extends JPanel {

	private Controller contr;
	/**
	 * Create the panel.
	 */
	public Main_Panel(Controller controller) {
		this.contr = controller;
		
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ciao");
		add(lblNewLabel, BorderLayout.CENTER);
		
		JButton toggleTest = new JButton("toggleLightTest");
		toggleTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ciao");
				contr.ligth.toggle();
				contr.lampada.toggle();
			}
		});
		add(toggleTest, BorderLayout.EAST);

	}

}

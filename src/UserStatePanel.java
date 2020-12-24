import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class UserStatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserStatePanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Have you been tested positive or negative for COVID-19?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 80, 400, 21);
		add(lblNewLabel);
		
		JRadioButton btnNewButton = new JRadioButton("Positive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountnow.userState("yes");
				JOptionPane.showMessageDialog(null, "Your state has been updated successfully.");
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(99, 119, 89, 31);
		add(btnNewButton);
		
		JRadioButton btnNewButton_1 = new JRadioButton("Negative");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountnow.userState("no");
				JOptionPane.showMessageDialog(null, "Your state has been updated successfully.");
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(227, 119, 97, 31);
		add(btnNewButton_1);
		setVisible(true);
	}
}

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class UserStatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserStatePanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JRadioButton btnNewButton = new JRadioButton("Positive");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountnow.userState("yes");
				JOptionPane.showMessageDialog(null, "Your state has been updated successfully.");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnNewButton.setSelected(false);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 13));
		btnNewButton.setBounds(89, 119, 89, 31);
		add(btnNewButton);
		
		JRadioButton btnNewButton_1 = new JRadioButton("Negative");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountnow.userState("no");
				JOptionPane.showMessageDialog(null, "Your state has been updated successfully.");
				
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				btnNewButton_1.setSelected(false);}
			
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 13));
		btnNewButton_1.setBounds(244, 119, 97, 31);
		add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 400, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Have you been tested positive \r\nor\r\n");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(70, 11, 279, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("negative for COVID-19?");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Eras Demi ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(101, 36, 212, 17);
		panel.add(lblNewLabel_1);
		setVisible(true);
	}
}

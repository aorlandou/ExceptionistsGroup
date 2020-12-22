import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class UserStatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserStatePanel() {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("user state panel");
		lblNewLabel.setBounds(136, 119, 116, 14);
		add(lblNewLabel);
		setVisible(true);
	}

}

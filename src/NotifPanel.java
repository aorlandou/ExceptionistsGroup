import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotifPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NotifPanel() {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Notifications panel");
		lblNewLabel.setBounds(150, 158, 116, 14);
		add(lblNewLabel);
		setVisible(true);
	}

}

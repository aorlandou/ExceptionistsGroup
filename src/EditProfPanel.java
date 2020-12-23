import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditProfPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditProfPanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Profile panel");
		lblNewLabel.setBounds(150, 158, 116, 14);
		add(lblNewLabel);
		setVisible(true);
	}

}

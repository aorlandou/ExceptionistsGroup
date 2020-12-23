import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FriendsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public FriendsPanel() {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		setVisible(true);
		
		JPanel addfrPanel = new JPanel();
		addfrPanel.setBackground(new Color(192, 192, 192));
		addfrPanel.setBounds(23, 29, 174, 41);
		add(addfrPanel);
		addfrPanel.setLayout(null);
		
		JLabel lblAddFriends = new JLabel("Add Friends");
		lblAddFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFriends.setForeground(Color.WHITE);
		lblAddFriends.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		lblAddFriends.setBounds(0, 0, 174, 41);
		addfrPanel.add(lblAddFriends);
		
		JPanel showFrpanel = new JPanel();
		showFrpanel.setLayout(null);
		showFrpanel.setBackground(Color.LIGHT_GRAY);
		showFrpanel.setBounds(23, 86, 174, 41);
		add(showFrpanel);
		
		JLabel showFriends = new JLabel("Show Friends");
		showFriends.setHorizontalAlignment(SwingConstants.CENTER);
		showFriends.setForeground(Color.WHITE);
		showFriends.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		showFriends.setBounds(0, 0, 174, 41);
		showFrpanel.add(showFriends);
		
	}

}

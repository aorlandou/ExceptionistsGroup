import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class FriendsPanel extends JPanel implements ActionListener{

	private JPanel actionPanel = new JPanel();
	
	public JPanel getActionPanel() {
		return actionPanel;
	}

	public FriendsPanel(Account accountnow) {

		DB d = new DB();
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		setVisible(true);

		actionPanel.setBackground(new Color(176, 196, 222));
		actionPanel.setBounds(12, 67, 396, 277);
		add(actionPanel);
		setVisible(true);
		actionPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Friends Screen");
		lblNewLabel.setBounds(105, 5, 171, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 28));
		actionPanel.add(lblNewLabel);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 396, 264);
		actionPanel.add(panel2);
		panel2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 396, 223);
		panel2.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel addfrPanel = new JPanel();
		addfrPanel.setBackground(new Color(192, 192, 192));
		addfrPanel.setBounds(12, 13, 174, 41);
		add(addfrPanel);
		addfrPanel.setLayout(null);
		addfrPanel.addMouseListener(new MouseAdapter() { 
		     public void mousePressed(MouseEvent e) { 

		    	 	actionPanel.removeAll();
					actionPanel.add(panel2);
					actionPanel.repaint();
					actionPanel.revalidate();
		        } 
		     }); 
		
		JLabel lblAddFriends = new JLabel("Add Friends");
		lblAddFriends.setBounds(0, 0, 174, 41);
		addfrPanel.add(lblAddFriends);
		lblAddFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFriends.setForeground(Color.WHITE);
		lblAddFriends.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		
		JPanel showFrpanel = new JPanel();
		showFrpanel.setLayout(null);
		showFrpanel.setBackground(Color.LIGHT_GRAY);
		showFrpanel.setBounds(234, 13, 174, 41);
		add(showFrpanel);
		showFrpanel.addMouseListener(new MouseAdapter() { 
		     public void mousePressed(MouseEvent e) { 

		    	 	actionPanel.removeAll();
					actionPanel.add(panel2);
					actionPanel.repaint();
					actionPanel.revalidate();
					try {
						if(d.getFriends(accountnow.getPhone()).size() == 0) {
							JOptionPane.showMessageDialog(null, "Your friend list is empty. Please add some friends first.");
						}
						else {
							DefaultListModel dlm = new DefaultListModel();
							for (String s : d.getFriends(accountnow.getPhone())) {
								dlm.addElement(s + " " + d.getName(s) + " " + d.getSurname(s));
							}
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "An error has occured. Please try again.");
					}
					
		        } 
		     }); 

		
		JLabel showFriends = new JLabel("Show Friends");
		showFriends.setBounds(0, 0, 174, 41);
		showFrpanel.add(showFriends);
		showFriends.setHorizontalAlignment(SwingConstants.CENTER);
		showFriends.setForeground(Color.WHITE);
		showFriends.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}

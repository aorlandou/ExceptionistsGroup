import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;

public class MainMenuGUI extends JFrame implements ActionListener {

	private FriendsPanel frpanel;
	private UserStatePanel usrst;
	private NotifPanel notif;
	private EditProfPanel edit;
	private JPanel actionPanel = new JPanel();

	public JPanel getActionPanel() {
		return actionPanel;
	}

	private Account accountnow; // current Account

	public MainMenuGUI(Account accountnow) {
		super();
		// creation of the Account object
		this.accountnow = accountnow;

		// creating the panel objects
		frpanel = new FriendsPanel(accountnow);
		usrst = new UserStatePanel(accountnow);
		notif = new NotifPanel(accountnow);
		edit = new EditProfPanel(accountnow);

		getContentPane().setBackground(new Color(176, 196, 222));
		getContentPane().setLayout(null);
		setSize(702, 418);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 246, 379);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel WelcomeLabel = new JLabel("Welcome to \r\nMain Menu");
		WelcomeLabel.setToolTipText("Welcome\r\n");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setFont(new Font("Impact", Font.PLAIN, 23));
		WelcomeLabel.setForeground(new Color(176, 196, 222));
		WelcomeLabel.setBounds(-85, 11, 420, 59);
		panel.add(WelcomeLabel);

		JPanel friends = new JPanel();
		friends.addMouseListener(new PanelMouseAdapter(friends) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(frpanel);
			}
		});
		friends.setBackground(new Color(192, 192, 192));
		friends.setBounds(10, 82, 226, 49);
		panel.add(friends);
		friends.setLayout(null);

		JLabel friendsLabel = new JLabel("Friends");
		friendsLabel.setForeground(new Color(255, 255, 255));
		friendsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		friendsLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		friendsLabel.setBounds(0, 0, 226, 49);
		friends.add(friendsLabel);

		JPanel userState = new JPanel();
		userState.addMouseListener(new PanelMouseAdapter(userState) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(usrst);
			}
		});
		userState.setBackground(new Color(192, 192, 192));
		userState.setBounds(10, 142, 226, 49);
		panel.add(userState);
		userState.setLayout(null);

		JLabel lblUpdateUserState = new JLabel("Update User State");
		lblUpdateUserState.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateUserState.setForeground(Color.WHITE);
		lblUpdateUserState.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		lblUpdateUserState.setBounds(0, 0, 226, 49);
		userState.add(lblUpdateUserState);

		JPanel notifications = new JPanel();
		notifications.addMouseListener(new PanelMouseAdapter(notifications) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(notif);
			}
		});
		notifications.setBackground(new Color(192, 192, 192));
		notifications.setBounds(10, 202, 226, 49);
		panel.add(notifications);
		notifications.setLayout(null);

		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setForeground(Color.WHITE);
		lblNotifications.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		lblNotifications.setBounds(0, 0, 226, 49);
		notifications.add(lblNotifications);

		JPanel editProf = new JPanel();
		editProf.addMouseListener(new PanelMouseAdapter(editProf) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(edit);
			}
		});
		editProf.setBackground(new Color(192, 192, 192));
		editProf.setBounds(10, 262, 226, 49);
		panel.add(editProf);
		editProf.setLayout(null);

		JLabel lblEditProfile = new JLabel("Edit Profile");
		lblEditProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditProfile.setForeground(Color.WHITE);
		lblEditProfile.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		lblEditProfile.setBounds(0, 0, 226, 49);
		editProf.add(lblEditProfile);

		JPanel signout = new JPanel();
		signout.addMouseListener(new PanelMouseAdapter(signout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame fr = new JFrame("EXIT");
				if (JOptionPane.showConfirmDialog(fr, "Confirm if you would like to Sign Out", "EXIT",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		signout.setLayout(null);
		signout.setBackground(Color.LIGHT_GRAY);
		signout.setBounds(10, 322, 226, 49);
		panel.add(signout);

		JLabel lblsignout = new JLabel("Sign Out");
		lblsignout.setHorizontalAlignment(SwingConstants.CENTER);
		lblsignout.setForeground(Color.WHITE);
		lblsignout.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		lblsignout.setBounds(0, 0, 226, 49);
		signout.add(lblsignout);

		actionPanel.setBackground(new Color(176, 196, 222));
		actionPanel.setBounds(256, 11, 420, 357);
		getContentPane().add(actionPanel);
		actionPanel.setLayout(new CardLayout(0, 0));

		menuClicked(actionPanel);

		JLabel lblNewLabel = new JLabel("Main Menu Screen");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionPanel.add(lblNewLabel, "name_468061342384000");
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void menuClicked(JPanel selectedPanel) {
		if (selectedPanel != actionPanel) {
			actionPanel.removeAll();
			actionPanel.add(selectedPanel);
			actionPanel.repaint();
			actionPanel.revalidate();
		}
	}

	/*
	 * this class is used in order to change the colors when a panel is clicked
	 */
	private class PanelMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(192, 192, 192));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));
		}
	}
}

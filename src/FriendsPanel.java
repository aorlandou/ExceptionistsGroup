import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FriendsPanel extends JPanel implements ActionListener {

	private JPanel actionPanel = new JPanel();
	private JTextField textField;

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
		panel2.setBounds(0, 0, 396, 277);
		actionPanel.add(panel2);
		panel2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 396, 236);
		panel2.add(scrollPane);

		JList list = new JList();
		list.setCellRenderer(getRenderer());
		list.setFont(new Font("Dialog", Font.PLAIN, 14));
		list.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(list);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 396, 277);
		actionPanel.add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Your friend's phone:");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 123, 188, 42);
		panel1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 17));
		textField.setBounds(212, 123, 153, 42);
		panel1.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.BOLD, 27));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String phone = textField.getText();
				try {
					if (d.getName(phone).equals("nothing returned")) {
						JOptionPane.showMessageDialog(null,
								"Sorry but this phonenumber does not exist. Please try again.");
					} else {
						if (d.getFriends(accountnow.getPhone()).contains(phone)) {
							JOptionPane.showMessageDialog(null, "You have already added this friend.");
							textField.setText(null);
						} else {
							accountnow.friends.add(phone);
							d.insertFriend(accountnow.getPhone(), phone);
							JOptionPane.showMessageDialog(null, "Your friend has been added successfully.");
							textField.setText(null);
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "An error has occured. Please try again.");
				}
			}
		});
		btnNewButton.setBounds(131, 178, 153, 42);
		panel1.add(btnNewButton);

		JPanel addfrPanel = new JPanel();
		addfrPanel.setBackground(new Color(192, 192, 192));
		addfrPanel.setBounds(12, 13, 174, 41);
		add(addfrPanel);
		addfrPanel.setLayout(null);
		addfrPanel.addMouseListener(new PanelMouseAdapter(addfrPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {

				actionPanel.removeAll();
				actionPanel.add(panel1);
				actionPanel.repaint();
				actionPanel.revalidate();
				textField.setVisible(true);
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
		showFrpanel.addMouseListener(new PanelMouseAdapter(showFrpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {

				actionPanel.removeAll();
				actionPanel.add(panel2);
				actionPanel.repaint();
				actionPanel.revalidate();
				try {
					if (d.getFriends(accountnow.getPhone()).size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Your friend list is empty. Please add some friends first.");
					} else {
						DefaultListModel dlm = new DefaultListModel();
						for (String s : d.getFriends(accountnow.getPhone())) {
							dlm.addElement(s + " " + d.getName(s) + " " + d.getSurname(s));
							list.setModel(dlm);
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

	public void actionPerformed(ActionEvent e) {

	}

	private ListCellRenderer<? super String> getRenderer() {
		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
				return listCellRendererComponent;
			}
		};
	}

}

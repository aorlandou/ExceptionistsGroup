import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import java.util.ArrayList;


public class NotifPanel extends JPanel {
	private JTable table;
	private ArrayList<String> notifications;
	/**
	 * Create the panel.
	 */
	public NotifPanel(Account accountnow) {
		
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 396, 223);
		add(scrollPane);
		JList list = new JList();
		list.setBounds(10, 60, 400, 268);
		add(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(new Color(0, 128, 128));
		scrollPane.setViewportView(list);
		
		notifications = new ArrayList<String>();
		notifications = (ArrayList<String>) accountnow.getNotifications();
		Collections.sort(notifications);
		
		try {
			if (accountnow.getNotifications().size() == 0) {
				JOptionPane.showMessageDialog(null, "You don't have any notifications yet");
			} else {
				DefaultListModel dlm = new DefaultListModel();
				for(String s : notifications) {
					dlm.addElement(s);
					list.setModel(dlm);
				}
				//dlm.addElement(accountnow.getNotifications());
				//list.setModel(dlm);

			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "An error has occured. Please try again.");
		}
   

		
		JLabel Notifications = new JLabel("Notifications");
		Notifications.setFont(new Font("Calibri Light", Font.BOLD, 24));
		Notifications.setBounds(65, 10, 211, 39);
		add(Notifications);
		
	}
}

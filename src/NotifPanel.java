import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
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
import javax.swing.ListCellRenderer;

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
		scrollPane.setBounds(10, 41, 400, 305);
		add(scrollPane);
		JList list = new JList();
		list.setCellRenderer(getRenderer());
		list.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		list.setBounds(10, 60, 400, 268);
		list.setBorder(new LineBorder(Color.DARK_GRAY));
		list.setBackground(new Color(211, 211, 211));
		scrollPane.setViewportView(list);

		notifications = new ArrayList<String>();
		notifications = (ArrayList<String>) accountnow.getNotifications();
		Collections.sort(notifications);

		try {
			if (accountnow.getNotifications().size() == 0) {
				JOptionPane.showMessageDialog(null, "You don't have any notifications yet");
			} else {
				DefaultListModel dlm = new DefaultListModel();
				for (int i = 0; i < notifications.size(); i++) {
					dlm.addElement(notifications.get(notifications.size() - (i + 1)));
					list.setModel(dlm);
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "An error has occured. Please try again.");
		}

		JLabel Notifications = new JLabel("Notifications");
		Notifications.setForeground(new Color(255, 255, 255));
		Notifications.setFont(new Font("Eras Bold ITC", Font.PLAIN, 24));
		Notifications.setBounds(10, 11, 184, 24);
		add(Notifications);

	}

	private ListCellRenderer<? super String> getRenderer() {
		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.DARK_GRAY));
				return listCellRendererComponent;
			}
		};
	}
}

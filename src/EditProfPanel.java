import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProfPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditProfPanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Profile ");
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 24));
		lblNewLabel.setBounds(136, 22, 274, 37);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Change Name");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 81, 168, 21);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Change Surname");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 123, 168, 21);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Change Password");
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(20, 160, 168, 30);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Change Municipality");
		lblNewLabel_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(20, 206, 204, 30);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Delete your profile");
		lblNewLabel_1_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(20, 251, 168, 30);
		add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Finish profile editing");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1_1.setBounds(20, 296, 204, 30);
		add(lblNewLabel_1_2_1_1_1);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Please enter the name");
				/* this.name=JOptionPane.showInputDialog("Please enter the name");
			    data.updateName(phone,name);
				*/
				JOptionPane.showInternalMessageDialog(null, "Name has been changed successfully.");
			}
		});
		btn1.setBounds(303, 80, 85, 21);
		add(btn1);
		
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tring surname = JOptionPane.showInputDialog("Please enter the surname");
				/* this.surname=JOptionPane.showInputDialog("Please enter the surname");
					data.updateSurname(phone, surname);
					*/
				JOptionPane.showInternalMessageDialog(null, "Surname has been changed successfully.");
			}
		});
		btn2.setBounds(303, 122, 85, 21);
		add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = JOptionPane.showInputDialog("Please enter the new password");
				String password2;
				do {
					password2 = JOptionPane.showInputDialog("Please enter your password again to confirm");

				} while (!password2.equals(password));
				/* this.password=password2;
				   data.updatePassword(phone, password);
						*/
				JOptionPane.showInternalMessageDialog(null, "Password has been changed successfully.");
			}
		});
		btn3.setBounds(303, 164, 85, 21);
		add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String municipality = JOptionPane.showInputDialog("Please enter the municipality");
				/* this.municipality=OptionPane.showInputDialog("Please enter the surname");
					data.updateMunicipality(phone, municipality);
					*/
				JOptionPane.showInternalMessageDialog(null, "Municipality has been changed successfully.");
			}
		});
		btn4.setBounds(303, 206, 85, 21);
		add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = JOptionPane.showInputDialog("Do you want to delete your profile? If so, enter your password.");
				/*if(pass.equals(this.password)){
						 try {
							data.deleteAcc(phone);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/ 
				JOptionPane.showInternalMessageDialog(null, "Account has been deleted successfully.");
				/* System.exit(0); */
			}
		});
		btn5.setBounds(303, 251, 85, 21);
		add(btn5);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Profile editing finished.");
				/* MainMenu User = new MainMenu(user);
				User.printMenu();
			} */
			}
		});
		btn0.setBounds(303, 289, 85, 21);
		add(btn0);
		setVisible(true);
	}
}

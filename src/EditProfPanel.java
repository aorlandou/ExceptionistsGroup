import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class EditProfPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditProfPanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		DB data = new DB();//initialization of DB object
		
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
				/* this.name=JOptionPane.showInputDialog("Please enter the name");*/
				try {
					data.updateName(accountnow.getPhone(), name);
					JOptionPane.showMessageDialog(null, "Name has been changed successfully.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btn1.setBounds(303, 80, 85, 21);
		add(btn1);
		
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String surname = JOptionPane.showInputDialog("Please enter the surname");
				/* this.surname=JOptionPane.showInputDialog("Please enter the surname");*/
				try {
					data.updateSurname(accountnow.getPhone(), surname);
					JOptionPane.showMessageDialog(null, "Surname has been changed successfully.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btn2.setBounds(303, 122, 85, 21);
		add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = JOptionPane.showInputDialog("Please enter the new password");
				String password2;
				password2 = JOptionPane.showInputDialog("Please enter your password again to confirm");
				if (password.equals(password2)) {
					try {
						data.updatePassword(accountnow.getPhone(), password);
						JOptionPane.showMessageDialog(null, "Password has been changed successfully.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}else {
					int count = 3;
					boolean cor = false;
					while (count > 0 && cor == false) {
						String pass1, pass2;
						pass1 = JOptionPane.showInputDialog(null,"Wrong password.\n"
						+"You have " + count + " trial(s) left to enter your new " + "password correctly.\n"
						+"Please try again and enter a new password.");
						
						pass2 = JOptionPane.showInputDialog("Please enter the new password again.");
						
						if (pass1.equals(pass2)) {
							password = pass1;
							try {
								data.updatePassword(accountnow.getPhone(), password);
								JOptionPane.showMessageDialog(null, "Password has been changed successfully.");
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, ex);
							}
							
							cor = true;
						} else {
							count--;
						}
					}
					if (count == 0) {
						JOptionPane.showMessageDialog(null, "You exceeded the number of trials you had to change "
								+ "your password. \nYou are redirected back to PROFILE EDITING...");
					}
				}
			}
		});
		btn3.setBounds(303, 164, 85, 21);
		add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String municipality = JOptionPane.showInputDialog("Please enter the municipality");
				/* this.municipality=OptionPane.showInputDialog("Please enter the surname");*/
				try {
					data.updateMunicipality(accountnow.getPhone(), municipality);
					JOptionPane.showMessageDialog(null, "Municipality has been changed successfully.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		btn4.setBounds(303, 206, 85, 21);
		add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = JOptionPane.showInputDialog("Do you want to delete your profile? If so, enter your password.");
				if(pass.equals(accountnow.getPassword())){
					try {
						data.deleteAcc(accountnow.getPhone());
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				
				JOptionPane.showMessageDialog(null, "Account has been deleted successfully.");
				
			}
		});
		btn5.setBounds(303, 251, 85, 21);
		add(btn5);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Profile editing finished.");
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

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EditProfPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditProfPanel(Account accountnow) {
		setBounds(0, 0, 420, 357);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		DB data = new DB();//initialization of DB object
		
		JLabel editprofLabel = new JLabel("Edit Profile ");
		editprofLabel.setSize(182, 52);
		editprofLabel.setLocation(10, 18);
		editprofLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editprofLabel.setForeground(Color.WHITE);
		editprofLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 24));
		add(editprofLabel);
		
		JButton changeNamebtn = new JButton("Change Name");
		changeNamebtn.setForeground(new Color(47, 79, 79));
		changeNamebtn.setBackground(new Color(192, 192, 192));
		changeNamebtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		changeNamebtn.addActionListener(new ActionListener() {
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
		changeNamebtn.setBounds(20, 81, 156, 31);
		add(changeNamebtn);
		
		
		JButton changeSurbtn = new JButton("Change Surname");
		changeSurbtn.setForeground(new Color(47, 79, 79));
		changeSurbtn.setBackground(new Color(192, 192, 192));
		changeSurbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		changeSurbtn.addActionListener(new ActionListener() {
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
		changeSurbtn.setBounds(20, 123, 156, 31);
		add(changeSurbtn);
		
		JButton changePassbtn = new JButton("Change Password");
		changePassbtn.setForeground(new Color(47, 79, 79));
		changePassbtn.setBackground(new Color(192, 192, 192));
		changePassbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		changePassbtn.addActionListener(new ActionListener() {
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
		changePassbtn.setBounds(20, 165, 156, 31);
		add(changePassbtn);
		
		JButton changeMunbtn = new JButton("Change Municipality");
		changeMunbtn.setForeground(new Color(47, 79, 79));
		changeMunbtn.setBackground(new Color(192, 192, 192));
		changeMunbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		changeMunbtn.addActionListener(new ActionListener() {
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
		changeMunbtn.setBounds(20, 207, 156, 31);
		add(changeMunbtn);
		
		JButton deleteProfbtn = new JButton("Delete your profile");
		deleteProfbtn.setForeground(new Color(47, 79, 79));
		deleteProfbtn.setBackground(new Color(192, 192, 192));
		deleteProfbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		deleteProfbtn.addActionListener(new ActionListener() {
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
		deleteProfbtn.setBounds(20, 249, 156, 31);
		add(deleteProfbtn);
		
		JButton finishbtn = new JButton("Finish profile editing");
		finishbtn.setForeground(new Color(47, 79, 79));
		finishbtn.setBackground(new Color(192, 192, 192));
		finishbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		finishbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Profile editing finished.");
				/* MainMenu User = new MainMenu(user);
				User.printMenu();
			} */
			}
		});
		finishbtn.setBounds(20, 290, 156, 31);
		add(finishbtn);
		setVisible(true);
	}
}

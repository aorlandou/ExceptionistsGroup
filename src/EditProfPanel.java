import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class EditProfPanel extends JPanel {
	private MainMenuGUI m;
	private JTextField txtTypeName;
	private JTextField txtTypeSurname;
	private JTextField txtTypeMun;
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
				String name = txtTypeName.getText();
				accountnow.setName(name);
				try {
					data.updateName(accountnow.getPhone(), name);
					JOptionPane.showMessageDialog(null, "Name has been changed successfully.");
					txtTypeName.setText(null);
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
				String surname = txtTypeSurname.getText();
				accountnow.setSurname(surname);
				try {
					data.updateSurname(accountnow.getPhone(), surname);
					JOptionPane.showMessageDialog(null, "Surname has been changed successfully.");
					txtTypeSurname.setText(null);
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
								accountnow.setPassword(password);
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
		changePassbtn.setBounds(20, 207, 156, 31);
		add(changePassbtn);
		
		JButton changeMunbtn = new JButton("Change Municipality");
		changeMunbtn.setForeground(new Color(47, 79, 79));
		changeMunbtn.setBackground(new Color(192, 192, 192));
		changeMunbtn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		changeMunbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String municipality = txtTypeMun.getText();
				accountnow.setMunicipality(municipality);
				try {
					data.updateMunicipality(accountnow.getPhone(), municipality);
					JOptionPane.showMessageDialog(null, "Municipality has been changed successfully.");
					txtTypeMun.setText(null);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		changeMunbtn.setBounds(20, 165, 156, 31);
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
						JFrame fr = new JFrame("Exiting our application...");
						JOptionPane.showMessageDialog(fr, "Your account has been deleted successfully!\n"
								+ "Thank you for using our application.");
						System.exit(0);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
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
				hide();
				m =  new MainMenuGUI(accountnow);
				m.getActionPanel().setVisible(true);
				//JOptionPane.showMessageDialog(null, "Profile editing finished.");
				 //MainMenu User = new MainMenu(user);
				//User.printMenu();
			}
			
		});
		finishbtn.setBounds(20, 290, 156, 31);
		add(finishbtn);
		
		txtTypeName = new JTextField();
		txtTypeName.setToolTipText("");
		txtTypeName.setForeground(new Color(47, 79, 79));
		txtTypeName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtTypeName.setBackground(new Color(211, 211, 211));
		txtTypeName.setBounds(175, 81, 218, 31);
		add(txtTypeName);
		txtTypeName.setColumns(10);
		
		txtTypeSurname = new JTextField();
		txtTypeSurname.setForeground(new Color(47, 79, 79));
		txtTypeSurname.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtTypeSurname.setColumns(10);
		txtTypeSurname.setBackground(new Color(211, 211, 211));
		txtTypeSurname.setBounds(175, 123, 218, 31);
		add(txtTypeSurname);
		
		txtTypeMun = new JTextField();
		txtTypeMun.setForeground(new Color(47, 79, 79));
		txtTypeMun.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtTypeMun.setColumns(10);
		txtTypeMun.setBackground(new Color(211, 211, 211));
		txtTypeMun.setBounds(175, 165, 218, 31);
		add(txtTypeMun);
		setVisible(true);
	}
}

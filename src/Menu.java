import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;



import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Menu {

	protected Shell shlProfileEdit;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Menu window = new Menu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlProfileEdit.open();
		shlProfileEdit.layout();
		while (!shlProfileEdit.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlProfileEdit = new Shell();
		shlProfileEdit.setSize(442, 396);
		shlProfileEdit.setText("PROFILE EDIT");
		
		Label ch_name1 = new Label(shlProfileEdit, SWT.NONE);
		ch_name1.setText("Change Name");
		ch_name1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		ch_name1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ch_name1.setBounds(10, 10, 132, 30);
		
		Label ch_surname2 = new Label(shlProfileEdit, SWT.NONE);
		ch_surname2.setText("Change Surname");
		ch_surname2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		ch_surname2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ch_surname2.setBounds(10, 53, 146, 30);
		
		Label ch_pass3 = new Label(shlProfileEdit, SWT.NONE);
		ch_pass3.setText("Change Password");
		ch_pass3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		ch_pass3.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ch_pass3.setBounds(10, 96, 156, 30);
		
		Label ch_muni4 = new Label(shlProfileEdit, SWT.NONE);
		ch_muni4.setText("Change Municipality");
		ch_muni4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		ch_muni4.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ch_muni4.setBounds(10, 140, 170, 30);
		
		Label delprof5 = new Label(shlProfileEdit, SWT.NONE);
		delprof5.setText("Delete your profile");
		delprof5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		delprof5.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		delprof5.setBounds(10, 183, 170, 30);
		
		Label finish0 = new Label(shlProfileEdit, SWT.NONE);
		finish0.setText("Finish profile editing");
		finish0.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		finish0.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		finish0.setBounds(10, 224, 170, 30);
		
		Button btn1 = new Button(shlProfileEdit, SWT.NONE);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String name = JOptionPane.showInputDialog("Please enter the name");
				/* this.name=JOptionPane.showInputDialog("Please enter the name");
			    data.updateName(phone,name);
				*/
				JOptionPane.showInternalMessageDialog(null, "Name has been changed successfully.");
			}
		});
	
	
		btn1.setBounds(305, 10, 90, 30);
		btn1.setText("1");
		
		Button btn2 = new Button(shlProfileEdit, SWT.NONE);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String surname = JOptionPane.showInputDialog("Please enter the surname");
				/* this.surname=JOptionPane.showInputDialog("Please enter the surname");
					data.updateSurname(phone, surname);
					*/
				JOptionPane.showInternalMessageDialog(null, "Surname has been changed successfully.");
			}
		});
		btn2.setText("2");
		btn2.setBounds(305, 53, 90, 30);
		
		Button btn3 = new Button(shlProfileEdit, SWT.NONE);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
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
		btn3.setText("3");
		btn3.setBounds(305, 96, 90, 30);
		
		Button btn4 = new Button(shlProfileEdit, SWT.NONE);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String municipality = JOptionPane.showInputDialog("Please enter the municipality");
				/* this.municipality=OptionPane.showInputDialog("Please enter the surname");
					data.updateMunicipality(phone, municipality);
					*/
				JOptionPane.showInternalMessageDialog(null, "Municipality has been changed successfully.");
			}
		});
		btn4.setText("4");
		btn4.setBounds(305, 140, 90, 30);
		
		Button btn5 = new Button(shlProfileEdit, SWT.NONE);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
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
		btn5.setText("5");
		btn5.setBounds(305, 183, 90, 30);
		
		Button btn0 = new Button(shlProfileEdit, SWT.NONE);
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Profile editing finished.");
				/* MainMenu User = new MainMenu(user);
				User.printMenu();
			} */
			}
		});
		btn0.setText("0");
		btn0.setBounds(305, 224, 90, 30);

	}
}

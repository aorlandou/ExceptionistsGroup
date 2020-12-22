
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;


public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;

	 //Connecting to our database
	 //DB data = new DB();
	 //data.getConnection();

	public Main() {
		super();
		getContentPane().setBackground(new Color(192, 192, 192));
		setSize(386, 205);
		setTitle("COVID-19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton Sign_up = new JButton("Sign up");
		Sign_up.setBounds(85, 89, 82, 29);
		Sign_up.setForeground(new Color(0, 0, 0));
		Sign_up.setBackground(new Color(119, 136, 153));
		Sign_up.addActionListener(this);
		getContentPane().setLayout(null);
		JLabel label = new JLabel(
				"Press one button to start!");
		label.setBounds(95, 30, 198, 24);
		label.setFont(new Font("Impact", Font.PLAIN, 19));
		getContentPane().add(label);
		getContentPane().add(Sign_up);
		JButton Log_in = new JButton("Login");
		Log_in.setBounds(221, 89, 82, 29);
		Log_in.setBackground(new Color(119, 136, 153));
		Log_in.addActionListener(this);
		getContentPane().add(Log_in);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonType = e.getActionCommand();
		switch (buttonType) {
		case "Sign up":
			SignUp.creatAccount();
			break;
		case "Login":
			Login log = new Login();
			log.loginmethod();
			break;
		}
	}
	public static void main(String[] args) {
		Main w = new Main();
		w.setVisible(true);
	}
}


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;


public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;

	 //Connecting to our database
	 //DB data = new DB();
	 //data.getConnection();

	public Main() {
		super();
		getContentPane().setBackground(SystemColor.windowBorder);
		setSize(417, 234);
		setTitle("COVID-19");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JButton Sign_up = new JButton("Sign up");
		Sign_up.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		Sign_up.setBounds(209, 80, 113, 46);
		Sign_up.setForeground(Color.WHITE);
		Sign_up.setBackground(SystemColor.controlDkShadow);
		Sign_up.addActionListener(this);
		getContentPane().setLayout(null);
		JLabel label = new JLabel(
				"Press one button to start!");
		label.setForeground(SystemColor.activeCaption);
		label.setBounds(60, 11, 268, 58);
		label.setFont(new Font("Eras Bold ITC", Font.BOLD, 19));
		getContentPane().add(label);
		getContentPane().add(Sign_up);
		JButton Log_in = new JButton("Login");
		Log_in.setForeground(Color.WHITE);
		Log_in.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		Log_in.setBounds(60, 80, 113, 46);
		Log_in.setBackground(SystemColor.controlDkShadow);
		Log_in.addActionListener(this);
		getContentPane().add(Log_in);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonType = e.getActionCommand();
		switch (buttonType) {
		case "Sign up":
			closeW();
			SignUpwithgraphics obj = new SignUpwithgraphics();
			obj.setVisible(true);
			break;
		case "Login":
			closeW();
			Login log = new Login();
			log.loginmethod();
			break;
		}
	}
	public void closeW() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public static void main(String[] args) {
		Main w = new Main();
		w.setVisible(true);
	}
}

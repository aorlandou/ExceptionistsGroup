
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;

	 //Connecting to our database
	 //DB data = new DB();
	 //data.getConnection();

	public Main() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("COVID-19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JLabel label = new JLabel(
				"Press one button to start!");
		add(label);
		JButton Sign_up = new JButton("Sign up");
		Sign_up.addActionListener(this);
		add(Sign_up);
		JButton Log_in = new JButton("Login");
		Log_in.addActionListener(this);
		add(Log_in);
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

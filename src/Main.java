import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Main extends JFrame implements ActionListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;

	public Main() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Window");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new FlowLayout());
		JLabel label = new JLabel("Select your choice: ");
		add(label);
		JButton button1 = new JButton("[1] Sign Up");
		button1.addActionListener(this);
		add(button1);
		JButton button2 = new JButton("[2] Login to your account");
		button2.addActionListener(this);
		add(button2);

	}

	public void actionPerformed(ActionEvent e) {
		String buttonType = e.getActionCommand();
		switch (buttonType) {
		case "[1] Sign Up":
			SignUp.creatAccount();
			break;
		case "[2] Login to your account":
			Login loginObj = new Login(); // create object for Login class
			loginObj.loginmethod(); // call loginMethod to start the process of Login
			break;
		}
	}

	public static void main(String[] args) {
		Main w = new Main();
		w.setVisible(true);
	}
}

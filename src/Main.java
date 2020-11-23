import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import databaseConnection.DB;

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
	
	
		//Connecting to our database
		//DB data = new DB();
		//data.getConnection();
		public Main( ) {
		super( );
		JFrame jf = new JFrame("Window");
        JLabel label = new JLabel("If you want to sign in press 1, if you want to log in press 2");
        jf.add(label);
        jf.setBounds(0, 0, 700, 100);
        jf.setLayout(new FlowLayout());
        JButton button1 = new JButton("button 1");
        JButton button2 = new JButton("button 2");
   
        button1.addActionListener(this);
        add(button1);
        button2.addActionListener(this);
        add(button2);
		
	}
	public void actionPerformed(ActionEvent e) {
		String buttonType = e.getActionCommand();
		switch (buttonType) {
		case "button 1":
			SignIn.creatAccount();
			SignUp.creatAccount();
			break;
		case "button 2":
			LogIn.enterAccount();
			Login.loginMethod();
			break;
		}
	}
	public static void main(String[] args) {
		DB data = new DB();
		data.getConnection();
		JFrame jf = new JFrame("Window");
		jf.setVisible(true);
	}
}


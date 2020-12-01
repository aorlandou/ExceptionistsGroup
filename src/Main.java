import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import databaseConnection.DB;

=======

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

	
	//Connecting to our database
	DB data = new DB();
	data.getConnection();
	public Main( ) {
	super( );
	setSize(WIDTH, HEIGHT);
	setTitle("Window");
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setLayout(new FlowLayout());
	JLabel label = new JLabel("If you want to sign in press 1, if you want to log in press 2");
	add(label);
	JButton button1 = new JButton("button 1");
	button1.addActionListener(this);
    add(button1); 
    JButton button2 = new JButton("button 2");
    button2.addActionListener(this);
    add(button2);
    
	
}
	public void actionPerformed(ActionEvent e) {
		String buttonType = e.getActionCommand();
		switch (buttonType) {
		case "button 1":
			SignUp.creatAccount();
			break;
		case "button 2":
			Login.loginMethod();
			break;
		
		}
	}
	public static void main(String[] args) {
		DB data = new DB();
		data.getConnection();
		Main w = new Main();
		w.setVisible(true);
	}
}

import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import databaseConnection.DB;
import testaki.testaki;
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

	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;
	
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
			SignIn.creatAccount();
=======
	public static void main(String[] args) throws InputMismatchException {
		//Connecting to our database
		DB data = new DB();
		
		
		int choice;
JFrame jf = new JFrame("If you want to sign in press 1, if you want to log in press 2");
        
        jf.setBounds(0, 0, 700, 100);
        
        jf.setLayout(new FlowLayout());
        jf.add(new JButton("button 1"));
        jf.add(new JButton("button 2"));
        jf.setVisible(true);
		Scanner sc = new Scanner(System.in);
		do{
			try
			{
				choice = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter a valid answer"); 
		    	choice = sc.nextInt();
			}
		}while(choice != 1 && choice != 2);
		if (choice == 1) {

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
		Main w = new Main();
		w.setVisible(true);
	}
}


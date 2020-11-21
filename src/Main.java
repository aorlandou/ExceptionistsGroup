import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;

import databaseConnection.DB;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Main {
	
	public static void main(String[] args) throws InputMismatchException {
		//Connecting to our database
		DB data = new DB();
		data.getConnection();
		
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
		}
		if (choice == 2) {
			Login.loginMethod();
		}
	}
}


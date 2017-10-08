//did it work?
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountManager extends JPanel {
	JPanel defaultPanel;
	JLabel defaultMessage;
	
	JPanel signInPanel;
	JPanel signUpPanel;
	
	JPanel loginContainer;
	JPanel signUpContainer;
	
	JLabel usernameSignIn;
	JLabel emailSignIn;
	JLabel passwordSignIn;
	JLabel notificationSignIn;
	
	JTextField uSignInField;
	JTextField eSignInField;
	JTextField pSignInField;
	
	JLabel usernameSignUp;
	JLabel emailSignUp;
	JLabel passwordSignUp;
	JLabel notificationSignUp;
	
	JTextField uSignUpField;
	JTextField eSignUpField;
	JTextField pSignUpField;
	
	JButton signInButton;
	JButton signUpButton;
	
	public AccountManager(){
		signUpPanel = new JPanel();
		signInPanel = new JPanel();
		defaultPanel = new JPanel();
		loginContainer = new JPanel();
		signUpContainer = new JPanel();
		defaultMessage = new JLabel("<html>Welcome to Diophantus' Mind<br></br>"
				+ "The interactive tutoring system<br></br><br>"
				+ "</br>Get ready to learn!");
		
		usernameSignIn = new JLabel("Username: ");
		emailSignIn = new JLabel("Email: ");
		passwordSignIn = new JLabel("Password: ");
		notificationSignIn = new JLabel("");
		
		uSignInField = new JTextField(30);
		eSignInField = new JTextField(30);
		pSignInField = new JTextField(30);
		
		usernameSignUp = new JLabel("Username: ");
		emailSignUp = new JLabel("Email: ");
		passwordSignUp = new JLabel("Password: ");
		notificationSignUp = new JLabel("");
		
		uSignUpField = new JTextField(30);
		eSignUpField = new JTextField(30);
		pSignUpField = new JTextField(30);
		
		signInButton = new JButton("Sign In");
		signUpButton = new JButton("Sign Up");
		
		createDefaultPanel();
		createSignInPanel();
		createSignUpPanel();
		
		add(defaultPanel);
	}
	public void createDefaultPanel(){
		defaultPanel.setLayout(new BorderLayout(1,1));
		defaultPanel.add(defaultMessage);
	}
	
	public void createSignInPanel(){
		signInPanel.setLayout(new GridLayout(2,1));

		loginContainer.setLayout(new GridLayout(4,2));
		
		loginContainer.add(usernameSignIn);
		loginContainer.add(uSignInField);
		loginContainer.add(emailSignIn);
		loginContainer.add(eSignInField);
		loginContainer.add(passwordSignIn);
		loginContainer.add(pSignInField);
		loginContainer.add(notificationSignIn);
		loginContainer.add(signInButton);
		
		signInPanel.add(new JLabel("Sign in here!"));
		signInPanel.add(loginContainer);
		
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				signIn();
			}
		});
	}
	
	public void createSignUpPanel(){
		signUpPanel.setLayout(new GridLayout(2,1));
		signUpContainer.setLayout(new GridLayout(4,2));
		
		signUpContainer.add(usernameSignUp);
		signUpContainer.add(uSignUpField);
		signUpContainer.add(emailSignUp);
		signUpContainer.add(eSignUpField);
		signUpContainer.add(passwordSignUp);
		signUpContainer.add(pSignUpField);
		signUpContainer.add(notificationSignUp);
		signUpContainer.add(signUpButton);
		
		signUpPanel.add(new JLabel("Sign up here!"));
		signUpPanel.add(signUpContainer);
		
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				signUp();
			}
		});
		
	}
	
	public void signIn(){
		if(uSignInField.getText().isEmpty() || 
		   eSignInField.getText().isEmpty() || 
		   pSignInField.getText().isEmpty())
		{
			notificationSignIn.setText("Fill all fields.");
			Color red = new Color(175, 0, 0);
			notificationSignIn.setForeground(red);
			updateUI();
		}
		else{
			String username = uSignInField.getText();
			String email = eSignInField.getText();
			String password = pSignInField.getText();
			User currentUser = new User(username, email, password);

			if(currentUser.checkUser(currentUser)){
				notificationSignIn.setText("User was found.");
				Color green = new Color(0, 100, 0);
				notificationSignIn.setForeground(green);
				updateUI();
			}
			else{
				notificationSignIn.setText("User not found.");
				Color red = new Color(175, 0, 0);
				notificationSignIn.setForeground(red);
				updateUI();
				pSignInField.setText("");
			}
		}
		
	}
	public void signUp(){
		//checks for all fields to have input
		if(uSignUpField.getText().isEmpty() || 
		   eSignUpField.getText().isEmpty() || 
		   pSignUpField.getText().isEmpty())
		{	
			notificationSignUp.setText("Fill all fields.");
			Color red = new Color(175, 0, 0);
			notificationSignUp.setForeground(red);
			updateUI();
		}
		else{
			String username = uSignUpField.getText();
			String email = eSignUpField.getText();
			String password = pSignUpField.getText();
			User currentUser = new User(username, email, password);
			//create new user account
			if(currentUser.storeUser(currentUser)){
				notificationSignUp.setText("Account created.");
				Color green = new Color(0, 100, 0);
				notificationSignUp.setForeground(green);
				updateUI();
			}
			//if account exists
			else{
				notificationSignUp.setText("Account exists.");
				Color red = new Color(175, 0, 0);
				notificationSignUp.setForeground(red);
				updateUI();
			}
			uSignUpField.setText("");
			eSignUpField.setText("");
			pSignUpField.setText("");
		}
	}
	public void changeState(int state){
		if(state == 1){
			removeAll();
			uSignInField.setText("");
			eSignInField.setText("");
			pSignInField.setText("");
			notificationSignIn.setText("");
			add(signInPanel);
			updateUI();
		}
		else if(state == 2){
			removeAll();
			uSignUpField.setText("");
			eSignUpField.setText("");
			pSignUpField.setText("");
			notificationSignUp.setText("");
			add(signUpPanel);
			updateUI();
		}
		else{
			removeAll();
			add(defaultPanel);
			updateUI();
		}
	}
}

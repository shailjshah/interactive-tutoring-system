import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	private String username;
	private String email;
	private String password;
	private int score;
	private int highScore;
	
	public User(){
		username = "";
		email = "";
		password = "";
		score = 0;
		highScore = 0;
	}
	public User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = 0;
	}
	
	public boolean storeUser(User user){
		//if user does not exist store them
		if(!checkUser(user)){
			try {
				FileWriter fw = new FileWriter(new File("src/resources/users.csv"), true);
				StringBuilder sb = new StringBuilder();
				sb.append(user.username + ",");
				sb.append(user.email + ",");
				sb.append(user.password + ",");
				sb.append(user.highScore + "\n");
				
				fw.append(sb.toString());
				fw.close();
			} catch (IOException e) {
				System.out.println("IO Exception");
			}
			
			System.out.println("Successfully stored user.");
			return true;
		}
		else{
			System.out.println("User already exists.");
			return false;
		}
	}
	
	public boolean checkUser(User user){
		try {
			Scanner scanner = new Scanner(new File("src/resources/users.csv"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()){
				String row = scanner.nextLine();
				String[] userInfo = row.split(",");
				if(user.username.equals(userInfo[0]) && user.password.equals(userInfo[2])){
					//User found
					return true;
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		}
		//User not found
		return false;
	}
	
	public void updateScore(User user, int questionNumber){
		user.score = user.score + (10 * questionNumber);
	}
	
	public void storeHighScore(User user){
		if(user.score > user.highScore){
			user.highScore = user.score;
			//stores user twice, will fix later.
			storeUser(user);
		}
	}
}

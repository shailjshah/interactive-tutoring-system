
/**
 * The Tutor class displays the name of the author on the first panel,
 * and then 4 different HTML pages depending on the value of the slider.
 * The tutor class uses JEditorPanes to show the HTML and has error catching
 * to make sure that the HTML file could be read.
 * 
 * Completion Time: 5 hours
 * 
 * @author Ryan Christensen
 * @version 1.0
 */

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

public class Tutor extends JPanel {
	JPanel zeroState;
	JEditorPane site;
	
	JLabel styledPanel;
	
	public Tutor(){
		styledPanel = new JLabel(new ImageIcon(getClass().getResource("/resources/ryan.jpg")));
		zeroState = new JPanel();
		zeroState.add(styledPanel);
		add(zeroState);
	}
	public void changeState(int state){
		//changes what is displayed to reflect the value of the state.
		if(state == 0){
			removeAll();
			add(zeroState);
		}
		else{
			removeAll();
			site = createEditorPane(state);
			add(site);
		}
	}
	
	//Method to create a JEditorPane for each possible HTML file
	public JEditorPane createEditorPane(int page){	
		JEditorPane currentSite = new JEditorPane();
		currentSite.setEditable(false);
		currentSite.setEditorKit(new HTMLEditorKit());
		
		//Takes page as a parameter to determine which HTML file to use
		String htmlFile = "src/resources/p" + page + ".html";
		FileReader reader = null;
		try{
			reader = new FileReader(htmlFile);
		} catch (FileNotFoundException e){
			System.err.println("File not found.");
		}
		try{
			currentSite.read(reader, htmlFile);
		} catch(IOException e){
			System.err.println("IO Exception.");
		}
		//returns the JEditorPane
		return currentSite;
	}
}
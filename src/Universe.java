/**
* Universe class is a JFrame window that hosts the companion, tutor, and assessor classes
* in a gridLayout. There is a JSlider on the bottom of the window that changes the content
* of each JPanel depending on the value of slider.
* 
* Assignment number: Recitation Project 1
* 
* Completion time: 10 hours
*
* @author Ryan Christensen
* @version 1.0
**/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class Universe extends JFrame{
	//Initialize the variables used in the Universe constructor
	JFrame universeFrame;
	JTextArea textArea;
	JSlider slider;
	JPanel myNamePanel, gridContainer;
	JLabel myName;
	JLabel styledPanel;
	
	Companion companionPanel;
	Tutor tutorPanel;
	Assessor assessorPanel;
	AccountManager accountPanel;
		
	public Universe(){
		//JFrame Window configuration
		universeFrame = new JFrame("Project 1");
		universeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//universeFrame.setResizable(false);
		universeFrame.setSize(1200,1000);
		universeFrame.setPreferredSize(new Dimension(1200, 1000));
		
		//Initializing the Tutor, Assessor, and Companion JPanels
		tutorPanel = new Tutor();
		tutorPanel.setLayout(new GridBagLayout());
		companionPanel = new Companion();
		companionPanel.setLayout(new GridBagLayout());
		assessorPanel = new Assessor();
		assessorPanel.setLayout(new GridBagLayout());
		accountPanel = new AccountManager();
		accountPanel.setLayout(new GridBagLayout());
		
		//Initialize the myNamePanel to contain my name
		styledPanel = new JLabel(new ImageIcon(getClass().getResource("/resources/ryan.jpg")));
		myNamePanel = new JPanel();
		myNamePanel.setLayout(new GridBagLayout());
		myNamePanel.add(styledPanel);
		
		
		//GridLayout JPanel to hold the 4 panels with gaps between them
		gridContainer = new JPanel(new GridLayout(2, 2, 10, 10));
		
		//Creates a border around each JPanel
		companionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tutorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		assessorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		accountPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//Add the 4 panels to the gridContainer in the desired order
		gridContainer.add(companionPanel);
		gridContainer.add(tutorPanel);
		gridContainer.add(accountPanel);
		gridContainer.add(myNamePanel);
		
		//JSlider initialization and configuration
		JSlider slider = new JSlider(0, 4, 0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		gridContainer.setBackground(Color.cyan);
		//JSlider event listener for when slider changes positions
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event){
				JSlider sourceSlider = (JSlider)event.getSource();
				if(!sourceSlider.getValueIsAdjusting()){
					//The panels are updated according to the value of the slider position
					int sliderValue = slider.getValue();
					companionPanel.changeState(sliderValue);
					tutorPanel.changeState(sliderValue);
					accountPanel.changeState(sliderValue);
					//If the slider is not on the name screen, don't show name on myNamePanel
					if(sliderValue != 0){
						//myName.setText("");
						myNamePanel.remove(styledPanel);
						myNamePanel.setBackground(Color.LIGHT_GRAY);
						myNamePanel.setVisible(true);
					}
					else{
						//myName.setText(NAME);
						myNamePanel.add(styledPanel);
						myNamePanel.setVisible(true);
					}
					//Update the UI
					gridContainer.updateUI();
					gridContainer.repaint();
				}
			}
		});
		
		//Add the gridContainer, and the slider to the Universe JFrame with slider on the bottom
		universeFrame.getContentPane().add(gridContainer, BorderLayout.CENTER);
		universeFrame.getContentPane().add(slider, BorderLayout.SOUTH);
		
		//Sizes window to the preferred size and ensures it is visible
		universeFrame.pack();
		universeFrame.setVisible(true);
	}
	public static void main(String[] args){
		JFrame Universe = new Universe();
	}
}
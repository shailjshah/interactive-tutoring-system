import java.awt.BorderLayout;

/**
 * The Assessor class plays the role of handling user choice and input. It has multiple states depending on the slider
 * position from the Universe.java class. On state 0, it just displays name but on state 1 it shows the options in a dropdown menu
 * before moving on to state 2 which shows them all in a checkbox style. The third state shows them all in a 
 * button format before finally in state 4 allowing the user to input their selection. Once the user hits enter/selects an option
 * in any of the states, a dialog box shows up indicating input * 
 * Assignment number: Recitation 1
 * 
 * Completion Time: 10 hours
 * 
 * @author Shail Shah
 * @version 1.0
 */

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//creating the public class for Assessor and having it implement the ActionListener
public class Assessor extends JPanel implements ActionListener {
	//creating the JPanels that holds each state 
	JPanel menuHolder = new JPanel();
	JPanel menuHolder2 = new JPanel();
	JPanel menuHolder3 = new JPanel();
	JPanel menuHolder4 = new JPanel();
	JPanel stateZero = new JPanel();
	
	JLabel pic = new JLabel(new ImageIcon(getClass().getResource("/resources/shail.jpg")));
	
	public Assessor()
	{
		//creating the label and adding it that shows my name
		//JLabel myname = new JLabel("Shail Shah");
		//myname.setFont(new Font("Serif", Font.PLAIN, 30));
		stateZero.add(pic);
		pic.setVisible(true);
		stateZero.setVisible(true);
		add(stateZero);
		
		//JPanel for state 1
		menuHolder.setLayout(new FlowLayout());
		JLabel lb1 = new JLabel("Select one of the possible choices");
		menuHolder.add(lb1);
		lb1.setVisible(true);
		//Creating choices array that has options 
		String[] choices  = { "Option 1", "Option 2", "Option 3"};
		//choiceCB is a new JComboBox option
		JComboBox<String> choiceCB = new JComboBox<String>(choices);
		choiceCB.addActionListener(new ActionListener() {

            @Override
            //adding the event listener that displays printed items
            public void actionPerformed(ActionEvent e) {
            	 JComboBox choiceCB = (JComboBox) e.getSource();
            	 String field = "";

                Object selected = choiceCB.getSelectedItem();
                if(selected.toString().equals("Option 1"))
                {
                	//if it is option 1
                	JFrame frame = new JFrame("Selection");
    				JOptionPane.showMessageDialog(frame ,
                		    "Option 1 selected."); 
                }
                else if(selected.toString().equals("Option 2"))
                {
                	//if it is option 2
                	JFrame frame = new JFrame("Selection");
    				JOptionPane.showMessageDialog(frame ,
                		    "Option 2 selected.");                 }
                else if(selected.toString().equals("Option 3"))
                {
                	//option 3
                	JFrame frame = new JFrame("Selection");
    				JOptionPane.showMessageDialog(frame ,
                		    "Option 3 selected."); 
                	
                }
			}
        });
		//adding the panel
		
		menuHolder.add(choiceCB);
		choiceCB.setVisible(true);
		menuHolder.setVisible(true);
		
		//changing layout so options go display
		menuHolder2.setLayout(new BoxLayout(menuHolder2, BoxLayout.Y_AXIS));
		JLabel lb2 = new JLabel("Select one of the possible choices");
		menuHolder2.add(lb2);
		lb2.setVisible(true);
		JCheckBox checkbox1 = new JCheckBox("Option 1");
		JCheckBox checkbox2 = new JCheckBox("Option 2");
		JCheckBox checkbox3 = new JCheckBox("Option 3");
		
		menuHolder2.add(checkbox1);
		menuHolder2.add(checkbox2);
		menuHolder2.add(checkbox3);
		
		checkbox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 1 selected.");       
				}
        });
		checkbox2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 2 selected.");       
				}});
		checkbox3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 3 selected.");       
				}});
		menuHolder2.setVisible(true);
		
		//setting the layout and visibility for it
		menuHolder3.setLayout(new BoxLayout(menuHolder3, BoxLayout.Y_AXIS));
		JLabel lb3 = new JLabel("Select one of the possible choices");
		menuHolder3.add(lb3);
		lb3.setVisible(true);
		//button listeners
		JButton button1 = new JButton("Option 1");
		
		button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 1 selected.");       
			}
        });

		//adding the action listeners
		JButton button2 = new JButton("Option 2");
		button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 2 selected.");       
			}
        });
		
		JButton button3 = new JButton("Option 3");
		button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Selection");
				JOptionPane.showMessageDialog(frame ,
            		    "Option 3 selected.");       
				}
        });
		
		//adding the buttons to the jpanel
		menuHolder3.add(button1);
		menuHolder3.add(button2);
		menuHolder3.add(button3);
		menuHolder3.setVisible(true);
		
		menuHolder4.setLayout(new BoxLayout(menuHolder4, BoxLayout.Y_AXIS));
		JLabel lb4 = new JLabel("Enter your choice");
		menuHolder4.add(lb4);
		lb4.setVisible(true);
		JTextField entry = new JTextField(30);
		entry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String inputted = entry.getText();

            	JFrame frame = new JFrame("Entered");
				JOptionPane.showMessageDialog(frame,
            		    inputted);       
			}
        });	
		menuHolder4.add(entry);
	}
	
	//the change state method takes in the state from the universe class	
	public void changeState(int state)
	{
		//add the state 0 panel
		if(state == 0)
		{
			removeAll();
			add(stateZero);
			updateUI();
			
		}
		//add state 1 for the list
		else if(state == 1)
		{
			removeAll();
			add(menuHolder);
			updateUI();
		}
		else if(state == 2)
		{
			removeAll();
			add(menuHolder2);
			updateUI();
		}
		else if(state == 3)
		{
			removeAll();
			add(menuHolder3);
			updateUI();
		}
		else if(state == 4)
		{
			removeAll();
			add(menuHolder4);
			updateUI();
		}
	}
	@Override
	//necessary for the action Performed class
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
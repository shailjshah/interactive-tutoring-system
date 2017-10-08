
/**
 * The Companion class displays 4 different emotions based on the state of
 * the slider. The slider value determines which emotion will be displayed 
 * through the changeState() method. The 4 emotions are thinking, happy
 * worried, and sorry.
 * 
 * Completion Time: 8 hours
 * 
 * @author Igor Ristanovic
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class Companion extends JPanel {

	int status = 0;
	
	public void paintComponent(Graphics g) {
		//Load each image from the resource folder
		ImageIcon image1 = new ImageIcon(getClass().getResource("/resources/steve_think.gif"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("/resources/steve_happy.gif"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("/resources/steve_worried.gif"));
		ImageIcon image4 = new ImageIcon(getClass().getResource("/resources/steve_sorry.gif"));
		ImageIcon image5 = new ImageIcon(getClass().getResource("/resources/Igor.jpg"));
		
		//the status variable determines which image will be showing
		if(status == 0) {
			super.paintComponent(g);
			image5.paintIcon(this, g, 0, 0);
		}
		if(status == 1) {
			super.paintComponent(g);
			image2.paintIcon(this, g, 0, 0);
		}
		if(status == 2) {
			super.paintComponent(g);
			image1.paintIcon(this, g, 0, 0);
		}
		if(status == 3) {
			super.paintComponent(g);
			image3.paintIcon(this, g, 0, 0);
		}
		if(status == 4) {
			super.paintComponent(g);
			image4.paintIcon(this, g, 0, 0);
		}
	}
	
	public void changeState(int state) {
		//The status is determined by the state of the slider
		status = state;
	}
}
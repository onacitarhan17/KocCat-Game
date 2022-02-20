package Edible;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import GUI_related.Drawable;
import GUI_related.Images;

public class Fruit extends JPanel implements Drawable, Edible {

	// Creating variables
	private int xAxis = (int) (450 * Math.random());
	private int yAxis = (int) (450 * Math.random());
	private int age = 1;
	private int littleAge = 0;
	
	// Creating a Images object to recall image paths
	Images images = new Images();

	public Fruit() throws Exception {
		repaint();
	}

	@Override
	public void grow() {
		littleAge++; // Each loop is 10ms so I used a variable to count seconds
		if (age(littleAge)) {
			littleAge = 0;
			age++;
		}
	}

	@Override
	public void consumed() {
		// TODO Auto-generated method stub
		age = 100; // Changing age to dumb integer
	}

	public int getAge() {
		return age;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		if (age < 5) {
			g.drawImage(images.blueFruit.getImage(), xAxis, yAxis, null);
		} else if (age == 5) {
			g.drawImage(images.greenFruit.getImage(), xAxis, yAxis, null);
		} else if (age < 10) {
			g.drawImage(images.greenFruit.getImage(), xAxis, yAxis, null);
		} else {
			// When age is bigger than 10, change the location
			age = 0;
			xAxis = (int) (500 * Math.random());
			yAxis = (int) (450 * Math.random());
		}
	}

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	// A method to count seconds
	public boolean age(int a) {
		if (a == 100) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		grow();
	}

}

package Edible;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import GUI_related.Drawable;
import GUI_related.Images;

public class Poison implements Drawable, Edible{
	
	// Creating variables
	private int age = 1;
	private int littleAge = 0;
	private int xAxis = (int) (450 * Math.random());
	private int yAxis = (int) (450 * Math.random());
	
	// Creating a Images object to recall image paths
	Images images = new Images();

	public Poison() throws Exception {
		super();
	}
	
	@Override
	public void consumed() {
		// TODO Auto-generated method stub
		age = 0;
		xAxis = (int) (450 * Math.random());
		yAxis = (int) (450 * Math.random());
	}

	// Some getters 
	public int getAge() {
		return age;
	}

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	@Override
	public void grow() {
		littleAge++; // Each loop is 10ms so I used a variable to count seconds
		if (age(littleAge)) {
			age++;
			littleAge = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		if (age < 10) {
			g.drawImage(images.yellowPoison.getImage(), xAxis, yAxis, null);
		} else if (age >= 10) {
			g.drawImage(images.redPoison.getImage(), xAxis, yAxis, null);
		}
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

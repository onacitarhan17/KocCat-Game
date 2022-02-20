package Moving;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import GUI_related.Drawable;
import GUI_related.Images;

public class Casper implements Drawable {
	// Creating variables
	private int xAxis = (int) (490 * Math.random());
	private int yAxis = (int) (490 * Math.random());
	private int state = 0;
	private int velocity = 1;
	// Creating a random object
	Random random = new Random();
	private int x = random.nextInt(4);

	// Creating a Images object to recall image paths
	Images images = new Images();

	@Override
	public void draw(Graphics g) {
		g.drawImage(images.ghostCasper.getImage(), xAxis, yAxis, null);
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		state++; // Using a variable to move Casper smoothly
		if (state == 20) {
			x = random.nextInt(4);
			state = 0;
		}
		// Random moves
		if (x == 0 && xAxis < 500) {
			setxAxis(xAxis + velocity);
		} else if (x == 1 && xAxis > 0) {
			setxAxis(xAxis - velocity);
		} else if (x == 2 && yAxis < 470) {
			setyAxis(yAxis + velocity);
		} else if (yAxis > 0) {
			setyAxis(yAxis - velocity);
		}
	}

}

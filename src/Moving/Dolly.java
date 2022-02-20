package Moving;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import GUI_related.Drawable;
import GUI_related.Images;

public class Dolly implements Drawable{
	
	// Creating variables
	private int xAxis = (int) (500 * Math.random());
	private int yAxis = (int) (470 * Math.random());
	private int velocity = 1;
	// Creating a random object
	Random random = new Random();
	private boolean vertical = random.nextBoolean();
	
	// Creating a Images object to recall image paths
	Images images = new Images();

	public Dolly() throws Exception {
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(images.ghostDolly.getImage(), xAxis, yAxis, null);
	}


	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		if (yAxis <= 0) {
			vertical = true;
		} else if (yAxis >= 470) {
			vertical = false;
		}
		if (vertical) {
			setyAxis(yAxis + velocity);
		} else {
			setyAxis(yAxis - velocity);
		}
	}
	

}

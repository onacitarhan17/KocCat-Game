package Moving;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import GUI_related.Drawable;
import GUI_related.Images;

public class Ash implements Drawable{

	// Creating variables
	private int xAxis = (int) (500 * Math.random());
	private int yAxis = (int) (470 * Math.random());
	private int velocity = 1;
	private boolean state;
	
	// Creating a Images object to recall image paths
	Images images = new Images();

	public Ash() throws Exception {
		super();

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
	public void draw(Graphics g) {
		g.drawImage(images.ghostAsh.getImage(), xAxis, yAxis, null);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		// Makes it move all the way to left and right
		if(xAxis<=0) {
			state=true;
		} else if(xAxis>=500) {
			state=false;
		}
		if(state) {
			setxAxis(xAxis+velocity);
		
		} else  {
			setxAxis(xAxis-velocity);
		}
	}

}

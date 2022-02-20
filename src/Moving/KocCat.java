package Moving;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import GUI_related.Drawable;

public class KocCat implements Drawable {
	private int xAxis = 235;
	private int yAxis = 235;
	private String imagePath = "image_right.png";
	private boolean up = false;
	private boolean bottom = false;
	private boolean left = false;
	private boolean right = true;
	private int score;

	public KocCat() {
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(), xAxis, yAxis, null);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}

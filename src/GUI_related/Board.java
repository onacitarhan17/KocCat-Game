package GUI_related;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
import Main.Game;
import Moving.KocCat;

public class Board extends JLabel implements KeyListener {

	private JFrame theGame = new JFrame("PA #1"); // Creating the frame
	Game game = new Game(); // Creating a Game class object which asks inputs
	KocCat koccat = new KocCat(); // Creating the KocCat
	private Edible.Fruit fruit; // Creating a fruit object 
	private Edible.Poison poison; // Creating a poison object
	private boolean gameState = false; // Creating a boolean to determine if the game is over 
	Images images = new Images(); // Creating a image object to recall image paths

	// Creating Array Lists to draw multible
	ArrayList<Edible.Fruit> fruits = new ArrayList<Edible.Fruit>();
	ArrayList<Edible.Poison> poisons = new ArrayList<Edible.Poison>();
	ArrayList<Moving.Dolly> dollys = new ArrayList<Moving.Dolly>();
	ArrayList<Moving.Casper> caspers = new ArrayList<Moving.Casper>();
	ArrayList<Moving.Ash> ashs = new ArrayList<Moving.Ash>();

	// Creating Ghosts to draw later
	Moving.Ash ash = new Moving.Ash();
	Moving.Dolly dolly = new Moving.Dolly();
	Moving.Casper casper = new Moving.Casper();

	public Board() throws Exception {
		
		// Frame adjustments
		this.setFocusable(true);
		this.addKeyListener(this);
		theGame.add(this);
		theGame.setSize(550, 620);
		theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGame.setVisible(true);
		theGame.setResizable(false);
		theGame.setLayout(null);
		
		// Printing score on the Frame
		JLabel b1 = new JLabel("Score: ");
		theGame.add(b1);
		Insets insets = theGame.getInsets();
		Dimension size = b1.getPreferredSize();
		b1.setBounds(15 + insets.left, 500 + insets.top, size.width, size.height);
		JLabel b2 = new JLabel("");
		theGame.add(b2);
		b2.setBounds(55 + insets.left, 500 + insets.top, size.width, size.height);
		
		// Creating multiple fruits
		for (int i = 0; i < game.getNumFruit(); i++) {
			fruit = new Edible.Fruit();
			fruits.add(fruit);
		}
		
		// Creating multiple poisons
		for (int i = 0; i < game.getNumPoison(); i++) {
			poison = new Edible.Poison();
			poisons.add(poison);
		}
		
		// Creating multiple ghosts
		for (int i = 0; i < game.getNumGhost(); i++) {
			if (i % 3 == 0) {
				casper = new Moving.Casper();
				caspers.add(casper);
			} else if (i % 3 == 1) {
				dolly = new Moving.Dolly();
				dollys.add(dolly);
			} else {
				ash = new Moving.Ash();
				ashs.add(ash);
			}

		}

		// Creating a Timer object to perform loops
		Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Checking bottons and moving Koccat according to it
				if (koccat.isUp() && koccat.getyAxis() > 0 && !gameState) {
					koccat.setyAxis(koccat.getyAxis() - 1);
				} else if (koccat.isBottom() && koccat.getyAxis() < 470 && !gameState) {
					koccat.setyAxis(koccat.getyAxis() + 1);
				} else if (koccat.isLeft() && koccat.getxAxis() > 0 && !gameState) {
					koccat.setxAxis(koccat.getxAxis() - 1);
				} else if (koccat.isRight() && koccat.getxAxis() < 500 && !gameState) {
					koccat.setxAxis(koccat.getxAxis() + 1);
				}
				
				// Updating score and changing title when game is over
				if (gameState) {
					theGame.setTitle("Game Over!");
				} else {
					b2.setText(String.valueOf(koccat.getScore()));
					repaint();
				}
				if (koccat.getScore() < 0) {
					gameState = true;
				}
			}
		});
		timer.start();

	}
	
	// The paing method to paint objects
	public void paint(Graphics g) {
		g.drawImage(images.background.getImage(), 0, 0, null);
		g.drawImage(images.lejant.getImage(), 0, 498, null);
		Poison(g);
		Ghosts(g);
		koccat.draw(g);
		Fruit(g);
	}

	// A method to create fruits and check interasecitons
	public void Fruit(Graphics g) {
		for (Edible.Fruit fruit : fruits) {
			int touchCheckX = koccat.getxAxis() - fruit.getxAxis();
			int touchCheckY = koccat.getyAxis() - fruit.getyAxis();
			fruit.doAction();
			fruit.draw(g);
			if (touchCheckX < 25 && touchCheckX >= -25 && touchCheckY < 25 && touchCheckY >= -25) {
				koccat.setScore(koccat.getScore() + fruit.getAge() * 5);
				fruit.consumed();
			}
		}
	}

	// A method to create poisons and check interasecitons
	public void Poison(Graphics g) {
		for (Edible.Poison poison : poisons) {
			int touchCheckX = koccat.getxAxis() - poison.getxAxis();
			int touchCheckY = koccat.getyAxis() - poison.getyAxis();
			poison.doAction();
			poison.draw(g);
			if (touchCheckX < 25 && touchCheckX >= -25 && touchCheckY < 25 && touchCheckY >= -25) {
				if (koccat.getScore() >= 0) {
					koccat.setScore(koccat.getScore() - poison.getAge() * 10);
				}

				if (koccat.getScore() >= 0) {
					poison.consumed();
				}

			}
		}
	}

	// A method to create ghosts one by one and check interasecitons
	public void Ghosts(Graphics g) {
		for (Moving.Dolly dolly : dollys) {
			int touchCheckX = koccat.getxAxis() - dolly.getxAxis();
			int touchCheckY = koccat.getyAxis() - dolly.getyAxis();
			dolly.doAction();
			dolly.draw(g);
			if (touchCheckX < 25 && touchCheckX >= -25 && touchCheckY < 25 && touchCheckY >= -25) {
				gameState = true;
			}
		}
		for (Moving.Casper casper : caspers) {
			int touchCheckX = koccat.getxAxis() - casper.getxAxis();
			int touchCheckY = koccat.getyAxis() - casper.getyAxis();
			casper.doAction();
			casper.draw(g);
			if (touchCheckX < 25 && touchCheckX >= -25 && touchCheckY < 25 && touchCheckY >= -25) {
				gameState = true;
			}
		}
		for (Moving.Ash ash : ashs) {
			int touchCheckX = koccat.getxAxis() - ash.getxAxis();
			int touchCheckY = koccat.getyAxis() - ash.getyAxis();
			ash.doAction();
			ash.draw(g);
			if (touchCheckX < 25 && touchCheckX >= -25 && touchCheckY < 25 && touchCheckY >= -25) {
				gameState = true;
			}
		}
	}

	// Changing button states and koccat images when a key is pressed
	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_UP && !gameState) {
			koccat.setImagePath("image_up.png");
			this.repaint();
			koccat.setUp(true);
			koccat.setBottom(false);
			koccat.setLeft(false);
			koccat.setRight(false);
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN && !gameState) {
			koccat.setImagePath("image_down.png");
			this.repaint();
			koccat.setUp(false);
			koccat.setBottom(true);
			koccat.setLeft(false);
			koccat.setRight(false);
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT && !gameState) {
			koccat.setImagePath("image_right.png");
			this.repaint();
			koccat.setUp(false);
			koccat.setBottom(false);
			koccat.setLeft(false);
			koccat.setRight(true);
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT && !gameState) {
			koccat.setImagePath("image_left.png");
			this.repaint();
			koccat.setUp(false);
			koccat.setBottom(false);
			koccat.setLeft(true);
			koccat.setRight(false);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

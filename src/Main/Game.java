package Main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame {

	private int numFruit;
	private int numPoison;
	private int numGhost;

	public Game() throws Exception {

		// Getting inputs for fruits, poisons and ghosts
		String numOfFruit = JOptionPane.showInputDialog("Please enter a number of fruit type : ");
		String numOfPoison = JOptionPane.showInputDialog("Please enter a number of poison : ");
		String numOfGhost = JOptionPane.showInputDialog("Please enter a number of ghosts : ");
		
		// Changing them to integer
		numFruit = Integer.parseInt(numOfFruit);
		numGhost = Integer.parseInt(numOfGhost);
		numPoison = Integer.parseInt(numOfPoison);
		
		// Checking if the values are val,d
		if (numPoison <= 0 || numFruit <= 0 || numGhost <= 0) {
			JOptionPane.showMessageDialog(null, "Wrong input(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new Exception("Invalid values");
		}
	}

	
	// Getter methods
	public int getNumFruit() {
		return numFruit;
	}

	public int getNumPoison() {
		return numPoison;
	}

	public int getNumGhost() {
		return numGhost;
	}
}

import java.awt.Color;

import javax.swing.*;

// this class 
@SuppressWarnings("serial")
public class PacManGUI extends JFrame {
	
	// sets up the game board, a panel
	private Board board = new Board(); //CHANGE EACH DAY
	
	//private ScorePanel scorePanel = new ScorePanel(); 
		
	// constructor method to set up frame
	public PacManGUI() {
		
		// construct frame
		setSize(600,625);
		setTitle("Vrinda Joshi's PacMan Game");
		
		// used to save memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add to frame (gameboard)
		
		board.setBounds(0, 0, 600, 600);
		add(board);
		
		//
		addKeyListener(board);
		
		setVisible(true);
		
	} // main method end
	
} // class end
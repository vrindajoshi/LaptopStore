// BOARD DAY 

// imports
import java.util.Scanner;
import javax.swing.*;
import java.io.*; // io : input-output
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.*;

// class
@SuppressWarnings("serial")
public class Board extends JPanel implements KeyListener, ActionListener{
	
	// game timer - timer belongs to swing package
	private Timer gameTimer = new Timer(250, this); // 250ms
	
	// panel for board
	private JPanel mazePanel = new JPanel();
	
	// creates the maze array (25 rows, 27 columns)
	private Cell[][] mazeArray = new Cell[25][27];
	
	private ScorePanel sPanel = new ScorePanel();
	
	// creates the pacman mover
	static Mover pacMan;
	
	// array of ghosts
	private Mover[] ghostArray = new Mover[3];
	
	//array of ghosts out of the box
	private boolean[] ghostsOut = new boolean[3];
	
	// pellets (why does it equal 0??)
	private int pellets = 0;
	
	// score at start equals 0
	static int score;
	
	// score at start equals 0
	static int highscore;
	
	static int gameRunning = 0;
	
	// lives
	static int lives;
	
	// level
	private int level = 0;
	
	
	
	// constructor method
	public Board() {
		
		// `set user high score
		for (int index = 0; index < PacManGame.userScoreArray.length; index++) {
			if (PacManIntro.nameEntry.getText().toUpperCase().equals(PacManGame.userScoreArray[index].getName())){
				highscore = PacManGame.userScoreArray[index].getHighScore();
				ScorePanel.highScoreLabel.setText(""+highscore);
				break;
			} else if (PacManGame.userScoreArray[index].getName() == null) {
				// initialize object
				PacManGame.userScoreArray[index].setName(PacManIntro.nameEntry.getText().toUpperCase());
				PacManGame.userScoreArray[index].setHighScore(highscore);
				// scan in object
				//new ScanInCSV();
				break;
			}
		}
				
		Color bkgdColour = (Color.WHITE);
		
		if (PacManIntro.selectedTheme == 0) {
			bkgdColour =  (Color.BLACK);
		} else if (PacManIntro.selectedTheme == 1) {
			bkgdColour =  (Color.PINK);
		}
		
		setBackground(bkgdColour);

		// set all the ghosts to inside the box
		for (boolean index: ghostsOut)
			index = false;
		
		// set lives to 3
		lives = 3;
		
		sPanel.setBounds(0, 0, 600, 35);
		sPanel.setBackground(bkgdColour);
		
		// set up panel
		mazePanel.setLayout(new GridLayout(25, 27));
		mazePanel.setBackground(bkgdColour);
		mazePanel.setBounds(0, 100, 600, 600);
		
		add(sPanel);
		add(mazePanel);
		
		// load board, contents
		loadBoard();
	
	} //end of constructor

	// load board method
	private void loadBoard() {
		
		// set row to 0
		int row = 0;
		
		// initialize new file
		Scanner inputFile;
		
		// try the file, or catch the errors
		try {
			
			// set file to import
			inputFile = new Scanner(new File(PacManGame.mazeFileArray[level]));
			
			// reads every row
			while (inputFile.hasNext()) {
				
				// reads in ONE line, switched to a char array
				char[] lineArray = inputFile.nextLine().toCharArray();
				
				// reads every column on the line array
				for (int column = 0; column < lineArray.length; column++) {
					
					//set the contents of the maze array to be the cell at the column index of the line array
					mazeArray[row][column] = new Cell(lineArray[column]);
					
					
					// if the column is food (f) add more pellets
					if (lineArray[column] == 'F')
						pellets++;
					
					// if the column is pacman, put pac man there
					else if (lineArray[column] == 'P') {
						pacMan = new Mover(row, column);
						pacMan.setIcon(Icons.PACMAN[0]);
						pacMan.setDirection(0);
					}	
					
					// if the columns designates a ghost, put a ghost there
					else if (lineArray[column] == '0' || lineArray[column] == '1' || lineArray[column] == '2') {
						
						// get the ghost number
						int gNum = Character.getNumericValue(mazeArray[row][column].getItem());
						
						//set up that ghost number
						ghostArray[gNum] = new Mover(row,column);
						ghostArray[gNum].setIcon(Icons.GHOST[gNum]);
					}
					
					// add the block to the board
					mazePanel.add(mazeArray[row][column]);
					
					
				} // end of for loop
				
				// go to next row
				row++;
				
			} // end of while loop
		
			// close the file
			inputFile.close();
			
		// catch any errors
		} catch (FileNotFoundException error) {
			
			System.out.println("File Not Found");
		}
		
	} // end of loadBoard method

// ______________________________________________________________________________________________
	
	
	@Override
	public void keyTyped(KeyEvent key) {
		// not used	
	}
	
	@Override
	public void keyReleased(KeyEvent key) {
		// not used
	}

// ______________________________________________________________________________________________
	
	
	@Override
	public void keyPressed(KeyEvent key) {
		
		// starts game when key gets pressed
		if (gameTimer.isRunning() == false && pacMan.isDead() == false) {
			gameTimer.start();
			gameRunning = 1;
			
			// plays music
			playMusic("sounds/sounds/GAMEBEGINNING.wav");
		}
			
		// if pacman is not dead and user has not won
		else if (pacMan.isDead() == false && score != pellets) {
			
			// change diresction based on key
			int direction = key.getKeyCode() - 37;
			
			// delta row/column
			int dRow = 0;
			int dCol = 0;
			
			// based on key set direction
			if (direction == 0)
				dCol  = -1;
			else if (direction == 1)
				dRow  = -1;
			else if (direction == 2)
				dCol  = 1;
			else if (direction == 3)
				dRow  = 1;
			
			// if the next row/column is not equal to a wall or a gate
			if (mazeArray[pacMan.getRow() + dRow]
					[pacMan.getColumn() + dCol].getIcon() != Icons.WALL[PacManIntro.selectedTheme] && mazeArray[pacMan.getRow() + dRow]
							[pacMan.getColumn() + dCol].getIcon() != Icons.GATE) {
				//set icon to that direction
				pacMan.setIcon(Icons.PACMAN[direction]);
				pacMan.setDirection(direction);
			}

		}
		
	}
	
	// perform move
	private void performMove(Mover mover) {
		
		 if (mover.getNextRow() >= 0 && mover.getNextRow() < 25
		            && mover.getNextColumn() >= 0 && mover.getNextColumn() < 27) {

			// set current cell and next cell
				Cell currentCell = mazeArray[mover.getRow()][mover.getColumn()];
				Cell nextCell = mazeArray[mover.getNextRow()][mover.getNextColumn()];
					
				// passage ways
				if (mover.getColumn() == 1) {
					mover.setColumn(25);
					mazeArray[12][1].setIcon(Icons.DOOR);
				} else if (mover.getColumn() == 25) {
					mover.setColumn(2);
					mazeArray[12][25].setIcon(Icons.DOOR);
				}
				
				// if next cell is not a wall
				if (nextCell.getIcon() != Icons.WALL[PacManIntro.selectedTheme]) {
					
					// sets the icon to food
					if(mover != pacMan && currentCell.getItem() == 'F')
						currentCell.setIcon(Icons.FOOD);
					
					else if(mover != pacMan && currentCell.getItem() == 'C')
						currentCell.setIcon(Icons.CHERRY);
					
					else if(mover != pacMan && currentCell.getItem() == 'G')
						currentCell.setIcon(Icons.GATE);
					
					// sets the icon to blank
					else
						currentCell.setIcon(Icons.BLANK);
					
					// move the mover
					mover.move();
					
					// set currrent cell
					currentCell = mazeArray[mover.getRow()][mover.getColumn()];

					// ghost and pac man collide
					if (collided()) {
						if (score > highscore)
							highscore = score;
						score=0;
						ScorePanel.highScoreLabel.setText(""+highscore);
						playMusic("sounds/sounds/killed.wav");
						lives--;
						ScorePanel.livesLabel.setText(""+lives);
						
						// checks if there are more lives
						if (lives != 0) {
							mazePanel.removeAll();
							loadBoard();
							gameTimer.stop();
							JOptionPane.showMessageDialog(this, "You lost a life! Lives left: "+lives);
						}
						// if there are none, game over
						else
							death();
					}
					
					//
					else
						currentCell.setIcon(mover.getIcon());
					
					
					if (mover == pacMan && currentCell.getItem() == 'F' ) {
						
						//
						score++;
						ScorePanel.scoreLabel.setText(""+score);
						currentCell.setItem('E');
						//
						if (score == pellets) {
							gameTimer.stop();
							gameRunning = 0;
							JOptionPane.showMessageDialog(this, "You cleared the board!");
							if (level == 2) {
								JOptionPane.showMessageDialog(this, "You won!");
							}
							else {
								level++;
								score = 0;
								pellets = 0;
								removeAll();
								loadBoard();
							}
							gameTimer.stop();
						}
					}
					else if (mover == pacMan && currentCell.getItem() == 'C' ) {
							
						//
						System.out.println(3);
						score+=5;
						ScorePanel.scoreLabel.setText(""+score);
		
						
						currentCell.setItem('E');
							
								
						}
					}
						
					
				}

		 }// end of priv method
	private void death() {
		
		pacMan.setDead(true);
		
		mazeArray[pacMan.getRow()][pacMan.getColumn()].setIcon(Icons.SKULL);
		
		gameTimer.stop();
		JOptionPane.showMessageDialog(this, "GAME OVER!");
		
	}

	// if ghost and pac man collide
	private boolean collided() {
		
		for(Mover ghost: ghostArray) {
			
			if(ghost.getRow() == pacMan.getRow() && ghost.getColumn() == pacMan.getColumn())
				return true;
		}
		
		return false;
		
	}
	
	// this method moves the ghosts
	private void moveGhosts() {
		
		// code to get the ghosts out
		
		// for all the ghosts
		for(Mover ghost:ghostArray) {
			
			// set current cell and next cell
			Cell currentCell = mazeArray[ghost.getRow()][ghost.getColumn()];
			Cell nextCell = mazeArray[ghost.getNextRow()][ghost.getNextColumn()];
			
			int dir = 0;
			
			
			// random movement of the ghost
			do {
				dir = (int)(Math.random()*4);
			} while(Math.abs(ghost.getDirection() - dir) == 2); // stops the ghost from going back and forth
			
			// ghost ai: creds aishu tandon
			if (pacMan.getRow() == ghost.getRow()) {
				if (pacMan.getColumn() < ghost.getColumn()) {
					dir = 0;
				} else if (pacMan.getColumn() > ghost.getColumn()) {
					dir = 2;
				}
			}
			else if (pacMan.getColumn() == ghost.getColumn()) {
				if (pacMan.getRow() < ghost.getRow()) {
					dir = 1;
				} else if (pacMan.getRow() > ghost.getRow()) {
					dir = 3;
				}
			}
			
			
			// path to get ghosts out
			if (currentCell.getItem() == 'U') {
				dir = 1;
			}
			
			// stops ghosts from going back into box
			if (nextCell.getItem() == 'G' && dir == 3) {
				dir = 0;
			}
			// ghost path to get out of bo
				
			// set the ghosts' direction
			ghost.setDirection(dir);
			
			// whil pacman is not dead, keep moving the ghosts
			if(!pacMan.isDead())
				performMove(ghost);
			
		}
	
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == gameTimer) {	
			performMove(pacMan);
			moveGhosts();
		}	
		
	}
	
	// method that plays sounds 
	// https://www.youtube.com/watch?v=wJO_cq5XeSA
	private void playMusic(String filepath) {
			
		try {
			File musicPath = new File(filepath);
			
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {
				System.out.println("dne");
			}
			
		}
		catch (Exception e){
			System.out.println(e);
		}
		
	}

} // end of class
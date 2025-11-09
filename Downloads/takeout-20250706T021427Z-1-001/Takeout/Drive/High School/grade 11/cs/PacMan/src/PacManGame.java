// Project Header

// this class is the application that runs the game
public class PacManGame {
	
	static String[] mazeFileArray = new String[3];
	static UserScore[] userScoreArray = new UserScore[2]; //up to ten user's can be stored
	
	// this method allows for code to be processed
	public static void main(String[] args) {
		
		mazeFileArray[0] = "mazes/maze.txt";
		mazeFileArray[1] = "mazes/maze2.txt";
		mazeFileArray[2] = "mazes/maze3.txt";

		new UserFileInput();

		// this calls the frame of the game
		new PacManIntro();
		//new PacManGUI();

	}

}
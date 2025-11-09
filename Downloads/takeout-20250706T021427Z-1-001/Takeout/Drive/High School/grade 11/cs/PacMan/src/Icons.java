// ICONS
// creates the imageicon constants for the elements on out screen

// import statements
import javax.swing.Icon;
import javax.swing.ImageIcon;

// class
public class Icons {
	
	// icons that do not change
	public static final ImageIcon FOOD = new ImageIcon("images/Food.bmp");
	public static final ImageIcon BLANK = new ImageIcon("images/Black.bmp");
	public static final ImageIcon DOOR = new ImageIcon("images/Black.bmp");
	public static final ImageIcon SKULL = new ImageIcon("images/Skull.bmp");
	public static final ImageIcon CHERRY = new ImageIcon("images/Cherry.bmp");
	public static final ImageIcon BLUE = new ImageIcon("images/BlueGhost.bmp");
	public static final ImageIcon GATE = new ImageIcon("images/Black.bmp");
	
	
	public static final ImageIcon[] WALL = {
			new ImageIcon("images/Wall.bmp"),
			new ImageIcon("images/PinkWall.png"),
	};
	
	// pac man array for the different directions
	public static final ImageIcon[] PACMAN = {
			new ImageIcon("images/PacMan0.gif"),
			new ImageIcon("images/PacMan1.gif"),
			new ImageIcon("images/PacMan2.gif"),
			new ImageIcon("images/PacMan3.gif"),
	};
	
	// ghost array for the 3 ghosts
	public static final ImageIcon[] GHOST = {
			new ImageIcon("images/Ghost0.bmp"),
			new ImageIcon("images/Ghost1.bmp"),
			new ImageIcon("images/Ghost2.bmp"),
	};


} // end of class
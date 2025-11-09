// CELL
// template class for the cell object

// import classes
import javax.swing.*;

// class
public class Cell extends JLabel{
	
	// field
	private char item;

	// constructor
	public Cell(char item) {
		super();
		this.item = item;
		
		setCodeIcon();
	}

	// getters and setters
	public char getItem() {
		return item;
	}
	public void setItem(char item) {
		this.item = item;
	}
	
	// to string
	@Override
	public String toString() {
		return "Cell [item=" + item + "]";
	}
	
	// code icon method
	private void setCodeIcon() {
		
		// CODE DOES NOT CAHNGE BASED ON THEME
		
		if (PacManIntro.selectedTheme == 0) {
		
			if (item == 'P')
	            setIcon(Icons.PACMAN[0]);
	        else if (item == '0')
	            setIcon(Icons.GHOST[0]);
	        else if (item == '1')
	            setIcon(Icons.GHOST[1]);
	        else if (item == '2')
	            setIcon(Icons.GHOST[2]);
	        else if (item == 'W') 
	            setIcon(Icons.WALL[PacManIntro.selectedTheme]);
	        else if (item == 'F')
	            setIcon(Icons.FOOD);
	        else if (item == 'C')
	            setIcon(Icons.CHERRY);
	        else if (item == 'D')
	            setIcon(Icons.DOOR);
	        else if (item == 'G')
	            setIcon(Icons.GATE);
		}
		
		else if (PacManIntro.selectedTheme == 1) {
		
			if (item == 'P')
	            setIcon(Icons.PACMAN[0]);
	        else if (item == '0')
	            setIcon(Icons.GHOST[0]);
	        else if (item == '1')
	            setIcon(Icons.GHOST[1]);
	        else if (item == '2')
	            setIcon(Icons.GHOST[2]);
	        else if (item == 'W') 
	        	setIcon(Icons.WALL[PacManIntro.selectedTheme]);
	        else if (item == 'F')
	            setIcon(Icons.FOOD);
	        else if (item == 'C')
	        	setIcon(Icons.CHERRY);
	        else if (item == 'D')
	            setIcon(Icons.DOOR);
	        else if (item == 'G')
	            setIcon(Icons.GATE);
		}
		
	}

}
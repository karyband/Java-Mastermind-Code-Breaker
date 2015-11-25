//Karina Banda
//kbanda2@u.rochester.edu
//172 Project 1

import java.util.ArrayList;


public interface game {
	
	public ArrayList<String> allcombos(String[] colors, int positions);
	public String nextMove();
	public void response(int colorsRightPositionWrong,int positionsAndColorRight);
	public void newGame(); // Reset the game

	
	
}

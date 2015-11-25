//Karina Banda
//kbanda2@u.rochester.edu
//172 Project 1
import java.util.ArrayList;


public class codebreaker implements game{


ArrayList<String> combinations=new ArrayList<String>(); //all combinations will be stored here
String tempguess; //the guess from the 'latest round' will temporarily be stored here in order to be able to compare

	public codebreaker(String[] colors, int positions){ //initializing the combinations and tempguess
		tempguess=null;
		combinations.addAll(allcombos(colors, positions));
		
	}


	public ArrayList<String> allcombos(String[] colors, int positions){ //Method to make all of the possible combinations and store them in an arraylist
		ArrayList<String> combos=new ArrayList<String>(); //this arraylist will be added to the the arraylist from the constructor
		if(positions==1){  //base case
			for(int i=0;i<colors.length;i++){
				combos.add(colors[i]); //will add one color to a new position in the combos array
				
			}
			return combos; 
		}
		
		else{
			for(int i=0; i<colors.length;i++){
				ArrayList<String> looping=allcombos(colors, positions-1); //this will provide the recursion for the other levels
				for(int j=0; j<looping.size();j++){
					combos.add(colors[i]+looping.get(j));
				}
			}
			
		}
		
		
		return combos;
		
	}
	

	public static int[] compare(String guessed, String newguess){ //method to compare the current computer's guess with all the remaining possible combos 
		int blacks=0; //will stand for the number of characters that are the same and same position
		int whites=0; //will stand for the number of char that are the same but not same position between the two strings
		
		char[] guessedchar=guessed.toCharArray(); //need to convert the strings into a character array to iterate 
		char[] guessednew=newguess.toCharArray();
		
		//comparison for blacks
		for(int i=0;i<guessedchar.length;i++){
			if(guessedchar[i]==guessednew[i]){ //checking if the characters are the same
				blacks++;
				
				guessedchar[i]='\0'; //need to set it to null now because we don't want the it to still show for the white check
				guessednew[i]='\0';
			}
		}
			
		//comparison for whites
		for(int j=0;j<guessedchar.length;j++){ //nested for loops because we don't care about position
			for(int k=0;k<guessednew.length;k++){
				if(guessedchar[j]==guessednew[k] && guessedchar[k]!='\0' && guessedchar[j]!='\0'){ //make sure we are not counting the null
					guessednew[k]='\0'; //matched already, so now turn it into null so it doesnt get counted again
					whites++;
				}
			}
		}
		

		
		
		int[] comparison={blacks,whites};
				
		return comparison;
				
	}
	
	
	
	
	
	



	@Override
	public void response(int colorsRightPositionWrong, int positionsAndColorRight) { //will analyze what to do with the given response from the user
		for(int i=0;i<combinations.size();i++){  //go through all the remaining combinations
			int[] responses=compare(tempguess, combinations.get(i)); //will get back the amount of same positions
			if(responses[0]!=positionsAndColorRight || responses[1]!=colorsRightPositionWrong){
				combinations.remove(i);  //will remove it
				i--; //but since it is removed, the count has decreased so we need to go back an i
			}
			
			
		}
		
	}


	@Override
	public void newGame() {
		
		combinations.clear(); //clearing all the left over combos in the combo array
		
		
	}
	
	
	@Override
	public String nextMove() { //returns the top combo of the possible combinations
		tempguess=combinations.get(0);
		
		return combinations.remove(0);
	}
	
	
	
}

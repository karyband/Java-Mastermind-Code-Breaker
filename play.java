//Karina Banda
//kbanda2@u.rochester.edu
//172 Project 1

import java.util.Scanner;

public class play { //main class, runs the game
static codebreaker breaker;

	public static void main(String[] args) {
		ask();
	}
	
	public static void ask(){
		Scanner input= new Scanner(System.in);
		
		System.out.println("Enter the number of positions we will be playing with\n");
		int number= Integer.parseInt(input.next()); //receiving user input


		input.nextLine();
		System.out.println("Enter colors separated by spaces: \n");
		String colors=input.nextLine();
		String[] splited=colors.split("\\s+"); //parsing the colors into an array of strings

		
		breaker=new codebreaker(splited, number); //initializing a new game
		
		
		int black=0; //the starting rights are obviously 0
		
		while(black!=number){ //while all positions are not correct
		String computersguess=breaker.nextMove(); //get next move from the computer
		
		System.out.println("Guess: "+computersguess);
		
		
		System.out.println("Enter the amount of colors that are right and in the right positions");
		black=input.nextInt();
		
		System.out.println("Enter the amount of colors that are right but not in the right position");
		int white=input.nextInt();
		
		
		breaker.response(white, black); //analyze what to do with the response
		
		}
		
		System.out.println("Computer has won!");
		System.out.println("If you would like to start a new game with a different combination, type in 1. If you do not type in 0");
		int answer=input.nextInt(); 
		
		if(answer==1){
		breaker.newGame(); //erases the combos for the last game, then starts over
		ask();
		}
		if(answer==0){
			System.out.println("DONE");
		}
		else
			System.out.println("You didn't follow the orders -.-");
		
	}

}

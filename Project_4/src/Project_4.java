import java.util.*;
import java.io.*;

public class Project_4 {

	public static void main(String[] args) throws FileNotFoundException {

		//final String FILENAME = "dictionary.txt";
		final String FILENAME = "C:\\Users\\iampo\\eclipse-workspace\\Project_4\\src\\dictionary.txt";
		String[] words = readFile(FILENAME);

		// Delete this line, after you are able to import dictionary into the project
		//System.out.println("Number of words in the file " + words.length);
		
		Scanner input = new Scanner(System.in);
		Scanner cont = new Scanner(System.in);
		boolean gameContinue = true;
		while (gameContinue) {
			//set up for game, will loop the game until gameEnded == true
			int wrongCount = 0;
			char guess;
			String wordToGuess = chooseRandomWord(words);
			String wordInPound = createPound(wordToGuess);
			String currentState = wordInPound;
			
			//looping while inside current game
			while (wrongCount < 7) {
				System.out.println("Guess any letter in the word");
				//print the current solved state of the word
				System.out.println(currentState);
				guess = input.next().charAt(0);
				input.nextLine();
				currentState = guessWord(guess,wordToGuess,currentState);
				if (!wordToGuess.contains(Character.toString(guess))){
					wrongCount ++;
					hangmanImage(wrongCount, wordToGuess);
				}
				
				System.out.println(wordToGuess);
				
				//System.out.println(wrongCount);
				
				//when word is solved
				if (currentState.equals(wordToGuess)) {
					System.out.println("Correct! you have won this game. The word is: " + wordToGuess);
					System.out.println("Do you still want to play?");
					
					//2nd instance of scanner required else if using input, line 29 takes precedence
					if (cont.nextLine().contains("yes")) {
						wrongCount = 10;
						//gameContinue = true;
					}
					else if (cont.nextLine().contains("no")) {
						gameContinue = false;
					}
				}
			}
			//when man already hung, ask player if they want to play again
			if (wrongCount == 7) {
				System.out.println("Do you still want to play?");
				//reloop into game
				if (cont.nextLine().contains("yes")) {
					gameContinue = true;
					//broken
					//wrongCount = 10;
				}
				//remains outside game loop
				else if (cont.nextLine().contains("no")) {
					gameContinue = false;
				}
			}
		}
	}
	
	public static String guessWord(char guess, String word, String pound) {
		//for loop to iterate through word
		//casting current state of pound to stringbuilder
		StringBuilder pound1 = new StringBuilder(pound);
		for(int i = 0; i < word.length();i++) {
			if(word.charAt(i) == guess) {
				//replace # with guess letter if correct
				pound1.setCharAt(i, word.charAt(i)); 
				//casting Stringbuilder back to string
				pound = pound1.toString();
			}
			
		}
		return pound;
		//if guess in word, replace pound with word.charAt(i)
		//return updated pound
	}

	public static String[] readFile(String filename) throws FileNotFoundException {
		/**
		Explanation to read the file.
		 * Since the number of lines in the file is not mentioned, 
		 * You should first read the input count the number of lines in the file.
		 * Each line consitutes to one word.
		 * Then, do another run to read the file into the array of String.
		 * To read the file twice, you have to use same scanner as follows
		 * Scanner readFile = new Scanner ( ... )
		 * Read the file to count the number of lines
		 * close the readFile this is important
		 * Then use readFile = new Scanner ( ... ), to read the file again
		*/

		Scanner file = new Scanner(new File(filename)); // create a file reading scanner
		int numLines = 0;

		while(file.hasNextLine()) {
			file.nextLine();
			numLines++;
		}
		file.close(); // close once you are done reading
		// now you have read the number of lines in the file

		file = new Scanner(new File(filename));
		// read the file again, and add it to the words array.
		String[] words = new String[numLines];
		for(int i = 0; i < numLines; i ++){
			words[i] = file.nextLine();
		}

		file.close();
		return words;
	}

	public static String createPound(String word) {
		//replace word with pound, return pound
		String pound = "#".repeat(word.length());
		return pound;
	}

	public static String chooseRandomWord(String[] words) {
		//select random word from dictionary
		int min = 0;
		int max = words.length;
		int randInt = (int)(Math.random() * (max - min) + min);
		String randomWord = words[randInt];
		return randomWord;
	}

	public static void hangmanImage(int count, String word) {
		//
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}

}

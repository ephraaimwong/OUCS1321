import java.util.*;
import java.io.*;

public class HangmanGame {
	
	public static String[] readFile(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new File(filename));
		//read file to count lines to determine parameters for forloop & words array capacity
		int numLines = 0;
		while(file.hasNextLine()) {
			file.nextLine();
			numLines++;
		}
		file.close();
			
		//read file 2nd time with for loop to store text as string array
		file = new Scanner(new File(filename));
		String[] words = new String[numLines];
		for(int i = 0; i < numLines; i++) {
			words[i] = file.nextLine();
		}
		file.close();
		//return array
		return words;
	}
	//grabs word from array by random index
	public static String chooseRandomWord(String[] words, Random rand) {
		int randomInt = rand.nextInt(words.length);
		return words[randomInt];
	}
	
	//splits a string into String[] with its letters
	public static String[] wordToArray(String word) {
		String[] wordInArray = word.split("");
		return wordInArray;
	}
	
	//changes word to a string[] replacing all letters to #
	public static String[] createPound(String word) {
		//separate word into letters, put to array, change to pound
		String[] wordInPound = new String[word.length()];
		for(int i = 0; i < word.length(); i++) {
			wordInPound[i] = "#";
		}
		return wordInPound;
	}
	
	public static void printWordState(String[] wordInPound, String wordToGuess) {
		//prints updated solved word
		System.out.println(String.join("", wordInPound));
		//remove later, hacks
		//System.out.println(wordToGuess);
		
	}
	
	public static void hangmanImage(int currentCount, int previousCount, String word) {
		//only print wrong message && print hangman when currentCount increments
		if (currentCount > previousCount) {
			System.out.println("Wrong guess, try again");
			if (currentCount > previousCount && currentCount == 1) {
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("___|___");
				System.out.println();
			}
			if (currentCount > previousCount && currentCount == 2) {
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("___|___");
			}
			if (currentCount > previousCount && currentCount == 3) {
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
			if (currentCount > previousCount && currentCount == 4) {
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
			if (currentCount > previousCount && currentCount == 5) {
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
			if (currentCount > previousCount && currentCount == 6) {
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
			if (currentCount > previousCount && currentCount == 7) {
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
	
	
	public static int guessWord(String userGuess, String[] wordToGuess, String[] wordInPound,int wrongCount) {
		if (!String.join("",wordToGuess).contains(userGuess)) {
			wrongCount++;
		}
		else {
			for(int i = 0; i < wordToGuess.length; i++) {
				if (userGuess.equals(wordToGuess[i])) {
					wordInPound[i] = userGuess;
				}
			}
		}
		return wrongCount;
	}
	
	public static String validateUserGuess(String userGuess, boolean validInput, Scanner input) {
		String temp = "";
		while (!validInput) {
			System.out.println("Guess any letter in the word:");
			//grabs first char of input, ignores the rest
			temp = input.nextLine();
			//if input is char, valid and break loop, return char
			//regex validation of input, a-z or A-Z only
			if (temp.matches("^[a-zA-Z]*$") && temp.length() == 1) {	
				//cast char input to lower in case user uses uppercase. dictionary is all lowercase.
				//working
				userGuess = temp.toLowerCase();
				//broken??maybe not
				validInput = true;
			}
			//if input not char, reject and reloop
			else {
				System.out.println("Only single letter input allowed.");
			}
		}
		//working
		return userGuess;
		
	}
	
	public static boolean continueGame(Scanner input) {
		boolean cont = false;
		if(input.nextLine().toLowerCase().contains("yes")) {
			cont = true;
		}
		else if(input.nextLine().toLowerCase().contains("no")) {
			cont = false;
		}
		return cont;
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		//commented out local copy
		final String FILENAME = "C:\\Users\\iampo\\eclipse-workspace\\HangmanGame\\src\\dictionary.txt";
		//final String FILENAME = "dictionary.txt";
		Scanner input = new Scanner(System.in);
		String[] words = readFile(FILENAME);
		
		//delete after importing dictionary
		System.out.println("Number of words in the file " + words.length);
		
		//declaration of rand for randomWord method, reduce repeated declaration
		Random rand = new Random();
		boolean gameContinue = true;
		boolean validInput = false;
		while (gameContinue) {
			int wrongCount = 0;
			int previousCount = 0;
			String userGuess = "";
			String wordToGuess = chooseRandomWord(words, rand);
			String[] wordInPound = new String [wordToGuess.length()];
			String[] wordToGuessInArray = new String [wordToGuess.length()];
			wordInPound = createPound(wordToGuess);
			//wordInArray = wordToArray(wordToGuess);
			wordToGuessInArray = wordToArray(wordToGuess);
			while(wrongCount < 7) {
				userGuess = validateUserGuess(userGuess, validInput, input); // validate and store user guess
				wrongCount = guessWord(userGuess,wordToGuessInArray,wordInPound, wrongCount); //replace # in wordToGuess with userGuess if valid, else wrongCount ++
				printWordState(wordInPound, wordToGuess); // print current solve state of the word
				hangmanImage(wrongCount, previousCount, wordToGuess); 
				//print statements to see how counter and inputs work
				//System.out.println("WrongCount: " + wrongCount);
				//System.out.println("previouscount: " + previousCount);
				previousCount = wrongCount; // previousCount equalize ONLY AFTER hangmanImage so that you can see when wrongCount ++, avoid repeated "Wrong guess, try again" of hangmanImage
				//System.out.println("User Guess: " + userGuess);
				//if wordInPound is solved
				if (String.join("",wordInPound).equals(wordToGuess)) {
					System.out.println("Congratulations! You guessed the word right!\n" + wordToGuess);
					System.out.println("Do you still want to play?");
					if (continueGame(input)) {
						gameContinue = true;
						//break out of while (count < 7), loop back to while(gameContinue)
						wrongCount = 10;
					}
					else if (continueGame(input)) {
						gameContinue = false;
					}
				}
				else if (wrongCount == 7) {
					System.out.println("Do you still want to play?");
					if (continueGame(input)) {
						gameContinue = true;
						//break out of while (count < 7), loop back to while(gameContinue)
						wrongCount = 10;
					}
					else if (continueGame(input)) {
						gameContinue = false;
					}
				}	
			}
		}
	}
}

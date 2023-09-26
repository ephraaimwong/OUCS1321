import java.util.Scanner;
public class Project_3 {
	
	//checkWinner method
	public static char checkWinner(char[][] board) {
		//checking row
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != 'E') {
				return board[row][0];
			}
		}
		//checking col
		for (int col = 0; col < 3; col++) {
			if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != 'E') {
				return board[0][col];
			}
		}
		//checking diagonals
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 'E') {
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != 'E') {
			return board[2][0];
		}
		return ' ';
	}

	public static void validateInput(int row, int col, char[][] board, Scanner input, char i, boolean invalid) {
		while (invalid != false) {
			//input here to prompt with every re-loop
			row = input.nextInt();
			col = input.nextInt();
			//if either row or col is outside the board, it will be caught and the re-loop the whileloop
			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("Please enter the correct slot coordinates");
				
			}
			//if space not 'E', reject
			else if (board[row][col] != 'E') {
				System.out.println("The slot is already taken: re-enter slot number:");
				
			}
			//break the whileloop
			else {
				invalid = false;
			}
		}
		//validated input with whileloop before changing values in ticTac board
		board[row][col] = i;
	}
	
	//if no more 'E' on the board then it is full
	public static boolean isBoardFull(char[][] board) {
		for (int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				if (board[row][col] == 'E') {
					return false;
				}
			}
		}
		return true;
	}
	
	//print board
	public static void printBoard(char[][] board) {
		System.out.println("--------------------------------");
		System.out.println("/-----|-----|-----\\");
		System.out.println("|  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |");
		System.out.println("/-----------------\\");
		System.out.println("|  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |");
		System.out.println("/-----------------\\");
		System.out.println("|  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |");
		System.out.println("/-----|-----|-----\\");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declare and initialize 2D arrays for 3 by 3 playing field
		//nested for loop to initialize each cell with "E"
		char[][] ticTac = new char[3][3];
		for (int row = 0; row < ticTac.length; row++) {
			for (int col = 0; col < ticTac[row].length; col++) {
				ticTac[row][col] = 'E';
			}
		}
		int turn = 1;
		int userRow = 0;
		int userCol = 0;
		boolean gameEnded = false;
		boolean invalid = true;
		
		
		//start of the game
		System.out.println("Welcome to 2 player Tic Tac Toe.");
		printBoard(ticTac);
		System.out.println("X's will play first. Enter a slot number to place X in:");
		
		//will loop till game complete
		while (gameEnded != true) {
			if (turn % 2 == 1) {
				System.out.println("Player1's turn");
				validateInput(userRow, userCol, ticTac, input, 'X', invalid);
			}
			if (turn % 2 == 0) {
				System.out.println("Player2's turn");
				validateInput(userRow, userCol, ticTac, input, 'O', invalid);
			}
			
			//GAME ENDING CONDITIONS, will check after every turn
			//Draw condition: full board, no winners
			if(isBoardFull(ticTac) && checkWinner(ticTac) != 'X' && checkWinner(ticTac)!= 'O') {
				System.out.println("It's a draw! Thanks for playing");
				System.out.println("The final result of Tic Tac Toe game is ");
				printBoard(ticTac);
				gameEnded = true;
			}
			//player 2 wins
			if (checkWinner(ticTac) == 'O') {
				System.out.println("Congratulations! O's have won! Thanks for playing.");
				System.out.println("The final result of Tic Tac Toe game is ");
				printBoard(ticTac);
				gameEnded = true;
			}
			//player 1 wins
			else if (checkWinner(ticTac) == 'X') {
				System.out.println("Congratulations! X's have won! Thanks for playing.");
				System.out.println("The final result of Tic Tac Toe game is ");
				printBoard(ticTac);
				gameEnded = true;
			}
			invalid = true;
			//comment out before submission
			//printboard after every successful turn for visualization
			//printBoard(ticTac);
			turn++;
			
		}
	}
}

import java.util.Scanner;
public class test {
	
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
	
	//reject out of bounds input
	//to use out of bounds input have to find a way to reset outOfBounds[userRow][userCol] = false at end of main loop 
	//one idea is to have placeholder coordinate which is reset to at end of every turn eg, [3][3] I know if it is at [3][3] I have to start turn
	/*
	public static boolean outOfBounds(int userRow, int userCol) {
		if (userRow > 2 || userCol > 2 || userRow < 0 || userCol < 0) {
			System.out.println("That slot is outside of the playing field. Please re-enter a slot number:");
			return true;
		}
		return false;
	}
	*/
	public static void validateInput(int row, int col, char[][] board, Scanner input, char i, boolean invalid) {
		// figure out the var
		while (invalid != false) {
			row = input.nextInt();
			col = input.nextInt();
			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("That slot is outside of the playing field. Please re-enter a slot number:");
				
			}
			else if (board[row][col] != 'E') {
				System.out.println("The slot is already taken: re-enter slot number:");
				
			}
			else {
				invalid = false;
			}
		}
		board[row][col] = i;
	}
	
	//checking if board is full
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
		System.out.println("|  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |");
		System.out.println("/-----|-----|-----\\");
		System.out.println("|  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |");
		System.out.println("/-----|-----|-----\\");
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
		int userRow = 3;
		int userCol = 3;
		boolean gameEnded = false;
		boolean invalid = true;
		
		
		//start of the game
		System.out.println("Welcome to 2 player Tic Tac Toe.");
		printBoard(ticTac);
		System.out.println("X's will play first. Enter a slot number to place X in:");
		
		
		while (gameEnded != true) {
			if (turn % 2 == 1) {
				System.out.println("Player1's turn");
				validateInput(userRow, userCol, ticTac, input, 'X', invalid);
				/*while(outOfBounds) {
					userRow = input.nextInt();
					userCol = input.nextInt();
					if (userRow > 2 || userCol > 2 || userRow < 0 || userCol < 0) {
						System.out.println("That slot is outside of the playing field. Please re-enter a slot number:");
						outOfBounds = true;
					}
					else if (ticTac[userRow][userCol] != 'E') {
						System.out.println("The slot is already taken: re-enter slot number:");
						outOfBounds = true;
					}
					else outOfBounds = false;
				}
				
				ticTac[userRow][userCol] = 'X';*/
			
			}
			
			if (turn % 2 == 0) {
				System.out.println("Player2's turn");
				validateInput(userRow, userCol, ticTac, input, 'O', invalid);
				/*
				//hardcoded invalid to enter loop, ifs to catch out of bound and repeat, end of loop reset outOfBounds 
				while(outOfBounds) {
					userRow = input.nextInt();
					userCol = input.nextInt();
					if (userRow > 2 || userCol > 2 || userRow < 0 || userCol < 0) {
						System.out.println("That slot is outside of the playing field. Please re-enter a slot number:");
						outOfBounds = true;
					}
					else if (ticTac[userRow][userCol] != 'E') {
						System.out.println("The slot is already taken: re-enter slot number:");
						outOfBounds = true;
					}
					else outOfBounds = false;
				}
				
				ticTac[userRow][userCol] = 'O';
				*/
				//stays on same turn if out of bound coordinate, but skips to next turn when repeat coordinate entered
				/*System.out.println("Player2's turn");
				while(outOfBounds) {
					userRow = input.nextInt();
					userCol = input.nextInt();
					if (userRow > 2 || userCol > 2 || userRow < 0 || userCol < 0) {
						System.out.println("That slot is outside of the playing field. Please re-enter a slot number:");
						outOfBounds = true;
					}
					else outOfBounds = false;
				}
				if (ticTac[userRow][userCol] == 'E') {
					ticTac[userRow][userCol] = 'X';
				}
				else {
					System.out.println("The slot is already taken: re-enter slot number:");
				}*/
				
				//1st iteration, uses method, throws string, skips to next turn
				/*userRow = input.nextInt();
				userCol = input.nextInt();
				outOfBounds(userRow, userCol);
				if (ticTac[userRow][userCol] == 'E') {
					ticTac[userRow][userCol] = 'O';
				}
				else {
					System.out.println("The slot is already taken: re-enter slot number:");
				}
				*/
			}
			if(isBoardFull(ticTac) && checkWinner(ticTac) != 'X' && checkWinner(ticTac)!= 'O') {
				System.out.println("It's a draw! Thanks for playing");
				printBoard(ticTac);
				gameEnded = true;
			}
			if (checkWinner(ticTac) == 'O') {
				System.out.println("Congratulations! O's have won! Thanks for playing.");
				printBoard(ticTac);
				gameEnded = true;
			}
			else if (checkWinner(ticTac) == 'X') {
				System.out.println("Congratulations! X's have won! Thanks for playing.");
				printBoard(ticTac);
				gameEnded = true;
			}
			invalid = true;
			//comment out before submission
			printBoard(ticTac);
			turn++;
			
		}
	}
}

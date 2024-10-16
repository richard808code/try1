import java.util.Scanner;

public class TicTacToe {
    private char [][] board;
    private char currentPlayer;

    public TicTacToe() {
	board = new char [3][3];
	currentPlayer = 'X';
	initializeBoard();
    }

    public void initializeBoard() {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		board[i][j] = '-';
	    }
	}
    }

    public void printBoard() {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public void switchPlayer() {
	currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWin() {
	return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
	for (int i = 0; i < 3; i++) {
	    if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
		return true;
	    }
	}
	return false;
    }

    private boolean checkColumns() {
	for (int j = 0; j < 3; j++) {
	    if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
		return true;
	    }
	}
	return false;   
     }
    
    private boolean checkDiagonals () {
	if (board[0][0] == currentPlayer && board [1][1] == currentPlayer && board [2][2] == currentPlayer) {
	    return true;
	}
	if (board[0][2] == currentPlayer && board [1][1] == currentPlayer && board [2][0] == currentPlayer) {
	   return true;
	}
	return false;
    }

    public boolean checkDraw() {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (board[i][j] == '-') {
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean placeMark(int row, int col) {
	if (row >= 0 && row < 3 && col >= 0 && col < 3) {
	    if (board[row][col] == '-') {
		board[row][col] = currentPlayer;
		return true;
	    }
	}
	return false;
    }

    public void playGame() {
	Scanner scanner = new Scanner(System.in);
	boolean gameEnded = false;

	while (!gameEnded) {
	    printBoard();
	    int row, col;

	    do {
		System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
		row = scanner.nextInt();
		col = scanner.nextInt();
	    } while (!placeMark(row, col));

	    if (checkWin()) {
		printBoard();
		System.out.println("Player " + currentPlayer + " wins!");
		gameEnded = true;
	    } else if (checkDraw()) {
		printBoard();
		System.out.println("The game is a draw!");
		gameEnded = true;
	    } else {
		switchPlayer();
	    }
	}

	scanner.close();
    }

    public static void main(String[] args) {
	TicTacToe game = new TicTacToe();
	game.playGame();
    }
}

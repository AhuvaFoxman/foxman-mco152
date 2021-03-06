package foxman.connectFour;

public class ConnectFour {

	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private String[][] board;
	private int turn;

	public ConnectFour() {
		this.playerOne = new Player("RED", "Player One");
		this.playerTwo = new Player("YELLOW", "Player Two");
		this.currentPlayer = playerOne;
		this.board = new String[6][7]; // 6 rows, 7 columns
		this.turn = 0; // starts off at 0

		// fill the array with "a" to avoid null pointer exception
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				board[row][col] = "a";
			}
		}
	}

	public int playerTurn(int column) throws FilledColumnException {

		int row;
		for (row = 5; row > -1; row--) {
			if (board[row][column] == "a") {
				board[row][column] = this.currentPlayer.getColor();
				break;
			}

		}
		if (row == -1) {
			throw new FilledColumnException();
		}

		turn++;
		return row;

	}

	public void changeTurn(Player player) {
		if (player.getColor() == playerOne.getColor()) {
			this.currentPlayer = playerTwo;
		} else {
			this.currentPlayer = playerOne;
		}
	}

	public Player getPlayerTurn() {
		return this.currentPlayer;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public String getBoard() {
		// so won't give access to the array
		return this.board.toString();
	}

	public boolean checkBoard() {

		boolean win = false;

		int row;
		int col;
		// check horizontal
		for (row = 0; row < 6; row++) {

			for (col = 0; col < 4; col++) {
				if ((board[row][col] != "a")
						&& board[row][col] == board[row][col + 1]
						&& board[row][col] == board[row][col + 2]
						&& board[row][col] == board[row][col + 3]) {

					win = true;
				}

			}
		}

		// check vertically
		for (row = 0; row < 3; row++) {

			for (col = 0; col < 7; col++) {
				if ((board[row][col] != "a")
						&& board[row][col] == board[row + 1][col]
						&& board[row][col] == board[row + 2][col]
						&& board[row][col] == board[row + 3][col]) {
					win = true;
				}
			}
		}

		// check diagonal - positive slope
		for (row = 3; row < 6; row++) {

			for (col = 0; col < 4; col++) {

				if ((board[row][col] != "a")
						&& board[row][col] == board[row - 1][col + 1]
						&& board[row][col] == board[row - 2][col + 2]
						&& board[row][col] == board[row - 3][col + 3]) {
					win = true;
				}
			}
		}

		// check a negative slope diagonally

		for (row = 0; row < 3; row++) {

			for (col = 0; col < 4; col++) {

				if ((board[row][col] != "a")
						&& board[row][col] == board[row + 1][col + 1]
						&& board[row][col] == board[row + 2][col + 2]
						&& board[row][col] == board[row + 3][col + 3]) {
					win = true;
				}
			}
		}

		return win;

	}

	public boolean checkFull() {
		return (this.turn == 42); // filled up the whole board
	}

}

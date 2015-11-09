package foxman.connectFour;

public class ConnectFour {

	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private String[][] board;

	public ConnectFour() {
		this.playerOne.setColor("RED");
		this.playerTwo.setColor("YELLOW");
		this.currentPlayer = playerOne;
		this.board = new String[7][6]; // 7 rows, 6 columns
		
		//fill the array with "a" to avoid null pointer exception
		for (int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = "a";
			}
		}
	}

	public void playerTurn(int column) {
		
		for(int row = 6; row > 0; row--){
			if(board[row][column] == "a"){
			board[row][column] = this.currentPlayer.getColor();
			}
			
		}
		
		boolean winner  = checkBoard();
		boolean isFull = false;
		if(winner == false){
			isFull = checkFull();
		}
		
		changeTurn(currentPlayer);
		
	}
	
	public void changeTurn(Player player){
		if (player.getColor() == playerOne.getColor()){
			this.currentPlayer = playerTwo;
		}
		else{
			this.currentPlayer = playerOne;
		}
	}
	public Player getTurn(){
		return this.currentPlayer;
	}
	
	public String[][] getBoard(){
		return this.board;
	}

	
	public boolean checkBoard() {

		boolean win = false;
		// check horizontal

		for (int row = 0; row < board.length; row++) {

			for (int col = 0; col < board[row].length; col++) {
				if ((board[row][col] != "a")
						&& board[row][col] == board[row][col + 1]
						&& board[row][col] == board[row][col + 2]
						&& board[row][col] == board[row][col + 3]) {

					win = true;
				}

			}

			// check vertically
			for (row = 0; row < board.length; row++) {

				for (int col = 0; col < board[row].length; col++) {

					if ((board[row][col] != "a")
							&& board[row][col] == board[row + 1][col]
							&& board[row][col] == board[row + 2][col]
							&& board[row][col] == board[row + 3][col]) {
						win = true;
					}
				}
			}

			// check diagonal - positive slope
			for (row = 0; row < board.length; row++) {

				for (int col = 0; col < board[row].length; col++) {

					if ((board[row][col] != "a")
							&& board[row][col] == board[row + 1][col + 1]
							&& board[row][col] == board[row + 2][col + 2]
							&& board[row][col] == board[row + 3][col + 3]) {
						win = true;
					}
				}
			}

			// check a negative slope diagonally
			// must start when row is at 3 because that is the only time it
			// could be a win
			for (row = 3; row < board.length; row++) {

				for (int col = 0; col < board[row].length; col++) {

					if ((board[row][col] != "a")
							&& board[row][col] == board[row - 1][col + 1]
							&& board[row][col] == board[row - 2][col + 2]
							&& board[row][col] == board[row - 3][col + 3]) {
						win = true;
					}
				}
			}

		}
		return win;

	}
	
	public boolean checkFull(){
		boolean full = false;
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col ++){
				if(board[row][col] == null){
					full = false;
				}
				else{
					full = true;;
				}
			}
		}
		return full;
	}
	
	
}

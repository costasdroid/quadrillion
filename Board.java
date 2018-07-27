public class Board {
	private int[][] board;
	private int x;
	private int y;
	private int nextAvailiableX;
	private int nextAvailiableY;
	private int number;

	public Board(int x, int y) {
		this.x = x;
		this.y = y;
		nextAvailiableX = 0;
		nextAvailiableY = 0;
		number = 1;
		board = new int[x][y];
	}

	public void block(int x, int y) {
		board[x - 1][y - 1] = 1;
		nextAvailiable();
	}

	public boolean canPlace(Piece piece) {
		// if it is bigger in x return false
		if (nextAvailiableX + piece.x > x) return false;
		// if it is bigger in y return false
		if (nextAvailiableY - piece.column < 0 || nextAvailiableY - piece.column + piece.y > y) return false;
		// if it is occupied return false
		for (int i = 0; i < piece.x; i++) {
			for (int j = 0; j < piece.y; j++) {
				// offset the piece for "column" to the left
				if (piece.configuration[i][j] && board[nextAvailiableX + i][nextAvailiableY - piece.column + j] != 0) return false;
			}
		}
		return true;
	}

	public void place(Piece piece) {
		number++;
		for (int i = 0; i < piece.x; i++) {
			for (int j = 0; j < piece.y; j++) {
				if (piece.configuration[i][j]) {
					board[nextAvailiableX + i][nextAvailiableY - piece.column + j] = number;
				}
			}
		}
		nextAvailiable();
	}

	private void nextAvailiable() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 0) {
					nextAvailiableX = i;
					nextAvailiableY = j;
					return;
				}
			}
		}
	}

	public void showBoard() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void popPiece() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == number) board[i][j] = 0;
			}
		}
		number--;
		nextAvailiable();
	}
}

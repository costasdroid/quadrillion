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
		if (piece.x != 0) return false;
		for (int i = 0; i < piece.size; i++) {
			for (int j = 0; j < piece.size; j++) {
				if (piece.data[i][j] && (nextAvailiableX - piece.x + i >= x || nextAvailiableX - piece.x + i < 0 || nextAvailiableY - piece.y + j >= y ||nextAvailiableY - piece.y + j < 0 || board[nextAvailiableX - piece.x + i][nextAvailiableY - piece.y + j] != 0)) return false;
			}
		}
		return true;
	}

	public void place(Piece piece) {
		number++;
		for (int i = 0; i < piece.size; i++) {
			for (int j = 0; j < piece.size; j++) {
				if (piece.data[i][j]) board[nextAvailiableX - piece.x + i][nextAvailiableY - piece.y + j] = number;
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
				System.out.print(board[i][j] + "\t \u001B[33m");
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

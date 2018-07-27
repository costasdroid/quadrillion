public class Piece {
	// description of the piece in terms of true - false
	public boolean[][] configuration;
	// the first occurence of pice on the first row
	public int column;
	// size of piece
	public int x;
	public int y;

	public Piece(boolean[][] b) {
		configuration = b;
		x = b.length;
		y = b[0].length;
		findPoint();
	}

	private void findPoint() {
		for (int j = 0; j < y; j++) {
			if (configuration[0][j]) {
				column = j;
				return;
			}
		}
	}

}

public class Piece {
	public boolean[][] data;
	public int x = 0;
	public int y = 0;
	public int size;
	public static int index = 1;
	public String name;

	public Piece(boolean[][] b) {
		data = b;
		size = b.length;
		name = "piece" + (index++);
		findPoint();
	}

	private void findPoint() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (data[i][j]) {
					x = i;
					y = j;
					return;
				}
			}
		}
	}

	public void mirrorX() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size / 2; j++) {
				boolean temp = data[i][j];
				data[i][j] = data[i][size - j - 1];
				data[i][size - j - 1] = temp;
			}
		}
		// showPiece(data);
		findPoint();
	}

	public void transpose() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				boolean temp = data[i][j];
				data[i][j] = data[j][i];
				data[j][i] = temp;
			}
		}
		// showPiece(data);
		findPoint();
	}

	public void showPiece() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(data[i][j] + "   ");
			}
			System.out.println();
		}
	}

}

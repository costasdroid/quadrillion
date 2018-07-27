import java.util.*;

public class Pieces {
	private boolean[][] configuration;
	public ArrayList<Piece> pieces = new ArrayList<Piece>();
	public static int index = 1;
	public String name;
	public String color;

	public Pieces(boolean[][] b, String color) {
		configuration = b;
		pieces.add(new Piece(configuration));
		name = "block" + index++;
		this.color = color;
		tranformations();
	}

	private void tranformations() {
		for (int symmetries = 0; symmetries < 4; symmetries++) {
			configuration = mirrorX();
			if (!exists()) {
				pieces.add(new Piece(configuration));
			}
			configuration = transpose();
			if (!exists()) {
				pieces.add(new Piece(configuration));
			}
		}
		configuration = mirrorX();
		if (!exists()) {
			pieces.add(new Piece(configuration));
		}
	}

	public boolean[][] mirrorX() {
		int x = configuration.length;
		int y = configuration[0].length;
		boolean[][] temp = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = configuration[i][y - j - 1];
			}
		}
		return temp;
	}

	public boolean[][] transpose() {
		int x = configuration[0].length;
		int y = configuration.length;
		boolean[][] temp = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = configuration[j][i];
			}
		}
		return temp;
		// System.out.println(configuration);
	}

	private boolean exists() {
		int x = configuration.length;
		int y = configuration[0].length;
		boolean foundDif;
		for (Piece piece: pieces) {
			foundDif = false;
			if (x != piece.x || y != piece.y) continue;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (piece.configuration[i][j] != configuration[i][j]) {
						foundDif = true;
					}
				}
			}
			if (!foundDif) return true;
		}
		return false;
	}

	public void showPiece(Piece p) {
		for (int i = 0; i < p.x; i++) {
			for (int j = 0; j < p.y; j++) {
				System.out.print(p.configuration[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

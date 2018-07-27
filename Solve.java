import java.util.*;

public class Solve {

	static int solutions = 0;
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static void main(String[] args) {

		Board b = new Board(8, 8);
		boolean[][] piece1 = {{true, false}, {true, true}}; //cyan
		boolean[][] piece2 = {{true, false}, {true, true}, {true, true}}; //light green
		boolean[][] piece3 = {{true, false}, {true, true}, {false, true}}; //very red
		boolean[][] piece4 = {{true, false, false}, {true, true, false}, {false, true, true}}; //purple
		boolean[][] piece5 = {{true, false, false}, {true, true, true}, {true, false, false}}; //petrol
		boolean[][] piece6 = {{true, false, false}, {true, true, true}, {false, true, false}}; //orange
		boolean[][] piece7 = {{true, false, false}, {true, true, true}, {false, false, true}}; //blue
		boolean[][] piece8 = {{true, true}, {true, false}, {true, true}}; //green
		boolean[][] piece9 = {{true, false, false}, {true, false, false}, {true, true, true}}; //light blue
		boolean[][] piece10 = {{true, false}, {true, false}, {true, false}, {true, true}}; //red
		boolean[][] piece11 = {{true, false}, {true, true}, {false, true}, {false, true}}; //pink
		boolean[][] piece12 = {{true, false}, {true, true}, {true, false}, {true, false}}; //yellow

		b.block(1, 4);
		b.block(1, 5);
		b.block(1, 8);
		b.block(3, 3);
		b.block(5, 4);
		b.block(5, 6);
		b.block(6, 2);
		// b.showBoard();

		// for (int i = 1; i <= 2; i++) {
		//  for (int j = 1; j <= 4; j++) {
		//    b.block(i, j);
		//  }
		// }
		// for (int i = 1; i <= 4; i++) {
		//  for (int j = 9; j <= 10; j++) {
		//    b.block(i, j);
		//  }
		// }
		// for (int i = 7; i <= 10; i++) {
		//  for (int j = 1; j <= 2; j++) {
		//    b.block(i, j);
		//  }
		// }
		// for (int i = 9; i <= 10; i++) {
		//  for (int j = 7; j <= 10; j++) {
		//    b.block(i, j);
		//  }
		// }
		// for (int i = 5; i <= 6; i++) {
		//  for (int j = 5; j <= 6; j++) {
		//    b.block(i, j);
		//  }
		// }

		// b.showBoard();

		ArrayList<Pieces> pi = new ArrayList<Pieces>();
		pi.add(new Pieces(piece1, ANSI_CYAN));
		pi.add(new Pieces(piece2, ANSI_GREEN));
		pi.add(new Pieces(piece3, ANSI_CYAN));
		pi.add(new Pieces(piece4, ANSI_PURPLE));
		pi.add(new Pieces(piece5, ANSI_GREEN));
		pi.add(new Pieces(piece6, ANSI_YELLOW));
		pi.add(new Pieces(piece7, ANSI_BLUE));
		pi.add(new Pieces(piece8, ANSI_GREEN));
		pi.add(new Pieces(piece9, ANSI_BLUE));
		pi.add(new Pieces(piece10, ANSI_PURPLE));
		pi.add(new Pieces(piece11, ANSI_PURPLE));
		pi.add(new Pieces(piece12, ANSI_YELLOW));

		recursion(pi, new ArrayList<Pieces>(), b);
		System.out.println(solutions);

	}

	public static void recursion(ArrayList<Pieces> left, ArrayList<Pieces> constracted, Board b) {
		if (left.size() == 0) {
			b.showBoard();
			System.out.println();
			solutions++;
		}
		for (int i = 0; i < left.size(); i++) {
			Pieces current = left.get(i);
			for (Piece temp: left.get(i).pieces) {
				if (b.canPlace(temp)) {
					b.place(temp);
					left.remove(i);
					constracted.add(current);
					recursion(left, constracted, b);
					left.add(i, current);
					constracted.remove(constracted.size() - 1);
					b.popPiece();
				}
			}
		}
	}

}

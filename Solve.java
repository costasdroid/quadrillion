import java.util.*;

public class Solve {

	static int solutions = 0;

	public static void main(String[] args) {

		Board b = new Board(8, 8);
		boolean[][] piece1 = {{true, false}, {true, true}};
		boolean[][] piece2 = {{true, false, false}, {true, true, false}, {true, true, false}};
		boolean[][] piece3 = {{true, false, false}, {true, true, false}, {false, true, false}};
		boolean[][] piece4 = {{true, false, false}, {true, true, false}, {false, true, true}};
		boolean[][] piece5 = {{true, false, false}, {true, true, true}, {true, false, false}};
		boolean[][] piece6 = {{true, false, false}, {true, true, true}, {false, true, false}};
		boolean[][] piece7 = {{true, false, false}, {true, true, true}, {false, false, true}};
		boolean[][] piece8 = {{true, true, false}, {true, false, false}, {true, true, false}};
		boolean[][] piece9 = {{true, false, false}, {true, false, false}, {true, true, true}};
		boolean[][] piece10 = {{true, false, false, false}, {true, false, false, false}, {true, false, false, false}, {true, true, false, false}};
		boolean[][] piece11 = {{true, false, false, false}, {true, true, false, false}, {false, true, false, false}, {false, true, false, false}};
		boolean[][] piece12 = {{true, false, false, false}, {true, true, false, false}, {true, false, false, false}, {true, false, false, false}};

		b.block(2, 4);
		b.block(3, 5);
		b.block(4, 4);
		b.block(5, 1);
		b.block(5, 5);
		b.block(6, 7);
		b.block(8, 3);
		// b.showBoard();


		ArrayList<Piece> pi = new ArrayList<Piece>();
		pi.add(new Piece(piece1));
		pi.add(new Piece(piece2));
		pi.add(new Piece(piece3));
		pi.add(new Piece(piece4));
		pi.add(new Piece(piece5));
		pi.add(new Piece(piece6));
		pi.add(new Piece(piece7));
		pi.add(new Piece(piece8));
		pi.add(new Piece(piece9));
		pi.add(new Piece(piece10));
		pi.add(new Piece(piece11));
		pi.add(new Piece(piece12));

		recursion(pi, new ArrayList<Piece>(), b);
		System.out.println(solutions);

	}

	public static void recursion(ArrayList<Piece> left, ArrayList<Piece> constracted, Board b) {
		// for (Piece p: constracted) {
		//  System.out.print(p.name + ", ");
		// }
		// System.out.println();
		// b.showBoard();
		if (left.size() == 0) {
			b.showBoard();
			System.out.println();
			solutions++;
		}
		for (int i = 0; i < left.size(); i++) {
			Piece temp = left.get(i);
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.mirrorX();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.transpose();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.mirrorX();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.transpose();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.mirrorX();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.transpose();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
			temp.mirrorX();
			if (b.canPlace(temp)) {
				b.place(temp);
				left.remove(i);
				constracted.add(temp);
				recursion(left, constracted, b);
				left.add(i, temp);
				constracted.remove(constracted.size() - 1);
				b.popPiece();
			} else {
				// System.out.println("cannot place " + temp.name);
			}
		}
	}

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessDiagramEditor;

/**
 *
 * @author jtc
 */
public final class Figures {

	public static final int KING_W = 0;
	public static final int QUEEN_W = 1;
	public static final int ROOK_W = 2;
	public static final int BISHOP_W = 3;
	public static final int KNIGHT_W = 4;
	public static final int PAWN_W = 5;
	public static final int KING_B = 6;
	public static final int QUEEN_B = 7;
	public static final int ROOK_B = 8;
	public static final int BISHOP_B = 9;
	public static final int KNIGHT_B = 10;
	public static final int PAWN_B = 11;

	public static String[] figures = initializeFigures();

	private static String[] initializeFigures()
	{
		String[] figures = new String[12];

		figures[KING_W] = "Chess_klt60.png";
		figures[QUEEN_W] = "Chess_qlt60.png";
		figures[ROOK_W] = "Chess_rlt60.png";
		figures[BISHOP_W] = "Chess_blt60.png";
		figures[KNIGHT_W] = "Chess_nlt60.png";
		figures[PAWN_W] = "Chess_plt60.png";
		figures[KING_B] = "Chess_kdt60.png";
		figures[QUEEN_B] = "Chess_qdt60.png";
		figures[ROOK_B] = "Chess_rdt60.png";
		figures[BISHOP_B] = "Chess_bdt60.png";
		figures[KNIGHT_B] = "Chess_ndt60.png";
		figures[PAWN_B] = "Chess_pdt60.png";

		return figures;
	}

}

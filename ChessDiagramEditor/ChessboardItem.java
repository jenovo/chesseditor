/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessDiagramEditor;

/**
 *
 * @author jtc
 */
public class ChessboardItem {

	public static final int FIGURE = 0;
	public static final int HIGHLIGHT = 1;
	public static final int ARROW = 2;

	int type;
	int variant;

	public ChessboardItem(int type, int variant) {
		this.type = type;
		this.variant = variant;
	}

}

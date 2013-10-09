/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessDiagramEditor;

import java.util.ArrayList;

/**
 *
 * @author jtc
 */
public class ChessboardModel {

	public ChessboardItem[][][] grid = new ChessboardItem[8][8][2];

	public void addItem(int x, int y, ChessboardItem item) {
		grid[x-1][y-1][0] = item;
	}

	public void removeItem(int x, int y, int type) {
		grid[x-1][y-1][type] = null;
	}

	public ChessboardItem getItem(int x, int y, int index) {
		return grid[x-1][y-1][index];
	}



}

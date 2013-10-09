/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessDiagramEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author jtc
 */
public class ChessDiagramEditor {

	public JList figures;
	public Chessboard chessboard;

	public ChessDiagramEditor() 
	{
		JFrame frame = new JFrame("Chessboard Diagram Editor");
		frame.setLayout(new FlowLayout());
		frame.setSize(750, 560);
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {

			DefaultListModel figuresListModel = new DefaultListModel();

			for (int i = 0; i < 13; i++)
			{
				//System.out.println(Figures.figures);

				ImageIcon figure = new ImageIcon(ImageIO.read(getClass().getResource("resources/"+Figures.figures[i])));
				figuresListModel.add(i, figure);
			}

			figures = new JList(figuresListModel);

			figures.setVisibleRowCount(6);
			figures.setLayoutOrientation(JList.VERTICAL_WRAP);

			figures.setMaximumSize(new Dimension(50, 468));

			chessboard = new Chessboard();

			frame.getContentPane().add(new JScrollPane(figures), BorderLayout.WEST);

			chessboard.addMouseListener(new MouseListener()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					System.out.println("x:"+e.getComponent().toString());
					System.out.println(figures.getSelectedIndex());

					int listIndex = figures.getSelectedIndex();

					if (listIndex >= 0) {
						try {

							Point field = Chessboard.getBoardField(e.getPoint());

							if (SwingUtilities.isLeftMouseButton(e)) {

								System.out.println("x:"+field.x+"  y:"+field.y);
								ChessboardItem item = new ChessboardItem(ChessboardItem.FIGURE, listIndex);
								System.out.println(item);
								chessboard.addItem(field.x, field.y, item);
							}

							if (SwingUtilities.isRightMouseButton(e)) {
								chessboard.removeItem(field.x, field.y, ChessboardItem.FIGURE);
							}


							chessboard.repaint();

						} catch (NoPointException exc) {}
					}

					/*figures.clearSelection();
					figures.getSelectionModel().setLeadSelectionIndex(-1);*/
				
				}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}
			});

			frame.getContentPane().add(chessboard, BorderLayout.NORTH);

		} catch (Exception e) {

		}

		frame.setVisible(true);
		//JOptionPane.showMessageDialog(frame, "Welcome!");

	}

	public static void main(String[] args)
	{
		new ChessDiagramEditor();
	}

}


package ChessDiagramEditor;

import java.awt.*;  // Notice these dynamic imports
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

 /**
 *
 * @author jtc
 */
public class Chessboard extends JComponent
{

	private Image backgroundImage;
	private ChessboardModel board = new ChessboardModel();

	public Chessboard() throws IOException
	{
		//URL url = ChessDiagramEditor.class.getResource("/ChessDiagramEditor/xresources/chessboard.png");
		//backgroundImage = ImageIO.read(url);
		backgroundImage = ImageIO.read(new File("/home/jtc/Stažené/Chess/chessboard.png"));
		setPreferredSize(new Dimension(458,468));
	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		//graphics.setColor(Color.red);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawImage(backgroundImage,0,0, this);

		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {

				try {
					
					ChessboardItem item = board.getItem(x,y,0);

					int locx = (x-1)*48+33;
					int locy = (y-1)*48+38;

					if (item != null) {
						/*graphics.setColor(Color.blue);
						graphics.fillOval(locx+24, locy+24, 6, 6);*/

						try {

							System.out.println("v:"+item.variant);
							Image figure = ImageIO.read(new File("/home/jtc/Stažené/Chess/figures/"+Figures.figures[item.variant]));
							graphics.drawImage(figure,locx,locy, this);
						} catch(IOException exc) {}
					}
					
				} catch (NullPointerException exc) {}
			}
		}

	}

	public static Point getBoardField(Point point) throws NoPointException
	{
		int boardTopLeftX = 36;
		int boardTopLeftY = 41;
		int gridSize = 48;

		if (point.x < boardTopLeftX || point.y < boardTopLeftY) {
			throw new NoPointException("No point.");
		}

		int x = 1 + (point.x - boardTopLeftX) / gridSize;
		int y = 1 + (point.y - boardTopLeftY) / gridSize;

		if (x > 0 && x <= 8 && y > 0 && y <=8) {
			return new Point(x, y);
		} else {
			throw new NoPointException("No point.");
		}
	}

	public void addItem(int x, int y, ChessboardItem item) {
		board.addItem(x, y, item);
	}

	public void removeItem(int x, int y, int type) {
		board.removeItem(x, y, type);
	}

}

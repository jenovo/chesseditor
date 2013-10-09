/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessDiagramEditor;

/**
 *
 * @author jtc
 */
public class NoPointException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>NoPointException</code> without detail message.
	 */
	public NoPointException() {
	}

	/**
	 * Constructs an instance of
	 * <code>NoPointException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public NoPointException(String msg) {
		super(msg);
	}
}

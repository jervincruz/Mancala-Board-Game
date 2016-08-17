import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

/** @Decorator
 * Sets the amount of stones per pit and draws the board
 */

public interface BoardType{
    public void setInitial(int i);
    public void draw(Graphics g);
	public ArrayList<Shape> getList();
}

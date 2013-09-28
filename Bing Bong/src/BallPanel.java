import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

public class BallPanel extends JPanel {

	private Collection<Ball> _collection;
	
	private int _width;
	private int _height;
	
	public BallPanel(int w, int h){
		super();
		
		_width = w;
		_height = h;
	}

	public void setCollection(Collection<Ball> col) {
		_collection = col;
	}

	@Override
	public void paint(Graphics g) {
		//System.out.println("Paint BallPanel");
		
		super.paint(g);

		if (_collection != null) {
			Iterator<Ball> it = _collection.iterator();

			int i = 0;
			
			while (it.hasNext()) {
				
				//System.out.println("Drawing Ball " + i);
				
				Ball b = it.next();

				b.calculateNextLocation(_width, _height);
				
				b.paint(g);
				
				i++;
			}
		}
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

}

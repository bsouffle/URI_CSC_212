/*
 *
 *	BasicElement.java
 *
 */

import java.awt.*;
import java.awt.event.*;

public class Item
{

	private int x;
	private int y;
	private int value;
	
	// Constructor of the class which receives the x and y coordinates
	public Item(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// public setter of the value attribute of the class
	public void setValue(int i) {
		this.value = i;
	}

	// Public getter of the value attribute of the class
	public int getValue() {
		return value;
	}

	/*
	 *	The following piece of code is all we have been able to salvage after the crash
	 *		of Nickie's computer.  Your job is to reconstruct the whole class, based on
	 *		its use in the rest of the program.
	 *

		//
		//	Drawing an element
		//
		 *
		 */
	public void paint(Graphics pane, Color color)
	{
		final int					//		the visual characteristics of an element
				DELTA = 5,		//	For the size of the element's "bottom line"
				WIDTH = 20,		//		the width of the element
				HEIGHT = 10;	//		the incremental height
								//			(as a unit of the element's value)

		pane.setColor(Color.black);			//	Drawing the element's "bottom line"
		pane.drawLine(x-DELTA, y, x+WIDTH+DELTA, y);

		pane.setColor(Color.black);			//	Drawing the frame in black
		pane.drawRect(x, y - HEIGHT*value, WIDTH, HEIGHT*value);
											//		and the element itself
		pane.setColor(color);				//		in just the right color
		pane.fillRect(x + 1, y - HEIGHT*value + 1, WIDTH - 1, HEIGHT*value - 1);
	}
}
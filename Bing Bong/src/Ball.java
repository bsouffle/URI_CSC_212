import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Ball {
	
	private static final float BOUNCING_FACTOR = 1.1f;
	
	private static final float GRAVITY = 1.2f;
	
	private static Color[] COLORS = {Color.black, Color.blue, Color.red, Color.green, Color.orange, Color.yellow};
	
	private static float SPEED = 2;
	
	private Point _velocity;
	
	private int _size;
	private Point _location;
	private Color _color;
	
	public Ball(int size, Point p, Color c){
		_size = size;
		_location = p;
		_color = c;
		
		_velocity = new Point((int)(4*SPEED), (int)SPEED);
	}

	public double getSize() {
		return _size;
	}

	public void setSize(int _size) {
		this._size = _size;
	}

	public Point getLocation() {
		return _location;
	}

	public void setLocation(Point _location) {
		this._location = _location;
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color _color) {
		this._color = _color;
	}

	public static float getSpeed() {
		return SPEED;
	}

	public static void setSpeed(float _speed) {
		if(_speed > 1) SPEED = _speed;
	}
	
	public void paint(Graphics g){
		print();
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(_color);
	    g2d.fillOval(_location.x, _location.y, _size, _size);
	    
	    g2d.setPaint(Color.black);
	    Shape theCircle = new Ellipse2D.Double(_location.x, _location.y, _size, _size);
	    g2d.draw(theCircle);
	}
	
	public void calculateNextLocation(int width, int height){
		
		_velocity.y += GRAVITY;
		
		if(_location.x <= (0) || _location.x >= (width -_size)){
			_velocity.x = - _velocity.x;
		}
		else if(_location.y <= (0) || _location.y >= (height - _size)){
			_velocity.y = (int) (- _velocity.y * BOUNCING_FACTOR);
		}
			
		_location.x += _velocity.x * SPEED;
		_location.y += _velocity.y * SPEED;
		
		if(_location.y >= (height - _size)) _location.y = (height - _size);
		if(_location.y <= 0) _location.y = 0;
	}
	
	private void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Color: " + _color);
		sb.append(" Size: " + _size);
		sb.append(" Location: " + _location);
		sb.append(" Velocity: " + _velocity);
		
		System.out.println(sb);
	}

	public static Ball createRandomBall(int width, int height){
		
		Color color = COLORS[(int) ((Math.random()) * COLORS.length)];
		int size = (int) ((Math.random()) * 10) + 25; 
		
		Point loc = new Point((int) (Math.random() * (width - size)), (int) (Math.random() * (height - size)));
		
		Ball b = new Ball(size, loc, color);
		
		return b;
	} 
}

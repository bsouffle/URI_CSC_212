import java.awt.Graphics;


public interface DataCollection<T> {
	
	public void add(T item);
	
	public void remove();
	
	public void reset();
	
	public void reset(T item);
	
	public boolean hasNext();
	
	public T next();
	
	public void paint(Graphics pane);
}

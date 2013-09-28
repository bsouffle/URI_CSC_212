import java.util.Iterator;


public interface Collection<T> {

	public boolean isEmpty();
	
	public void add(T item);
	
	public T remove();
	
	public Iterator<T> iterator();
	
	public void clear();
}

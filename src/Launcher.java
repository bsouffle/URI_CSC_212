
public class Launcher {

	public static void main(String[] args) {
		Date d = new Date();
		d.print();
		
		d.advance();
		d.print();
		
		Date d2 = new Date(2,28,2013);
		d2.print();
		
		d2.advance();
		d2.print();
		
		Date d3 = new Date(2,28,2012);
		d3.print();
		
		d3.advance();
		d3.print();
		
		d3.advance();
		d3.print();
	}

}

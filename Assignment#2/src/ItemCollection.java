import java.awt.Color;
import java.awt.Graphics;


public class ItemCollection implements DataCollection<Item>{
	
	private Item[] mData;
	
	private int mSize = 0;
	
	private final static int MAX_SIZE = 10;
	
	private Item mSelectedItem;

	public ItemCollection(){
		mData = new Item[MAX_SIZE];
	}
	
	@Override
	public void add(Item item){
			
		if(mSize + 1 > MAX_SIZE){
			System.out.println("DataCollection max size reached");
		}
		else{
			mData[mSize++] = item;
			
			System.out.println("New Item added: " + mSize);
		}
	}

	@Override
	public void remove() {
		if(mSelectedItem != null){
			final int index = indexOf(mSelectedItem);
			if (index != -1) {
				for(int i = index; i < mSize - 1; i++){
					mData[i] = mData[i + 1];
				}
				
				mSize--;
			}
		}
	}

	@Override
	public void reset() {
		if(!isEmpty()){
			mSelectedItem = mData[0];
		}
	}

	@Override
	public void reset(Item item) {
		 if(!isEmpty()){
			 if(contains(item)) mSelectedItem = item;
		 }
	}

	@Override
	public boolean hasNext() {
		if(mSelectedItem != null){
			
			int pos = indexOf(mSelectedItem);
			
			if(pos == mSize - 1) return false;
			
			return true;
		}
		
		return false;
	}

	@Override
	public Item next() {
		
		Item tmp = mSelectedItem;
		
		if(hasNext()){
			int pos = indexOf(tmp);
			
			mSelectedItem = mData[pos + 1];
		}
		
		return tmp;
	}

	@Override
	public void paint(Graphics pane) {
		for(int i = 0; i < mSize; i++){
			//System.out.println("Painting: " + mData[i].getValue());
			if(mData[i] == mSelectedItem){
				mData[i].paint(pane, Color.red);
			}
			else mData[i].paint(pane, Color.yellow);
		}
	}

	private boolean isEmpty(){
		return mSize == 0;
	}
	
	private boolean contains(Item item){
		return indexOf(item) >= 0;
	}
	
	private int indexOf(Item item){
		for(int i = 0; i < mSize; i++){
			if(mData[i] == item) return i;
		}
		
		return -1;
	}
}

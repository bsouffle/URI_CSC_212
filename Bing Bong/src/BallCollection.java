import java.util.Iterator;

public class BallCollection implements Collection<Ball>, Iterable<Ball>{

	private BallNode _firstNode;

	@Override
	public boolean isEmpty() {
		return _firstNode == null;
	}

	@Override
	public void add(Ball item) {
		BallNode newNode = new BallNode(item, _firstNode);

		_firstNode = newNode;
	}

	@Override
	public Ball remove() {
		if (!isEmpty()) {
			BallNode tmp = _firstNode;

			_firstNode = _firstNode.getNext();

			return tmp.getBall();
		}

		return null;
	}

	private class BallNode {
		private BallNode _nextNode;
		private Ball _ball;

		public BallNode(Ball b, BallNode next) {
			_nextNode = next;
			_ball = b;
		}

		public BallNode getNext() {
			return _nextNode;
		}

		public Ball getBall() {
			return _ball;
		}
	}

	@Override
	public Iterator<Ball> iterator() {
		Iterator<Ball> it = new Iterator<Ball>(){
			private BallNode _currentNode = new BallNode(null, _firstNode);
			
			@Override
			public boolean hasNext() {
				if(!isEmpty()){
					return _currentNode.getNext() != null;
				}
				
				return false;
			}

			@Override
			public Ball next() {
				if(hasNext()){
					Ball tmp = _currentNode.getNext().getBall();
					
					_currentNode = _currentNode.getNext();
					
					return tmp;
				}
				
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
		
		return it;
	}

	@Override
	public void clear() {
		_firstNode = null;
	}
}

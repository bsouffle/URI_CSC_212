import java.awt.Graphics;

public class DataOrganizer {

	private DataCollection<Item> mItemCollection;

	public void generateAndDisplayRandomStats() {
		mItemCollection = new ItemCollection();

		int y = 180;

		for (int i = 0; i < 10; i++) {
			int x = 30 * i;

			Item item = new Item(x, y);
			item.setValue((int) (1 + 17 * Math.random()));

			mItemCollection.add(item);
		}
	}

	public void selectMaximum() {
		if (mItemCollection != null) {
			mItemCollection.reset();

			if (mItemCollection.hasNext()) {
				Item max = mItemCollection.next();

				Item tmp;
				while (mItemCollection.hasNext()) {
					tmp = mItemCollection.next();

					if (tmp.getValue() > max.getValue()) {
						max = tmp;
					}
				}

				// Checking the last item of the collection
				Item last = mItemCollection.next();
				if (last.getValue() > max.getValue()) {
					max = last;
				}

				mItemCollection.reset(max);
			}
		}

	}

	public void selectMinimum() {
		if (mItemCollection != null) {
			mItemCollection.reset();

			if (mItemCollection.hasNext()) {
				Item min = mItemCollection.next();

				Item tmp;
				while (mItemCollection.hasNext()) {
					tmp = mItemCollection.next();

					if (tmp.getValue() < min.getValue()) {
						min = tmp;
					}
				}

				// Checking the last item of the collection
				Item last = mItemCollection.next();
				if (last.getValue() < min.getValue()) {
					min = last;
				}

				mItemCollection.reset(min);
			}
		}
	}

	public void removeSelected() {
		if (mItemCollection != null) {
			mItemCollection.remove();
		}
	}

	public void paint(Graphics pane) {
		if (mItemCollection != null) {
			mItemCollection.paint(pane);
		}
	}
}

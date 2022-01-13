public class PriorityQueueArrayList<E extends Comparable<E>> {
	
	/* Zeynep Özarslan, 041802044, 5 December 2020 */
	/* This is a priority queue implementation based on sorted array list */

	public java.util.ArrayList<E> list = new java.util.ArrayList<>();

	public boolean isEmpty() {
		return list.size() == 0;
	}

	// adds an element to array list to the location where it should be inserted
	public void enqueue(E newObject) {
		int i = 0;
		int currentSize = list.size();
		// loop to find the index to be added with the logic of the binary search algorithm
		while (i < currentSize) {
			int mid = i + (currentSize - 1 - i) / 2;
			// if the object to be added is greater, ignore left half
			if (list.get(mid).compareTo(newObject) < 0)
				i = mid + 1;
			// if the object to be added is smaller or equal, ignore right half
			else
				currentSize = mid;
		}
		list.add(i, newObject);
	}

	// removes the last element from the array list
	public void dequeue() {
		if (!isEmpty())
			list.remove(list.size() - 1);
	}

	// method to print the array list
	public String toString() {
		return list.toString();
	}
}

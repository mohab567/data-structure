package eg.edu.alexu.csd.datastructure.queue.cs80;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.cs80.DList;
/**
 * @author DELL
 *
 */
public class LinkedQueue implements IQueue, ILinkedBased {
	/**
	 * linked list for queue.
	 */
DList queue = new DList();

	@Override
	public void enqueue(final Object item) {
queue.add(item);

	}

	@Override
	public Object dequeue() {
		Object temp = queue.get(0);
           queue.remove(0);
        return temp;
	}

	@Override
	public boolean isEmpty() {
return queue.isEmpty();
	}

	@Override
	public int size() {
return queue.size();
	}

}

package eg.edu.alexu.csd.datastructure.queue.cs80;
import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 * @author DELL
 *
 */
public class ArrayQueue implements IQueue, IArrayBased {
	/**
	 * f is frist and r = one step after last while n is the max size.
	 */
	int f = 0, r = 0, n;
	/**
	 * queue array.
	 */
	Object[] arr;
	/**
	 * constarctor.
	 * @param size of array
	 */
ArrayQueue(final int size) {
	arr = new Object[size + 1];
	n = size + 1;
}
	@Override
	public void enqueue(final Object item) {
		if (r + 1 == f || (f == 0 && r == n - 1)) {
			throw new RuntimeException();
		}
    arr[r] = item;
    r = (r + 1) % n;
	}

	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
Object temp = arr[f];
arr[f] = null;
f = (f + 1) % n;
		return temp;
	}

	@Override
	public boolean isEmpty() {

		return f == r;
	}

	@Override
	public int size() {
		return (n - f + r) % n;
	}

}

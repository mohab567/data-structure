package eg.edu.alexu.csd.datastructure.queue.cs80;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


/**
 * to test array queue.
 * @author DELL
 *
 */
public class LinkedQueueTest {


	/**
	 * tests enqueue,dequeue and empty.
	 */
	@Test
	public void enqueueDequeue() {
		final int size = 99;
		LinkedQueue x = new LinkedQueue();
		final int element = 5;
		for (int i = 0; i < size; i++) {
		x.enqueue(element);
		x.dequeue();
		}
		assertTrue(x.isEmpty());
	}
	/**
	 * enqueue and test size.
	 */
	@Test
	public void fullqueue() {
		final int size = 99;
		LinkedQueue x = new LinkedQueue();

		for (int i = 0; i < size; i++) {
		x.enqueue(Math.random());
		}
		assertEquals(x.size(), size);
	}
	/**
	 * fill queue then dequeue.
	 */
	@Test
	public void testDequeuefull() {
		final int size = 99;
		LinkedQueue x = new LinkedQueue();
		final int element = 5;
		final int element2 = 7;
		x.enqueue(element2);
		for (int i = 1; i < size; i++) {
		x.enqueue(element);

		}
		assertEquals(x.dequeue(), element2);
	}
	/**
	 *test size of queue empty one.
	 */
	@Test
	public void testSizeEmpty() {

		LinkedQueue x = new LinkedQueue();
		final int element = 5;
		final int element2 = 7;

		x.enqueue(element2);
		x.enqueue(element);
		x.dequeue();
		x.dequeue();
		assertEquals(x.size(), 0);

	}
	/**
	 *test size of queue .
	 */
	@Test
	public void testsize() {

		LinkedQueue x = new LinkedQueue();
		final int element = 5;

		final int limit = 9;
		for (int i = 0; i < limit; i++) {
		x.enqueue(element);

		}
		assertEquals(x.size(), limit);
	}
	/**
	 *test empty false .
	 */
	@Test
	public void testEmpty() {

		LinkedQueue x = new LinkedQueue();
		final int element = 5;

		final int limit = 9;
		for (int i = 0; i < limit; i++) {
		x.enqueue(element);

		}
		assertFalse(x.isEmpty());
	}
}

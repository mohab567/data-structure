package eg.edu.alexu.csd.datastructure.linkedList.cs80;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
/**
 * @author DELL
 *@Test
 */

public class Stest {
	/**
	 * data for testing.
	 */
final int x1 = -2,
x2 = 13, x3 = 68, x4 = -6, index = 4, index1 = 10, index2 = 7;
	/**
	 *
	 */
	@Test
	public void getFirst() {
		FSLList x = new FSLList();

		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		x.add(0);
		assertEquals(x1, x.get(0));
	}
	/**
	 */
	@Test
	public void getMid() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		x.add(0);
		assertEquals(x3, x.get(2));
	}
	/**
	 */
	@Test
	public void getLast() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		x.add(0);
		assertEquals(0, x.get(index));
	}
	/**
	 */
	@Test(expected = RuntimeException.class)
	public void getWrongIndex() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		x.add(0);
		x.get(index1);
	}
	/**
	 */
	@Test
	public void addWithIndex() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(1, index2);
		x.add(0);
		assertEquals(index2, x.get(1));
	}
	/**
	 */
	@Test
	public void notContain() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(-index2);
		x.add(0);
		assertFalse(x.contains(1));

	}
	/**
	 */
	@Test
	public void contain() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		assertTrue(x.contains(x1));
	}
	/**
	 */
	@Test
	public void isEmpty() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(-x4);
		x.add(0);
		x.clear();
		assertEquals(0, x.size());
	}
/**
 */
	@Test
	public void setNewVal() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(-x4);
		x.add(0);
		x.set(0, index1);
		assertEquals(index1, x.get(0));
	}
	/**
	 */
	@Test
	public void sublist() {
		FSLList x = new FSLList();
		final int y1 = 3, y2 = 5, y3 = 20, y4 = 30, y5 = 11;
		x.add(x1);
		x.add(y1);
		x.add(y2);
		x.add(index2);
		x.add(y3);
		x.add(y4);
		x.add(y5);
		FSLList y = (FSLList) x.sublist(1, index);

		Object[] a = {y.get(0), y.get(1), y.get(2), y.get(y1) };

		Object[] z = {y1, y2, index2, y3 };

		assertArrayEquals(a, z);

	}
	/**
	 */
	@Test(expected = RuntimeException.class)
	public void sublistWrongIndex() {
		FSLList x = new FSLList();
		final int y1 = 3, y2 = 5, y3 = 20, y4 = 30, y5 = 11;
		x.add(x1);
		x.add(y1);
		x.add(y2);
		x.add(index2);
		x.add(y3);
		x.add(y4);
		x.add(y5);
		x.sublist(1, y5);
	}
	/**
	 */
	@Test
	public void remove1() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4 - 1);
		x.add(0);
		x.remove(1);
		assertEquals(index, x.size());

	}
	/**
	 */
	@Test
	public void remove2() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4 - 1);
		x.add(0);
		x.remove(1);
		assertEquals(x3, x.get(1));
	}
	/**
	 */
	@Test(expected = RuntimeException.class)
	public void removeWronIndex() {
		FSLList x = new FSLList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4 - 1);
		x.add(0);
		x.remove(index1);
	}

}

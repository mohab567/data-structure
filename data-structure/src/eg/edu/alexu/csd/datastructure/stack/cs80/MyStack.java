package eg.edu.alexu.csd.datastructure.stack.cs80;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 * @author DELL
 *
 */
public class MyStack implements IStack {
	/**
	 */
	int size = 0;
	/**
	 */
	Node end = new Node(null, null);
	/**
	 */
	Node top = new Node(null, end);
	/**
	 * @author DELL
	 *
	 */
	class Node {
		/**
		 */
		Node next;
		/**
		 */
		Object data;
		/**
		 * constractor.
		 * @param o data
		 * @param link next
		 */
		Node(final Object o, final Node link) {
			next = link;
			data = o;
		}

	}
	@Override
public void add(final int index, final Object element) {
		if (index > size || index < 0) {
			throw new RuntimeException();
		} else {
			Node p = top;
			for (int i = 0; i < size - index; i++) {
				p = p.next;
			}
			Node n = new Node(element, p.next);
			p.next = n;
			size++;
		}

	}
@Override
	public Object pop() {
		if (size == 0) {
			throw new RuntimeException();
		}
		Node p = top.next;
		top.next = top.next.next;
		size--;
		return p.data;
	}
	@Override
	public Object peek() {
		if (size == 0) {
			throw new RuntimeException();
		}
		return top.next.data;
	}
	@Override
	public void push(final Object element) {
		top.next = new Node(element, top.next);
		size++;
	}
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	@Override
	public int size() {
		return size;
	}

}

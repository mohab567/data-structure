package eg.edu.alexu.csd.datastructure.linkedList.cs80;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 * @author DELL
 *
 */
public class DList implements ILinkedList {
	/**
	 */
	Node header;
	/**
	 */
	Node trailer;
	/**
	 */
	int size;
	/**
	 * contractor.
	 */
	public DList() {
		trailer = new Node(0, null, null);
		header = new Node(0, trailer, null);

		trailer.prev = header;

		size = 0;
	}
	/**
	 * @author DELL
	 *
	 */
	public class Node {
		/**
		 */
		Object element;
		/**
		 */
		Node next;
		/**
		 */
		Node prev;
/**
 * constractor.
 * @param s data
 * @param n next
 * @param p prev
 */
		public Node(final Object s, final Node n, final Node p) {
			element = s;
			next = n;
			prev = p;
		}
	}

	@Override
	public void add(final int index, final Object element) {

		Node p = header;
		if (index < 0) {
			throw new RuntimeException();
		}
		for (int i = 0; i < index; i++) {

			p = p.next;
			if (p.next == null) {
				throw new RuntimeException();
			}
		}

		Node v = new Node(element, p.next, p);

		p.next.prev = v;

		p.next = v;
		size++;
	}
	@Override
	public void add(final Object element) {
		Node p = new Node(element, trailer, trailer.prev);
		trailer.prev.next = p;
		trailer.prev = p;
		size++;
	}
	@Override
	public Object get(final int index) {
		Node p = header;
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		for (int i = 0; i <= index; i++) {

			p = p.next;
		}
		return p.element;
	}
	@Override
	public void set(final int index, final Object element) {
		Node p = header;

		for (int i = 0; i <= index; i++) {

			p = p.next;
			if (p.next == null) {
				throw new RuntimeException();
			}
		}
		p.element = element;

	}
	@Override
	public void clear() {
		header = new Node(null, trailer, null);

		trailer = new Node(null, null, header);

		size = 0;

	}
	@Override
	public boolean isEmpty() {
		return !(size != 0);
	}
	@Override
	public void remove(final int index) {
		Node p = header;
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		if (isEmpty()) {
			throw new RuntimeException();
		}
		for (int i = 0; i < index; i++) {

			p = p.next;
		}
		p.next.next.prev = p;
		p.next = p.next.next;
		size--;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		DList v = new DList();
		int m = toIndex - fromIndex + 1;
		if (toIndex < fromIndex || fromIndex < 0 || toIndex < 0) {
			throw new RuntimeException();
		}
		Node p = header;

		for (int i = 0; i < fromIndex; i++) {

			p = p.next;
			if (p.next == null) {
				throw new RuntimeException();
			}
		}

		for (int i = 0; i < m; i++) {

			p = p.next;
			v.add(p.element);
			if (p.next == null) {
				throw new RuntimeException();
			}
		}
		return v;
	}
	@Override
	public boolean contains(final Object o) {
		Node p = header;

		for (int i = 0; i < size; i++) {

			p = p.next;
			if (p.next == null) {
				throw new RuntimeException();
			}
			if (p.element.equals(o)) {
				return true;
			}

		}
		return false;
	}

}

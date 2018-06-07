package eg.edu.alexu.csd.datastructure.linkedList.cs80;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 * @author DELL
 *
 */
public class FSLList implements ILinkedList {
/**
 * @author DELL
 *
 */
	class Node {
		/**
		 */
		public Object data;
		/**
		 */
		public Node link;
		/**
		 * constractor.
		 * @param o data
		 * @param n next
		 */
		 Node(final Object o, final Node n) {
			data = o;
			link = n;
		}
	}
/**
 */
	public Node head = new Node(null, null);
	/**
	 */
	public Node tail = new Node(null, null);
	/**
	 */
	public int size;
/**
 * contractor.
 */
	public FSLList() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public void add(final int index, final Object element) {
		Node node = new Node(element, null);
		Node traverse = head;

		if (index > size || index < 0) {
			throw new RuntimeException();
		}

		if (index == 0) {
			node.link = head;
			head = node;
		}
		if (isEmpty()) {
			tail = node;
		}
		for (int i = 1; i <= size && index > 0; i++) {
			if (i == index) {
				Node temp = traverse.link;
				traverse.link = node;
				node.link = temp;
				break;
			}
			traverse = traverse.link;
		}
		size++;
	}
	@Override
	public void add(final Object element) {
		add(size, element);

	}
	@Override
	public Object get(final int index) {

		if (index >= size || index < 0) {
			throw new RuntimeException();
		}
		if (isEmpty()) {
			throw new RuntimeException();
		}

		Node traverse = head;

		for (int i = 0; i < size; i++) {
			if (i == index) {

				return traverse.data;

			} else {
				traverse = traverse.link;
			}
		}
		return traverse.data;

	}
	@Override
	public void set(final int index, final Object element) {
		int index1 = index;
		if (index1 >= size || index1 < 0) {
			throw new RuntimeException();
		}
		if (isEmpty()) {
			throw new RuntimeException();
		}

		Node traverse = head;

		for (int i = 0; i < size; i++) {
			if (i == index1) {
				traverse.data = element;
				break;
			}
			traverse = traverse.link;
		}
	}
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public void remove(final int index) {
		int index1 = index;

		if (index1 >= size || index1 < 0) {
			throw new RuntimeException();
		}
		if (isEmpty()) {
			throw new RuntimeException();
		}
		if (index1 == 0 || index1 + 1 == size) {
			if (index1 == 0) {
				head = head.link;
				size--;

			}

			if (index1 + 1 == size) {
				Node s = head;
				Node t = head;
				while (s != tail) {
					t = s;
					s = s.link;
				}
				tail = t;
				tail.link = null;
				size--;

			}
		} else {
			Node traverse = head;

			for (int i = 1; i < size - 1; i++) {
				if (i == index1) {
					Node temp = traverse.link;
					temp = temp.link;
					traverse.link = temp;
					break;
				}
				traverse = traverse.link;
			}
			size--;
		}
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public FSLList sublist(final int fromIndex, final int toIndex) {
		FSLList v = new FSLList();

		if (toIndex < fromIndex
				|| fromIndex < 0
				|| toIndex < 0
				|| toIndex >= size) {
			throw new RuntimeException();
		}

		Node p = head;

		for (int i = 0; i < fromIndex; i++) {

			p = p.link;

		}

		for (int i = fromIndex; i <= toIndex; i++) {

			v.add(p.data);
			p = p.link;

		}

		return v;
	}
	@Override
	public boolean contains(final Object o) {
		Node traverse = head;
		boolean flag = false;

		for (int i = 1; i <= size; i++) {

			if (traverse.data.equals(o)) {
				flag = true;
				break;
			}
			traverse = traverse.link;
		}

		return flag;
	}

}

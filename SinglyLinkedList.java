package Lap6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		return head.getData();
	}

	public E last() {
		if (head == null)
			return null;
		Node<E> lastNode = head;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		return lastNode.getData();
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e, head);
		head = newNode;
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, null);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node<E> lastNode = head;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		lastNode.setNext(newNode);
		size++;
	}

	public E removeFirst() {
		E firstNode = first();
		if (head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		}
		head = head.getNext();
		size--;
		return firstNode;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		E lastN = last();
		if (head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		}
		size--;
		if (head.getNext() == null) {
			head = null;
			return last();
		}
		Node<E> currNode = head;
		Node<E> lastNode = head.getNext();
		while (lastNode.getNext() != null) {
			currNode = currNode.getNext();
			lastNode = lastNode.getNext();
		}
		currNode.setNext(null);
		return lastN;
	}

	public String toString() {
		String result = "";
		Node<E> currNode = head;
		while (currNode != null) {
			result = result + currNode.getData() + " ";
			currNode = currNode.getNext();
		}
		return result;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		System.out.println(ll);
		System.out.println(ll.first());
		System.out.println(ll.last());
		ll.removeFirst();
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
	}
}

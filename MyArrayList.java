package Lap6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		super();
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		super();
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		if (size >= elements.length) {
			E[] newArr = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < size; i++) {
				newArr[i] = elements[i];
			}
			elements = newArr;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i > size)
			throw new IndexOutOfBoundsException();
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		elements[i] = e;
		return elements[i];
	}

	public boolean add(E e) {
		growSize();
		elements[size] = e;
		size++;
		return false;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		growSize();
		size++;
		for (int j = size - 1; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		E result = elements[i];
		for (int j = i; j < size; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return result;
	}

	public void clear() {
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size; i > -1; i--) {
			if (elements[i] == o) {
				return i;
			}
		}
		return -1;
	}

	public E[] toArray() {
		E[] array = Arrays.copyOf(elements, size);
		Arrays.sort(array);
		return array;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> arr = new MyArrayList<>();
		for (int i = 0; i < size; i++) {
			arr.add(elements[i]);
		}
		return arr;
	}
	
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o)
				return true;
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(E e) {
		if (!contains(e))
			throw new IndexOutOfBoundsException();
		for (int i = indexOf(e) ; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		size--;
		return false;
	}

	public void sort(Comparator<E> c) {
		if (size > 0) {
			Arrays.sort(elements, 0, size, c);
		}
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result = result + elements[i] + " ";
		}
		return result;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> arr1 = new MyArrayList<>();
		System.out.println(arr1.size);
		arr1.add(4);
		arr1.add(5);
		arr1.add(6);
		arr1.add(1);
		arr1.add(2);
		arr1.add(4);
		arr1.add(7);
		arr1.add(8);
		arr1.add(9);
		arr1.add(10);
		arr1.add(11);
		arr1.add(0, 7);
		System.out.println(arr1.get(3));
		arr1.set(4, 1);
		System.out.println(arr1.size);
		System.out.println(arr1.isEmpty());
		System.out.println(arr1);
		arr1.remove(3);
		System.out.println(arr1);
		System.out.println(arr1.size);
		System.out.println(arr1);
//		arr1.clear();
		System.out.println(arr1);
		System.out.println(arr1.clone());
		arr1.sort(null);
		System.out.println(arr1);
	}
}

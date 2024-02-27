package com.sunil.kumar.kandakatla.datastructure.linkedlists;

public class SinglyLinkedList<E> {

	int size = 0;

	Node<E> first;

	Node<E> last;

	private static class Node<E> {
		E value;
		Node<E> next;

		Node(E value) {
			this.value = value;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + (next != null ? next.value : "") + "]";
		}
	}

	public void append(E value) {
		Node<E> newNode = new Node<>(value);

		if (this.first == null) {
			this.first = this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		this.size++;
	}

	public void prepend(E value) {
		Node<E> newNode = new Node<>(value);

		if (this.first == null) {
			this.first = this.last = newNode;
		} else {
			newNode.next = this.first;
			this.first = newNode;
		}
		this.size++;
	}

	public void insert(int index, E value) {
		Node<E> newNode = new Node<>(value);

		int size = this.size();

		if (index < 0 || index > size) {
			return;
		}

		if (index == 0) {
			if (this.first == null) {
				this.first = this.last = newNode;
			} else {
				newNode.next = this.first;
				this.first = newNode;
			}
		} else {
			Node<E> currentNode = find(index);

			newNode.next = currentNode.next;
			currentNode.next = newNode;

			Node<E> last = newNode;
			while (last.next != null) {
				last = last.next;
			}
			this.last = last;
		}
		this.size++;
	}

	public void delete(int index) {
		int size = this.size();

		if (size == 0 || index < 0 || index > size) {
			return;
		}

		if (index == 0) {
			this.first = this.first.next;
		} else {
			Node<E> currentNode = find(index);

			if (currentNode.next != null) {
				currentNode.next = currentNode.next.next;
			}

			Node<E> last = currentNode;
			while (last != null) {
				last = last.next;
			}

			this.last = last;
		}
		this.size--;
	}

	public void read() {
		Node<E> currentNode = this.first;
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	public int size() {
		return this.size;
	}

	public Node<E> find(int index) {
		Node<E> currentNode = this.first;
		while (--index > 0) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.append(4);
		singlyLinkedList.append(5);
		singlyLinkedList.prepend(3);
		singlyLinkedList.read();

		singlyLinkedList.insert(3, 7);
		singlyLinkedList.append(8);
		singlyLinkedList.read();

		singlyLinkedList.delete(3);
		singlyLinkedList.read();
	}

}

package com.sunil.kumar.kandakatla.linkedlists;

public class DoublyLinkedList<E> {

	int size = 0;

	Node<E> first;

	Node<E> last;

	private static class Node<E> {
		E value;
		Node<E> prev;
		Node<E> next;

		Node(E value) {
			this.value = value;
			this.prev = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [" + "prev=" + (prev != null ? prev.value : " ") + ", value=" + value + ", next="
					+ (next != null ? next.value : "") + "]";
		}
	}

	public void append(E value) {
		Node<E> newNode = new Node<>(value);

		if (this.size == 0) {
			this.first = this.last = newNode;
		} else {
			newNode.prev = this.last;
			this.last.next = newNode;
			this.last = newNode;
		}

		this.size++;
	}

	public void prepend(E value) {
		Node<E> newNode = new Node<>(value);
		if (this.size == 0) {
			this.first = this.last = newNode;
		} else {
			newNode.next = this.first;
			this.first.prev = newNode;
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
			if (this.size == 0) {
				this.first = this.last = newNode;
			} else {
				newNode.next = this.first;
				this.first.prev = newNode;
				this.first = newNode;
			}
		} else {
			Node<E> currentNode = find(index);
			Node<E> currentNodeNext = currentNode.next;

			if (currentNodeNext != null) {
				currentNode.next = newNode;
				newNode.prev = currentNode;
				newNode.next = currentNodeNext;
				currentNodeNext.prev = newNode;
			} else {
				newNode.prev = currentNode;
				currentNode.next = newNode;
				currentNode = newNode;
			}

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
			this.first.prev = null;
		} else {
			Node<E> currentNode = find(index);

			if (currentNode.next != null) {
				currentNode.next = currentNode.next.next;
				currentNode.next.prev = currentNode;
			} else {
				currentNode = currentNode.prev;
				currentNode.next = null;
			}

			Node<E> last = currentNode;
			while (last.next != null) {
				last = last.next;
			}

			this.last = last;
		}
		this.size--;
	
	}

	public void read() {
		Node<E> currentNode = this.first;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	public void reverse() {
		System.out.println("reverse");
		Node<E> currentNode = this.last;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.prev;
		}
		System.out.println();
	}

	public int size() {
		return size;
	}

	public Node<E> find(int index) {
		Node<E> currentNode = this.first;
		while (--index > 0) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		doublyLinkedList.append(4);
		doublyLinkedList.append(5);
		doublyLinkedList.prepend(2);
//		doublyLinkedList.read();

		doublyLinkedList.insert(1, 3);
//		doublyLinkedList.read();

		doublyLinkedList.insert(4, 6);
		doublyLinkedList.append(7);
		doublyLinkedList.read();

		doublyLinkedList.delete(1);
		doublyLinkedList.delete(3);
		doublyLinkedList.read();
		
		doublyLinkedList.reverse();
	}

}

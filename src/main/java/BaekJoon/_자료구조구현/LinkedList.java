package BaekJoon._자료구조구현;

public class LinkedList<T> {

	class Node<T> {
		private T data;
		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<T> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	public void add(T a) {
		if (head == null) {
			head = new Node<>(a, null);
		} else {
			Node lastNode = searchLastNode(head);
			lastNode.next = new Node<>(a, null);
		}

		plusSize();
	}

	// 중간에 삽입

	public void add(int idx, T a) {
		if (head == null && idx == 0) {
			head = new Node<>(a, null);
			return;
		}

		Node<T> newNode = new Node<>(a, null);

		if (idx == 0) {
			Node<T> temporary = head;
			head = newNode;
			head.next = temporary;
		} else {
			if (idx > size) {
				throw new RuntimeException("삽입하기 위한 인덱스가 용량보다 큽니다.");
			}

			Node cur = head;
			int count = 0;
			while (true) {

				if (count + 1 == idx) {
					break;
				}

				cur = cur.next;
				count++;
			}

			Node<T> front = cur;
			newNode.next = front.next;
			front.next = newNode;
		}

		plusSize();
	}
	public void delete(int idx) {

		if (idx + 1 > size) {
			throw new RuntimeException("해당 인덱스는 존재하지 않습니다.");
		}

		if (idx == 0) {
			head = this.head.next;
		} else {
			int count = 0;
			Node<T> cur = head;
			while (true) {
				if (count + 1 == idx) {
					break;
				}

				count++;
				cur = cur.next;
			}

			cur.next = cur.next.next;
		}

		minusSize();
	}

	public void delete(Node<T> node) {
		Node foundNode = searchLastNode(node);
		if (foundNode == null) {
			throw new RuntimeException("존재하지 않는 데이터입니다.");
		}

		Node<T> cur = head;

		if (head.next != null) {
			head = head.next;
		}

		while (true) {
			if (cur.next.data == node.data) {
				break;
			}

			cur = cur.next;
		}

		cur.next = cur.next.next;
		minusSize();
	}

	private void plusSize() {
		this.size++;
	}

	private void minusSize() {
		this.size--;
	}

	private Node searchLastNode(Node node) {
		if (node.next == null) {
			return node;
		}

		return searchLastNode(node.next);
	}

	public void printAll() {
		Node<T> cur = head;

		while (true) {
			if (cur == null) {
				break;
			}

			System.out.print(cur.data + " ");
			cur = cur.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList();

		list.add(1);
		list.add(1,9);
		list.add(2);
		list.add(3,9);
		list.add(3);
		list.add(4);
		list.add(4,100);
		list.add(5,1);
		list.printAll();

		System.out.println("지우기");
		list.delete(0);
		list.printAll();
		list.delete(0);
		list.printAll();
		list.delete(0);
		list.printAll();
		list.delete(0);
		list.printAll();
		list.delete(0);
		list.printAll();
		list.delete(0);
		list.printAll();
	}
}

package BaekJoon._자료구조구현.try1.queue;

import java.util.Scanner;

public class QueueImpl {
	public static final int NOT_PRINT = 10_000;

	public static void main(String[] args) {
		CustomQueue<Integer> q = new CustomQueue<>();

		Scanner reader = new Scanner(System.in);
		int cmd = parse(reader.nextLine());
		StringBuilder answer = new StringBuilder();

		while (cmd-- > 0) {

			String input[] = reader.nextLine().split(" ");
			int result = -1;
			switch (input[0]) {
				case "push":
					q.push(parse(input[1]));
					result = NOT_PRINT;
					break;
				case "pop":
					if (!q.isEmpty()) {
						result = q.pop();
					}
					break;
				case "size":
					result = q.getSize();
					break;
				case "empty":
					result = q.isEmpty() ? 1 : 0;
					break;
				case "front":
					if (!q.isEmpty()) {
						result = q.front();
					}
					break;
				case "back":
					if (!q.isEmpty()) {
						result = q.back();
					}
					break;
				default:
					throw new RuntimeException("INVALID COMMAND");
			}

			if (result != NOT_PRINT) {
				answer.append(result).append("\n");
			}
		}

		System.out.println(answer);
	}

	public static int parse(String s) {
		return Integer.parseInt(s);
	}
}

class Node<T> {
	private T data;
	private Node next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public void link(Node<T> next) {
		this.next = next;
	}

	public boolean isNotExistNext() {
		return this.next == null;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public T getData() {
		return this.data;
	}
}

class CustomQueue<T> {
	private int size;
	private Node head;
	private Node tail;

	public CustomQueue() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void push(T data) {
		Node<T> newNode = new Node(data);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.link(newNode);
			tail = newNode;
		}

		this.size++;
	}
	// 이것때매 시간초과 나는듯 tail로 연결해야 해!
	private Node<T> searchLastNode(Node<T> cur) {
		if (cur.isNotExistNext()) {
			return cur;
		}

		return searchLastNode(cur.getNext());
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public T front() {
		return (T)head.getData();
	}

	public T back() {
		return (T)tail.getData();
	}

	public T pop() {
		T popedData = (T)head.getData();
		head = head.getNext();
		this.size--;

		return popedData;
	}
}

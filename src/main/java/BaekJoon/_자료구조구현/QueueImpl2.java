package BaekJoon._자료구조구현;

import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * note: 두개의 스택으로 큐 구현하기
 */
public class QueueImpl2 {
	public static void main(String[] args) {
		CustomQueue2<Integer> q = new CustomQueue2<>();

		IntStream.rangeClosed(1, 10).forEach(q::enqueue);
		Stream.generate(q::dequeue).limit(3).forEach(v -> q.print());
	}
}

class CustomQueue2<T> {
	private Stack<T> main;
	private Stack<T> sub;

	public CustomQueue2() {
		this.main = new Stack<T>();
		this.sub = new Stack<T>();
	}

	public void enqueue(T data) {
		main.push(data);
	}

	public T dequeue() {
		if (main.isEmpty()) {
			throw new RuntimeException("NOT EXIST DATA..");
		}

		moveMainToSub();
		T popedData = sub.pop();
		moveSubToMain();

		return popedData;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		while (!main.isEmpty()) {
			sb.append(main.peek()).append(" ");
			sub.push(main.pop());
		}

		moveSubToMain();
		System.out.println(sb);
	}

	private void moveMainToSub() {
		while (!main.isEmpty()) {
			sub.push(main.pop());
		}
	}

	private void moveSubToMain() {
		while (!sub.isEmpty()) {
			main.push(sub.pop());
		}
	}
}



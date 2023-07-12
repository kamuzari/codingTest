package BaekJoon._자료구조구현;

import java.util.Scanner;

public class StackImpl {

	public static final int NOT_PRINT = 10_000;

	public static void main(String[] args) {
		CustomStack<Integer> customStack = new CustomStack<>();

		Scanner reader = new Scanner(System.in);
		int cmd = parse(reader.nextLine());
		StringBuilder answer = new StringBuilder();

		while (cmd-- > 0) {

			String input[] = reader.nextLine().split(" ");
			int result = -1;
			switch (input[0]) {
				case "push":
					customStack.push(parse(input[1]));
					result = NOT_PRINT;
					break;
				case "pop":
					if (!customStack.isEmpty()) {
						result = customStack.pop();
					}
					break;
				case "size":
					result = customStack.getSize();
					break;
				case "empty":
					result = customStack.isEmpty() ? 1 : 0;
					break;
				case "top":
					if (!customStack.isEmpty()) {
						result = customStack.peek();
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

class CustomStack<T> {
	private static final int INIT_SIZE = 10_000;
	private Object datas[];
	private int pointer;

	public CustomStack() {
		datas = new Object[INIT_SIZE];
		pointer = 0;
	}

	public void push(T data) {
		datas[pointer++] = data;
	}

	public T pop() {
		return (T) datas[--pointer];
	}

	public T peek() {
		return (T)datas[pointer - 1];
	}

	public int getSize() {
		return pointer;
	}

	public boolean isEmpty() {
		return this.pointer == 0;
	}

}
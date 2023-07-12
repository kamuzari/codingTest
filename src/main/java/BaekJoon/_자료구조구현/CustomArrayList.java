package BaekJoon._자료구조구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CustomArrayList<T> {
	private static Console console = new Console();
	private static final int INIT_CAPACITY = 55;
	private Object datas[];
	private int pointer;

	public CustomArrayList() {
		datas = new Object[INIT_CAPACITY];
		pointer = 0;
	}

	// 가장 가까운 배열에 넣기
	public void add(T data) {
		if (pointer >= datas.length) {
			expand();
		}

		datas[pointer++] = data;
	}

	public void add(int index, T data) {
		if (pointer < index) {
			console.println("현재 사이즈 : " + pointer + " 삽입 인덱스 : " + index);
			return;
		}

		if (pointer >= datas.length) {
			expand();
		}

		for (int i = pointer; i > index; i--) {
			datas[i] = datas[i - 1];
		}

		datas[index] = data;
		pointer++;
	}

	public void delete() {
		datas[--pointer] = null;
	}

	public void delete(int index) {
		if (pointer <= index) {
			console.println("엑세스가 불가한 인덱스 입니다.");
			return;
		}

		if (datas[index] == null) {
			return;
		}

		for (int i = index; i < pointer; i++) {
			datas[i] = datas[i + 1];
		}

		pointer--;
	}

	private void expand() {
		this.datas = Arrays.copyOf(this.datas, this.datas.length * 2);
	}

	public void printAll() {
		console.println("===================");
		for (int i = 0; i < pointer; i++) {
			console.print(datas[i] + " ");
		}
		console.print("\n");
		console.println("===================");
	}

	public static void main(String[] args) {
		CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

		IntStream.rangeClosed(1, 10).boxed().forEach(customArrayList::add);
		customArrayList.printAll();

		customArrayList.add(10,11);

		IntStream.rangeClosed(1, 10).forEach(v -> {
			System.out.println("삭제연산: " + v);
			customArrayList.delete(5);
			customArrayList.printAll();
		});
	}

}

class Console {
	public void print(String s) {
		System.out.print(s);
	}

	public void println(String s) {
		System.out.println(s);
	}
}

package BaekJoon.tony.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Harbor {

	/**
	 * 반례
	 * 1)
	 * 3
	 * 10 6 5
	 * 11
	 * 6 8 9 6 8 6 9 6 8 6 9
	 * 정답:6 오답:8
	 * <p>
	 * 2)
	 * 4
	 * 1 2 3 4
	 * 8
	 * 1 1 2 2 3 3 4 4
	 * <p>
	 * 정답: 2, 오답: 4
	 */
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	public static void main(String[] args) throws java.lang.Exception {
		st = token();
		int n = parse(next());
		List<Integer> crane = new ArrayList<>();

		st = token();
		for (int i = 0; i < n; i++) {
			crane.add(parse(next()));
		}

		st = token();
		int m = parse(next());
		List<Integer> box = new ArrayList<>();
		// 우선순위큐로 소비하면 뒤에 크레인을 사용하여 옮김수 있음에도 불구하고 못옴긴다.
		// 최대한 가용가능한 크레인으로 다 옴기는 것이 최선이다.
		st = token();
		for (int i = 0; i < m; i++) {
			box.add(parse(next()));
		}

		Collections.sort(box, Collections.reverseOrder());
		Collections.sort(crane, Collections.reverseOrder());
		if (crane.get(0) < box.get(0)) { // 크레인이 못들면 영원히 못옮김
			print(String.valueOf(-1));
			return;
		}

		int answer = 0;
		while (box.size() != 0) {
			int boxIdx = 0;
			for (int j = 0; j < n; j++) {
				if (!box.isEmpty() && box.get(boxIdx) <= crane.get(j)) {
					box.remove(boxIdx);
				} else {
					boxIdx++;
					j--;
				}
				if (boxIdx >= box.size()) {
					break;
				}
				if (box.size() == 0)
					break;
			}

			answer++;
		}

		print(String.valueOf(answer));
	}

	static void print(String s) {
		System.out.println(s);
	}

	static StringTokenizer token() {
		return new StringTokenizer(sc.nextLine());
	}

	static String next() {
		return st.nextToken();
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}
}

package BaekJoon._자료구조구현.basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LIS {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		List<Integer> list = new ArrayList<>();
		list.add(0);

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {

			int val = Integer.parseInt(st.nextToken());

			int tail = list.size() - 1;
			if (val > list.get(tail)) {
				list.add(val);
			} else {
				int index = getInsertPosition(list, val, tail);
				list.add(index, val);
			}
		}

		System.out.println(list.size() - 1);

	}

	private static int getInsertPosition(List<Integer> list, int val, int tail) {
		int s = 0;
		int e = tail;

		while (s < e) {
			int mid = (s + e) >> 1;

			if (list.get(mid) >= val) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return e;
	}
}

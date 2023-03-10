package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DoublePriorityQueue {
	static final int REMOVE_MIN_VALUE = -1;
	static final int REMOVE_MAX_VALUE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder answer = new StringBuilder();
		int repeat = Integer.parseInt(reader.readLine());

		for (int test = 0; test < repeat; test++) {
			int n = Integer.parseInt(reader.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				String cmd = st.nextToken();
				int val = Integer.parseInt(st.nextToken());

				if (cmd.equals("I")) {
					map.put(val, map.getOrDefault(val, 0) + 1);
				} else {
					if (map.isEmpty()) {
						continue;
					}

					if (val == REMOVE_MIN_VALUE) {
						Integer minVal = map.lastKey();

						if (map.get(minVal) == 1) {
							map.remove(minVal);
						} else {
							map.put(minVal, map.get(minVal) - 1);
						}

					} else if (val == REMOVE_MAX_VALUE) {
						Integer maxVal = map.firstKey();

						if (map.get(maxVal) == 1) {
							map.remove(maxVal);
						} else {
							map.put(maxVal, map.get(maxVal) - 1);
						}
					}
				}
			}

			if (map.isEmpty()) {
				answer.append("EMPTY\n");
			} else {
				answer.append(map.firstKey() + " " + map.lastKey()+"\n");
			}
		}

		System.out.println(answer);
	}
}

package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TypeOfSales {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] days = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		List<Integer> saleKinds = new LinkedList<>();
		Map<Integer, Integer> kinds = new HashMap<>();

		while (end < n) {
			if (end - start < k) {
				int key = days[end];
				kinds.put(key, kinds.getOrDefault(key, 0) + 1);
				end++;
			} else {
				int key = days[start];
				if (kinds.get(key) == 1) {
					kinds.remove(key);
				} else {
					kinds.put(key, kinds.get(key) - 1);
				}
				start++;
			}

			if (end - start == k) {
				saleKinds.add(kinds.size());
			}
		}

		String answer = saleKinds.stream().map(String::valueOf)
			.collect(Collectors.joining(" "));

		System.out.println(answer);
	}
}

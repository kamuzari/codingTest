package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class KthLargestNumber {
	private static Set<Integer> pickedNumbers = new TreeSet<>((o1, o2) -> o2 - o1);
	private static int n;
	private static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		pickCard(0, 0, 0);
		List<Integer> candidates = pickedNumbers.stream().collect(Collectors.toList());
		if (candidates.size() < k) {
			System.out.println(-1);
		} else {
			System.out.println(candidates.get(k-1));
		}
	}

	private static void pickCard(int cnt, int idx, int sum) {
		if (cnt == 3) {
			pickedNumbers.add(sum);
			return;
		}

		for (int i = idx; i < n; i++) {
			pickCard(cnt + 1, i + 1, sum + numbers[i]);
		}
	}

}

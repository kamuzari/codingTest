package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DecresingNumber {

	private static Set<Long> answer;
	private static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		System.out.println(solution(n));
	}

	public static long solution(int n) {
		answer = new HashSet<>();
		numbers = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

		create(0, 0);
		List<Long> results = answer.stream()
			.sorted()
			.collect(Collectors.toList());

		if (results.size() < n) {
			return -1;
		}

		return results.get(n-1);
	}

	public static void create(int cnt, long makingNumber) {
		answer.add(makingNumber);

		if (cnt >= 10) {
			return;
		}

		create(cnt + 1, makingNumber * 10 + numbers[cnt]);
		create(cnt + 1, makingNumber);
	}
}

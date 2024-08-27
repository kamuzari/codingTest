package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BlackFriday {
	/**
	 * 두개를 콤비네이션으로 뽑으면 일단 같은 숫자 인덱스는 고르지 않는다.
	 * 여기서 나머지 한개를 뽑기만 하면 되는데 같은 숫자를 고르면
	 * 숫자: 카운팅 맵으로 2개 조합에서 쓰인거 빼주고 마지막 하나주는것도 빼보자
	 */
	static int n, c;
	static int[] arr;
	static Map<Integer, Integer> countings;
	static boolean isPossible = false;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		countings = Arrays.stream(arr)
			.boxed()
			.collect(Collectors.toMap(
				k -> k,
				v -> 1,
				Integer::sum
			));
		if (countings.containsKey(c)) {
			System.out.println(1);
			return;
		}
		combinate(0, 0, 0);
		int answer = isPossible ? 1 : 0;
		System.out.println(answer);
	}
	
	private static void combinate(int cnt, int idx, int summaryOfTwo) {
		if (isPossible) {
			return;
		}
		if (summaryOfTwo == c) {
			isPossible = true;
			return;
		}
		if (cnt == 2) {

			int need = c - summaryOfTwo;
			if (countings.containsKey(need)) {
				if (countings.get(need) != 0) {
					isPossible = true;
				}
			}

			return;
		}

		for (int i = idx; i < n; i++) {
			countings.put(arr[i], countings.get(arr[i]) - 1);
			if (c < summaryOfTwo + arr[i]) {
				continue;
			}
			combinate(cnt + 1, i + 1, summaryOfTwo + arr[i]);
			countings.put(arr[i], countings.get(arr[i]) + 1);
		}
	}
}

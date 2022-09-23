package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TemporaryChief_BOJ1268 {

	/**
	 * hint : 문제를 잘 읽어야 함
	 *  이전 코드는 자신과 같은 반인 친구를 count 만했다.
	 *  하지만 문제에서 요구하는 것은 !!
	 *    😇 **자신과 같은 반이었던 친구 수가 최대 인것을 고르는 것이다**
	 *   출처 : https://www.acmicpc.net/board/view/29802
	 */
	private static final int LIMIT_GRADE = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		Map<Integer, Integer> candidates = new HashMap<>();

		int[][] table = new int[n][LIMIT_GRADE];

		for (int i = 0; i < n; i++) {
			table[i] = Arrays.stream(
					reader.readLine().split(" ")
				).mapToInt(Integer::parseInt)
				.toArray();
		}

		for (int person = 0; person < n; person++) {
			int sameClass = countSameClassPerson(n, table, person);
			candidates.put(person + 1, sameClass);
		}

		Integer answer = candidates.keySet().stream().sorted((a, b) -> {
			if (candidates.get(a).equals(candidates.get(b))) {
				return a - b;
			}

			return candidates.get(b) - candidates.get(a);
		}).collect(Collectors.toList()).get(0);

		System.out.println(answer);
	}

	private static int countSameClassPerson(int numberOfPeople, int[][] table, int person) {
		Set<Integer> friends = new HashSet<>();

		for (int grade = 0; grade < 5; grade++) {
			int classRoom = table[person][grade];

			for (int friend = 0; friend < numberOfPeople; friend++) {
				if (friend == person) {
					continue;
				}

				if (classRoom == table[friend][grade]) {
					friends.add(friend);
				}
			}
		}

		return friends.size();
	}
}

/*
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

3
1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
 */

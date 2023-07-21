package BaekJoon._자료구조구현.devideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class makingEnCryption {

	static char[] chs;

	static Set<Character> sets = Set.of('a', 'e', 'i', 'o', 'u');
	static List<String> answers = new ArrayList<>();
	private static int l;
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		chs = new char[c];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < c; i++) {
			chs[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chs);
		// L개를 봅아라 단, 최소 한개의 모음 두개의 자음으로 구성되어야 한다.
		// 순여로 뽑으면 초과, 조합으로 정렬 ㄱ
		combinate(0, 0, new char[l], 0, 0);

		answers.stream().forEach(System.out::println);
	}

	static void combinate(int cnt, int idx, char[] candidates, int 자음, int 모음) {
		if (cnt == l) {

			if (자음 < 2 || 모음 < 1) {
				return;
			}

			StringBuilder result = new StringBuilder();
			for (char candidate : candidates) {
				result.append(candidate);
			}
			answers.add(result.toString());
			return;
		}

		for (int i = idx; i < c; i++) {
			char candidate = chs[i];
			candidates[cnt] = candidate;

			if (sets.contains(candidate)) {
				combinate(cnt + 1, i + 1, candidates, 자음, 모음 + 1);
			} else {
				combinate(cnt + 1, i + 1, candidates, 자음 + 1, 모음);
			}
		}
	}
}

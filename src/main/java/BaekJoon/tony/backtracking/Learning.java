package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Learning {
	// 읽기 가능한 철자들
	static Set<Character> learnings = new HashSet<>();

	// 읽어야할 단어들
	static List<Character> candidates = new ArrayList<>();
	static boolean v[] = new boolean[26];
	static Set<String> words = new HashSet<>();
	static int n, k, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			words.add(reader.readLine());
		}

		for (char i = 'a'; i <= 'z'; i++) {
			candidates.add(i);
		}

		v['a' - 'a'] = true;
		v['c' - 'a'] = true;
		v['i' - 'a'] = true;
		v['n' - 'a'] = true;
		v['t' - 'a'] = true;

		if (k - 5 < 0) {
			System.out.println(0);
		} else {
			pick(0, 0);

			System.out.println(answer);
		}

	}

	static void pick(int cnt, int idx) {
		if (cnt >= k - 5) {
			answer = Math.max(answer, getReadCount());
			return;
		}

		for (int i = idx; i < candidates.size(); i++) {
			Character ch = candidates.get(i);

			if (v[ch - 'a'])
				continue;

			v[ch-'a']=true;
			pick(cnt + 1, i + 1);
			v[ch-'a']=false;
		}
	}

	private static int getReadCount() {
		int result = 0;

		for (String word : words) {
			if (isRead(word)) {
				result++;
			}
		}

		return result;
	}

	static boolean isRead(String word) {

		for (char ch : word.toCharArray()) {
			if (!v[ch - 'a']) {
				return false;
			}
		}

		return true;
	}

}

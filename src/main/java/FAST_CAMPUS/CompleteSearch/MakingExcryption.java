package FAST_CAMPUS.CompleteSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MakingExcryption {

	static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
	static List<String> answers = new ArrayList<>();
	static Stack<Character> result = new Stack<>();
	private static char[] chars;
	private static int c;
	private static int l;

	/**
	 * note:
	 *  - 암호는 l개의 문자로 구성되어 있으며 최소 한개의 모음과 최소 2개이상의 자음으로 구성되어 있다.
	 *  - 정렬된 문자열을 선호한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		chars = new char[c];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < c; i++) {
			chars[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chars);

		combinate(0, 0);

		String answer = answers.stream().collect(Collectors.joining("\n"));

		System.out.println(answer);
	}

	public static void combinate(int cnt, int idx) {
		if (cnt == l) {
			String answer = result.stream().map(String::valueOf)
				.collect(Collectors.joining());

			if (isValid(answer)) {

				answers.add(answer);
			}

			return;
		}

		for (int i = idx; i < c; i++) {
			result.push(chars[i]);
			combinate(cnt + 1, i + 1);
			result.pop();
		}
	}

	private static boolean isValid(String answer) {

		int vowel = 0;
		int consonant = 0;

		for (char ch : answer.toCharArray()) {
			if (vowels.contains(ch)) {
				vowel++;
			} else {
				consonant++;
			}
		}

		return consonant >= 2 && vowel >= 1;
	}
}

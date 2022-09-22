package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSearch {

	private static final int NOT_FIND = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;

		String original = reader.readLine().toLowerCase();
		String keyword = reader.readLine().toLowerCase();

		int isFind = original.indexOf(keyword);
		int keywordLength = keyword.length();

		if (isFind != NOT_FIND) {
			answer++;
		}

		while (isFind != NOT_FIND) {
			isFind = original.indexOf(keyword, isFind + keywordLength);

			if (isFind != NOT_FIND) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}

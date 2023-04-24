package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSequence {
	static int n;
	static int arr[] = {1, 2, 3};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		/**
		 * 1,2,3으로 이루어지는 n 자리 수열을 만들 때, 좋은 수열 중 가장 작은 수를 출력하는 문제
		 * - n자리를 만들 때 2/n까지의 길이를 만들면서 같은 것이 있는지 판별하면 시간초과에 안걸릴까? 라는 의문... 
		 */

		makeSequence(0, "");
	}

	/**
	 *
	 * @param cnt
	 * @param result : int 형으로 *10을해서 1의자리를 더해준다면 overflow가 발생한다. 왜나하면 최대 80자리이기 때문이다!
	 */
	static void makeSequence(int cnt, String result) {
		if (cnt == n) {
			System.out.println(result);
			System.exit(0);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (isBadSequence(result+i)) {
				continue;
			}
			makeSequence(cnt + 1, result+i);
		}
	}

	/**
	 * 인접한 두개의 부분수열이 동일하면 그것을 나쁜 수열이라 인지한다.
	 * @param str
	 * @return
	 */
	static boolean isBadSequence(String str) {
		for (int i = 0; i < str.length()- 1; i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String front = str.substring(i, j);
				if (j + front.length() > str.length()) {
					break;
				}
				String next = str.substring(j, j + front.length());

				if (front.equals(next)) {
					return true;
				}
			}
		}

		return false;
	}
}

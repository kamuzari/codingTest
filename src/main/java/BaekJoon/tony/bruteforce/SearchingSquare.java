package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchingSquare {
	/**
	 * 서로 다른 1개의 칸을 선택하려 하는데,
	 * 행의 번호가 선택한 순서대로 등차수열을 이루고 있어야 하고, := 다른것은 등차수열 안이루는데?
	 * 열의 번호도 선택한 순서대로 등차수열을 이루고 있어야 한다. := 위와 동일
	 * 이렇게 칸에 적힌 수를 순서대로 이어붙이면 정수를 만들 수 있다.
	 * 연두가 만들 수 있는 정수 중에 가장 큰 완전 제곱수를 구해보자
	 *
	 * 궁금한 것:
	 *  - 라인 별로 쭉 이어 붙이는 건가(5개중에 3개를 선택하는 그런 경우는 없는가?)
	 *  - 만들 수 있는 세자리 수는 123, 321, 456, 654 여기서 완접 제곱수가 왜 64인가?
	 *    - 숫자를 또 그안에서 쪼개 제곱수를 찾는 것인가? 라는 생각이 든다.
	 *
	 *  - 또 이상하게 숫자를 연결하는 방식이 있다. 한 라인이 아닌...
	 * 90개의 있는 칸에서 서로 다른 칸을 선택할 수 있는 경우의 수를 측정하면..
	 * 엄청나게 많은데.. 1억은 거뜬히 넘는다.
	 *  순열 x, 조합 x
	 *  - 내가 고려할 수 있는 경우의 수는 읎다..
	 *  - 생각해보자..
	 *
	 */
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] split = reader.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		int answer = getAnswer(map);
		/**
		 * 문제 이해 중요 및 구현능력 (등차수열이루고 있는
		 */

		System.out.println(answer);
	}

	public static int getAnswer(int[][] arr) {
		int answer = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 등차 수열 간격 (행열에대해서)
				for (int di = -n; di < n; di++) { // 행의 등차 간격
					for (int dj = -m; dj < m; dj++) { // 열의 등차 간격
						if (di == 0 && dj == 0) {
							// 등차수열 간격이 모두 0이면 움직이지 않는다.
							continue;
						}

						String numbers = "";
						int ny = i;
						int nx = j;

						while (!isOutOfRange(ny, nx)) {
							numbers += String.valueOf(arr[ny][nx]);

							if (isSquare(numbers)) { // 제곱수인가?
								answer = Math.max(answer, Integer.parseInt(numbers));
							}

							ny += di;
							nx += dj;
						}
					}

				}
			}
		}

		return answer;
	}
	// 0.000000001도 존재하면 안됀다. 그래야 제곱수
	private static boolean isSquare(String numbers) {
		int number = Integer.parseInt(numbers);

		return Math.abs(Math.sqrt(number) - (int)Math.sqrt(number)) == 0;
	}

	public static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}

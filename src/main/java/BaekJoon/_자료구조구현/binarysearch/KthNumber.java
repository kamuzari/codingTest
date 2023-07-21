package BaekJoon._자료구조구현.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());

		/**
		 * a[k] = x
		 * k번째수는 x이다.
		 * 역으로 생각해보면 x는 7번째에 있다 := 최소 x보다 작은 것들이 7개 있다.
		 * 2차원 배열의 각 행마다 x보다 작은게 몇개 있는지 체크하기 위해서는 나눗셈이 있다.
		 * 1행에서 x보다 작은 것은 x/헹 = n의 범위를 넘어설 경우를 대비 min
		 */

		long s = 0;
		long e = Long.MAX_VALUE - 1;
		long answer = 0;

		while (s < e) {
			long mid = (s + e) >> 1;

			long countRatherThanMid = 0;
			for (int i = 1; i <= n; i++) {
				countRatherThanMid += Math.min(n, mid / i);
			}

			if (countRatherThanMid >= k) {
				answer = mid;
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}
}

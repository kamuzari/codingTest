package saffy.ssafy.homework.daily05;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SetToOrigins {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= tc; testCase++) {
			int n = Integer.parseInt(sc.nextLine());
			long moveCount = 0;
			// 한쪽으로 몰수도 없다..
			long maxDistance = -1;
			int oddCnt = 0;
			int evenCnt = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				long distance = Math.abs(y) + Math.abs(x);
				if (distance == 0) {
					continue;
				}
				if (distance % 2 == 0) {
					evenCnt++;
				} else {
					oddCnt++;
				}

				maxDistance = Math.max(maxDistance, distance);
			}

			if (evenCnt > 0 && oddCnt > 0) {
				moveCount = -1;
			} else {
				if (evenCnt == 0 && oddCnt == 0) {
					moveCount = 0;
				} else {
					long l = 0;
					long r = 200000001;
					while (l < r) {
						long mid = (l + r) >> 1;
						long Sn = sum(mid);
						if (Sn >= maxDistance) {
							r = mid;
						} else {
							l = mid + 1;
						}
					}

					long second = r;
					while ((maxDistance + sum(second)) % 2 != 0) {
						second++;
					}
					moveCount = second;
				}

			}

			answer.append("#").append(testCase).append(" ").append(moveCount).append(System.lineSeparator());
		}
		System.out.println(answer);
	}

	static long sum(long a) {
		return a * (a + 1) / 2;
	}
}

package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLesson {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] lectures = new int[n];

		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 1_000_000_000;
		int l = 0;
		int r = 1_000_000_000;

		while (l <= r) {
			int limit = (l + r) >> 1;

			int blueRay = getBlueRay(lectures, limit);

			if (blueRay > m) {
				l = limit + 1;
			} else {
				answer = Math.min(answer, limit);
				r = limit - 1;
			}
		}

		System.out.println(answer);
	}

	/**
	 * note: 반레 -> 반으로 탐색하다가 제한 수용량이 원소의 값보다 작은 경우 블르레이 카운팅이 했다고 치고 작은 answer를 받아들임
	 *   - 원래는 해당 수용량을 충족할 수 없으므로 더 많은 수용량으로 다시 계산해야함.
	 *  7 6
	 *  100 400 300 100 500 101 400
	 */
	private static int getBlueRay(int[] lectures, int limit) {
		int blueRay = 1;
		int lectureTime = 0;

		for (int lecture : lectures) {
			if (lecture > limit) {
				return 100_000;
			}

			if (lectureTime + lecture <= limit) {
				lectureTime += lecture;
			} else {
				blueRay++;
				lectureTime = lecture;
			}
		}

		return blueRay;
	}
}
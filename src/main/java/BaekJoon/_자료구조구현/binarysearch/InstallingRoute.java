package BaekJoon._자료구조구현.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallingRoute {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int requirementRoute = Integer.parseInt(st.nextToken());

		int[] positions = new int[n];
		for (int i = 0; i < n; i++) {
			positions[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(positions);
		int answer = installRoute(n, requirementRoute, positions);

		System.out.println(answer);
	}

	private static int installRoute(int n, int requirementRoute, int[] positions) {
		int start = 1;
		int end = 1_000_000_000;
		int answer = 0;

		while (start <= end) {
			int mid = (start + end) >> 1;
			int installCount = getInstallCount(n, positions, mid);

			// 설치할 개수가 요구사항보다 많은 작은 단위로 공유기로 설치했기 때문이다. 그래서 더 큰 단위로 잘라야한다.
			if (installCount >= requirementRoute) {
				answer = Math.max(answer, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}

	private static int getInstallCount(int n, int[] positions, int distance) {
		int installCount = 1;
		int previousPosition = positions[0];

		for (int i = 1; i < n; i++) {
			int gap = positions[i] - previousPosition;
			if (gap >=distance) {
				previousPosition = positions[i];
				installCount++;
			}
		}

		return installCount;
	}
}

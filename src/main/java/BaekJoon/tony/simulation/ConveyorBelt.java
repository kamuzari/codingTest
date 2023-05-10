package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConveyorBelt {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n * 2];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n * 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, arr));
	}

	// int[] arr: 내구도
	// 로봇을 순차적으로 하나씩 0번칸에 올리는 거네.
	static int solution(int n, int k, int[] arr) {
		int answer = 0;
		int cur = k - 1;
		boolean isExists[] = new boolean[n]; // 로봇 위치

		while (isRunnable(arr, k)) {
			// 1.벨트 회전(내구도 이동함.)
			int last = arr.length - 1;
			int temp = arr[last];
			for (int i = last; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
			// 1.벨트 회전과 동시에 로봇도 함께 이동
			for (int i = isExists.length - 1; i > 0; i--) {
				isExists[i] = isExists[i - 1];
			}

			isExists[0] = false; // 다음 로봇 0에 올릴 준비
			isExists[n - 1] = false; // 로봇이 있으면 하차
			// 먼저 올라간 로봇 이동하기
			for (int i = n - 1; i > 0; i--) {
				if (isExists[i - 1] && !isExists[i] && arr[i] >= 1) {
					// 이동하는 칸에 로봇이 없으며 내구도가 1이상인 컨베이어 칸
					isExists[i] = true;
					isExists[i - 1] = false;
					arr[i]--;
				}
			}

			// 새로운 로봇 1위치에 올리기
			if (arr[0] >= 1) {
				arr[0]--;
				isExists[0] = true;
			}

			answer++;
		}

		return answer;
	}

	static boolean isRunnable(int[] arr, int limit) {
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				cnt++;
		}

		return cnt < limit;
	}
}

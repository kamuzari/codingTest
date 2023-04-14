package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HitEggFronEgg2 {

	private static int n, answer;
	private static int[][] eggs;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		eggs = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}

		hit(0);

		System.out.println(answer);
	}

	public static void hit(int cnt) {
		if (n <= cnt) {
			long count = Arrays.stream(eggs).map(egg -> egg[0])
				.filter(durability -> durability <= 0)
				.count();
			answer = Math.max(answer, (int)count);
			return;
		}
		// 이미 깨져있으면 다른 계란을 선택해야 함.
		if (eggs[cnt][0] <= 0) {
			hit(cnt + 1);
		} else {
			boolean isRunnable = false; // 현재 cnt계란으로 칠수 있는 계란이 있는지
			for (int i = 0; i < n; i++) {
				if (i == cnt || eggs[i][0] < 0) {
					continue;
				}

				isRunnable = true;

				eggs[cnt][0] -= eggs[i][1];
				eggs[i][0] -= eggs[cnt][1];
				hit(cnt + 1);
				eggs[cnt][0] += eggs[i][1];
				eggs[i][0] += eggs[cnt][1];
			}

			// 현재 손에 쥐고 있는 계란으로 깨뜨릴게 더 없다면 다음 거를 집어서 다시 순차적으로 깨본다.
			if (!isRunnable) {
				hit(cnt + 1);
			}
		}

	}
}

package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gear {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int gears[][] = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String[] str = reader.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(str[j]);
			}
		}

		int n = Integer.parseInt(reader.readLine());
		int[][] cmd = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken());
			cmd[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(gears, cmd));
	}

	static int g[][];

	static int solution(int[][] gears, int[][] cmds) {
		int answer = 0;
		g = gears;
		for (int[] cmd : cmds) {
			int idx = cmd[0] - 1;
			int dir = cmd[1];
			if (dir == 1) { // 시계
				// 왼쪽, 오른쪽 전파까지 계속 해야함.
				v[idx] = true;
				go(idx, dir);
				v[idx] = false;
			} else {
				v[idx] = true;
				go(idx, dir);
				v[idx] = false;
			}
		}

		int score = 1;
		for (int i = 0; i < 4; i++) {
			answer += gears[i][0] == 1 ? score : 0;
			score *= 2;
		}

		return answer;
	}

	static boolean v[] = new boolean[4];

	static void go(int idx, int dir) {
		if (idx <= 2 && !v[idx + 1] && g[idx][2] != g[idx + 1][6]) {
			v[idx + 1] = true;
			go(idx + 1, dir * -1);
			v[idx + 1] = false;
		}

		if (idx >= 1 && !v[idx - 1] && g[idx][6] != g[idx - 1][2]) {
			v[idx - 1] = true;
			go(idx - 1, dir * -1);
			v[idx - 1] = false;
		}

		if (idx == 0 || idx == 3) {
			rotate(dir, idx);
		} else {
			rotate(dir, idx);
		}
	}

	static void rotate(int dir, int idx) {
		if (dir == 1) {
			int temp = g[idx][7];

			for (int i = 7; i > 0; i--) {
				g[idx][i] = g[idx][i - 1];
			}

			g[idx][0] = temp;
			return;
		}

		int temp = g[idx][0];

		for (int i = 0; i < 7; i++) {
			g[idx][i] = g[idx][i + 1];
		}

		g[idx][7] = temp;
	}
}

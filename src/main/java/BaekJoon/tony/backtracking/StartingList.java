package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class StartingList {
	static int result = 0;
	private static int[][] abilities;
	private static Set<Integer> positions;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(reader.readLine());
		StringBuilder answers = new StringBuilder();
		while (testCase-- > 0) {
			result = 0;
			abilities = new int[11][11];

			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				for (int position = 0; position < 11; position++) {
					abilities[i][position] = Integer.parseInt(st.nextToken());
				}
			}

			positions = new HashSet<>();
			pick(0, 0, 0);
			answers.append(result + "\n");
		}

		System.out.println(answers.toString());
	}

	static void pick(int pickedLineUp, int totalAbility, int nextPerson) {
		if (pickedLineUp == 11) { // 라인업 완성
			result = Math.max(totalAbility, result);
			return;
		}

		for (int j = 0; j < 11; j++) {
			if (abilities[nextPerson][j] == 0) continue;
			if(positions.contains(j)) continue; //이미 뽑은 포지션이라면

			positions.add(j);
			pick(pickedLineUp + 1, totalAbility + abilities[nextPerson][j], nextPerson + 1);
			positions.remove(j);
		}
	}
}

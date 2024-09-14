package BaekJoon.tony.shotestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProofOfProposition {
	static Scanner sc = new Scanner(System.in);
	static boolean[][] isConnected = new boolean[52][52];
	static int autoIdx = 0;
	static Map<Character, Integer> mappings = new HashMap<>();
	static Map<Integer, Character> revMappings = new HashMap<>();

	static {
		for (char i = 'A'; i <= 'z'; i++) {
			if (Character.isAlphabetic(i)) {
				mappings.put(i, autoIdx);
				revMappings.put(autoIdx++, i);
			}
		}

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String[] path = sc.nextLine().split(" => ");
			char source = path[0].charAt(0);
			char to = path[1].charAt(0);

			Integer s = mappings.get(source);
			Integer t = mappings.get(to);
			isConnected[s][t] = true;
		}

		for (int k = 0; k < 52; k++) {
			for (int i = 0; i < 52; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 0; j < 52; j++) {
					if (i == j || k == j)
						continue;

					if (isConnected[i][k] && isConnected[k][j]) {
						isConnected[i][j] = true;
					}
				}
			}
		}

		int count = 0;
		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < 52; i++) {
			Character upper = revMappings.get(i);
			for (int j = 0; j < 52; j++) {
				if (i == j)
					continue;
				Character lower = revMappings.get(j);
				if (isConnected[i][j]) {
					count++;
					answers.append(upper + " => " + lower)
						.append(System.lineSeparator());
				}
			}
		}
		System.out.println(count);
		System.out.println(answers);
	}

}

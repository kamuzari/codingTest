package tony;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TeamBuilding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] abilities = new int[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			abilities[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = abilities.length - 1;
		int answer = 0;
		while (s < e) {
			int candidateValue = calculate(e, s, abilities);
			answer = Math.max(answer, candidateValue);

			if (abilities[s] > abilities[e]) {
				e--;
			} else {
				s++;
			}
		}

		System.out.println(answer);
	}

	private static int calculate(int e, int s, int[] abilities) {
		return (e - s - 1) * Math.min(abilities[s], abilities[e]);
	}

}

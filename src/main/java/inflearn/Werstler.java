package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Werstler {
	public static class Player {
		private int height;
		private int weight;

		public Player(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		public boolean isPromise(Player other) {
			return this.height > other.height || this.weight > other.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int answer = 0;
		Player[] players = new Player[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			players[i] = new Player(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
		}

		for (int stardard = 0; stardard < n; stardard++) {
			boolean isPossible = true;

			for (int comparence = 0; comparence < n; comparence++) {
				if (stardard == comparence) {
					continue;
				}

				if (!players[stardard].isPromise(players[comparence])) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}

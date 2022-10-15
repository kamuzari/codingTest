package MakeOut.BackTracking.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeatEggsWithEggs {

	private static int n;
	private static long answer;

	static class Egg {
		private int durablity;
		private int weight;

		public Egg(int durablity, int weight) {
			this.durablity = durablity;
			this.weight = weight;
		}

		public boolean isNotBroken() {
			return this.durablity > 0;
		}

		public boolean isBroken() {
			return this.durablity <= 0;
		}

		public void attack(Egg other) {
			this.durablity -= other.weight;
		}

		public void undoAttack(Egg other) {
			this.durablity += other.weight;
		}

	}

	private static Egg[] eggs;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		eggs = new Egg[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			eggs[i] = new Egg(durability, weight);
		}

		hit(0);

		System.out.println(answer);
	}

	public static void hit(int cnt) {
		if (cnt == n) {
			long count = Arrays.stream(eggs).filter(Egg::isBroken)
				.count();

			answer = Math.max(answer, count);
			return;
		}

		if (eggs[cnt].isBroken()) {
			hit(cnt + 1);
		} else {
			/**
			 3
			 1 1
			 1 1
			 1 1
			 note :이런경우 어떻게 해서라도 최댓값이 2가나와야 하는데 더이상 깰 게 없으니.
			 연산을 해줘야 한다. 그렇기 때문에 자의적으로 aging 을 해준다.
			 */
			boolean isNothingCompare = true; // note:


			for (int i = 0; i < n; i++) {
				boolean isSame = (i == cnt);

				if (isSame || eggs[i].isBroken()) {
					continue;
				}

				isNothingCompare = false;
				Egg eggInHand = eggs[cnt];
				Egg next = eggs[i];

				eggInHand.attack(next);
				next.attack(eggInHand);

				hit(cnt + 1);

				eggInHand.undoAttack(next);
				next.undoAttack(eggInHand);
			}

			if(isNothingCompare){
				hit(cnt+1);
			}
		}

	}
}

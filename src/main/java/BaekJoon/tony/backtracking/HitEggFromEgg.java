package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HitEggFromEgg {

	private static int n, answer;
	private static List<Egg> eggs = new ArrayList<>();

	/**
	 * 계란으로 계란을 꺨때 순서는 상과없는 것 같음
	 * 입출력 1번이 3개이므로
	 *
	 */

	static class Egg {
		int durability, wegith;

		public Egg(int durability, int wegith) {
			this.durability = durability;
			this.wegith = wegith;
		}

		public void hit(Egg egg) {
			this.durability -= egg.wegith;
		}

		public void restore(Egg egg) {
			this.durability += egg.wegith;
		}

		public boolean isBreak() {
			return this.durability <= 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());
		eggs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			eggs.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		pick(0);

		System.out.println(answer);
	}

	// 순서를 정하고( 다 뽑고 )함 치면 되겠지?
	private static void pick(int cnt) {
		if (cnt == n) {
			long count = eggs.stream().filter(Egg::isBreak).count();
			answer = Math.max((int)count, answer);
			return;
		}

		if (eggs.get(cnt).isBreak()) {
			pick(cnt + 1);
		} else {
			boolean isEnd = true;

			for (int i = 0; i < n; i++) {
				if (i == cnt || eggs.get(i).isBreak()) {
					continue;
				}

				isEnd = false;
				Egg cur = eggs.get(cnt);
				Egg target = eggs.get(i);

				cur.hit(target);
				target.hit(cur);
				pick(cnt + 1);
				cur.restore(target);
				target.restore(cur);
			}

			if (isEnd) {
				pick(cnt + 1);
			}
		}
	}


}

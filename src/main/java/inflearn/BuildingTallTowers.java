package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildingTallTowers {

	/**
	 * note: 가장 높이 탑을 쌓아야 한다. 즉 h를 최대화 시켜라
	 *  - 회전 x
	 *  - 탑을 쌓을 때, 밑에 있는 돌은 바로 위에 있는 돌보다 넓어야 한다.
	 *  - 탑을 쌓을 떄, 밑에 있는 돌은 위에 있는 돌보다 무거워야 한다.
	 *
	 *  hint: 순서를 보장하라라는 요구사항은 없으므로 정렬이 들어가야 함.
	 */
	static class Brick {
		private int bottomWidth;
		private int height;
		private int weight;

		public Brick(int bottomWidth, int height, int weight) {
			this.bottomWidth = bottomWidth;
			this.height = height;
			this.weight = weight;
		}

		public boolean isPossibleOnTheTop(Brick bottom) {
			return this.bottomWidth < bottom.bottomWidth && this.weight < bottom.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		List<Brick> bricks = new ArrayList<>();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			int bottom = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			answer = Math.max(answer, height);

			bricks.add(new Brick(bottom, height, weight));
		}

		bricks.sort((a, b) -> {
			if (b.bottomWidth - a.bottomWidth == 0) {
				return b.weight - a.weight;
			}

			return b.bottomWidth - a.bottomWidth;
		});

		int[] maxHeights = new int[n];

		for (int i = 0; i < n; i++) {
			maxHeights[i] = bricks.get(i).height;
		}

		for (int top = 1; top < n; top++) {
			Brick criteria = bricks.get(top);

			for (int bottom = 0; bottom < top; bottom++) {
				if (criteria.isPossibleOnTheTop(bricks.get(bottom))) {
					maxHeights[top] = Math.max(maxHeights[top], maxHeights[bottom] + criteria.height);
					answer = Math.max(answer, maxHeights[top]);
				}
			}
		}

		System.out.println(answer);
	}
}

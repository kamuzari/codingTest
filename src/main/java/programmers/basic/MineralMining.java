package programmers.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MineralMining {
	enum Tool {
		DIAMOND, IRON, STONE;

	}

	/**
	 * 최소한의 피로도
	 - 다이아 곡객이가 필요한 구간은 다이아가 많은 곳
	 - 순서는 꼭 처음부터 끝까지 갈필요 없고 미리 미네랄 구역의 사전조사를 한다.
	 - [0-4], [5-8]

	 caution
	 - 곡갱이가 없는데 mine의 영역이 더 클 경우 정렬이 들어가있으므로 순서가 안해도 될것들 해버려 피로도가 더 나오게 된다.
	 - 즉 순서에 유의해야 한다. (결정타 예제 케이스 8번)
	 */

	static class Mine implements Comparable<Mine> {
		int diamond;
		int iron;
		int stone;

		public Mine(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}

		public int compareTo(Mine o) {
			if (o.diamond == diamond) {
				if (o.iron == iron) {
					return o.stone - stone;
				}

				return o.iron - iron;
			}
			return o.diamond - diamond;
		}

		public int getFatigue(Tool tool) {
			if (Tool.DIAMOND.equals(tool)) {
				return diamond + iron + stone;
			} else if (Tool.IRON.equals(tool)) {
				return 5 * diamond + iron + stone;
			} else if (Tool.STONE.equals(tool)) {
				return 25 * diamond + 5 * iron + stone;
			}

			throw new RuntimeException("[pirodo error]");
		}
	}

	public int solution(int[] picks, String[] minerals) {
		int fetigue = 0;

		int n = minerals.length / 5 + 1;
		int[][] intervals = new int[n][5];
		for (int i = 0; i < minerals.length; i++) {
			String mineral = minerals[i];
			intervals[i / 5][i % 5] = toId(minerals[i]);
		}

		List<Mine> mines = new ArrayList<>();
		int toolCount = Arrays.stream(picks).sum();

		for (int i = 0; i < n; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(1, 0);
			map.put(2, 0);
			map.put(3, 0);

			for (int j = 0; j < 5; j++) {
				if (intervals[i][j] == 0) {
					continue;
				}

				map.put(intervals[i][j], map.getOrDefault(intervals[i][j], 0) + 1);
			}

			mines.add(new Mine(map.get(1), map.get(2), map.get(3)));
			toolCount--;
			if (toolCount == 0) {
				break;
			}
		}

		Collections.sort(mines);

		for (Mine mine : mines) {
			if (picks[0] > 0) {
				picks[0]--;
				fetigue += mine.getFatigue(Tool.DIAMOND);
			} else if (picks[1] > 0) {
				picks[1]--;
				fetigue += mine.getFatigue(Tool.IRON);
			} else if (picks[2] > 0) {
				picks[2]--;
				fetigue += mine.getFatigue(Tool.STONE);
			} else {
				break;
			}
		}

		return fetigue;
	}

	public int toId(String s) {
		if (s.equals("diamond")) {
			return 1;
		} else if (s.equals("iron")) {
			return 2;
		} else if (s.equals("stone")) {
			return 3;
		}

		return -1;
	}
}

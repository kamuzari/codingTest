package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RockClimbing {
	static class Rock {
		int y, x, cnt;

		public Rock(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		List<Integer> postions[] = new List[200_001];
		for (int i = 0; i < 200_001; i++) {
			postions[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			postions[y].add(x);
		}

		for (int i = 0; i < 200_001; i++) {
			postions[i].sort(Integer::compareTo);
		}

		int result = getMinReachCount(postions, t);
		System.out.println(result);
	}

	static Set<String> v;

	private static int getMinReachCount(List<Integer>[] rocks, int t) {
		LinkedList<Rock> q = new LinkedList<>();
		v = new HashSet<>();
		q.offer(new Rock(0, 0, 0));

		while (!q.isEmpty()) {
			Rock cur = q.poll();
			if (cur.y >= t) {
				return cur.cnt;
			}
			for (int i = cur.y - 2; i <= cur.y + 2; i++) {
				if (i < 0 || cur.y > 200_000) {
					continue;
				}

				List<Integer> x = rocks[i];
				if (x.isEmpty())
					continue;
				int minX = cur.x - 2;
				if (minX < 0) {
					minX = 0;
				}
				int start = lowerbound(x, minX);
				int maxX = cur.x + 2;
				for (int j = start; j < x.size(); j++) {
					if (maxX < x.get(j))
						break;

					Integer xValue = x.get(j);
					String key = i + "," + j;
					if (v.contains(key)) {
						continue;
					}

					v.add(key);
					q.offer(new Rock(i, xValue, cur.cnt + 1));
				}
			}
		}

		return -1;
	}

	private static int lowerbound(List<Integer> list, int target) {
		int s = 0;
		int e = list.size();

		while (s < e) {
			int mid = (s + e) >> 1;

			if (target <= list.get(mid)) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return e;
	}

	private static boolean isNext(Rock next, Rock cur) {
		return Math.abs(next.y - cur.y) <= 2 && Math.abs(next.x - cur.x) <= 2;
	}
}

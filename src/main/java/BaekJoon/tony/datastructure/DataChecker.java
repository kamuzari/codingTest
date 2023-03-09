package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DataChecker {
	/**
	 * 서로 다른 2개의 원을 선택하면 원을 선택하면 n제곱이라 TLE
	 * 우선순위 큐에 x축 기준으로 정렬 후 인접한 것 끼리만 비교
	 *  인접한 원의 왼쪽 점과 오른쪽 점 바교해야함
	 *  	어떻게 비교해야지?
	 *   1,2 번째 교점이 안만들어진다고 치면 3번째에서 교점이 만들어지는 경우는 없을까? -있다.
	 * @param args
	 */
	static class Point implements Comparable<Point> {
		int id;
		int x; //(왼쪽 점 또는 오른쪽 점)

		public Point(int id, int x) {
			this.id = id;
			this.x = x;
		}

		public int compareTo(Point o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int n = Integer.parseInt(reader.readLine());
		for (int id = 0; id < n; id++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int mid = Integer.parseInt(tokenizer.nextToken());
			int r = Integer.parseInt(tokenizer.nextToken());

			Point left = new Point(id, mid - r);
			Point right = new Point(id, mid + r);

			pq.offer(left);
			pq.offer(right);
		}
		Stack<Integer> s = new Stack<>();
		while (!pq.isEmpty()) {
			if (s.isEmpty()) {
				s.push(pq.poll().id);
			} else {
				int id = pq.poll().id;

				if (s.peek() == id) {
					s.pop();
				} else {
					s.push(id);
				}
			}
		}

		System.out.println(s.isEmpty() ? "YES" : "NO");
	}
}

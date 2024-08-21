package BaekJoon.tony.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HideAndSeek3 {
	static final int INF = (int)1e9;
	static final int MAX_POSITION = 100_000;
	static final int MIN_POSITION = 0;
	static final int DX_SIZE = 3;
	static final int dx[] = {-1, 1, 2};

	static class Node {
		private int currentPosition;
		private int seconds;

		public Node(int currentPosition, int seconds) {
			this.currentPosition = currentPosition;
			this.seconds = seconds;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
		int answer = bfs(subin, sister);
		System.out.println(answer);
	}

	private static int bfs(int subin, int sister) {
		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(subin, 0));
		int v[] = new int[MAX_POSITION + 1];
		// 이전에 boolean type 의 방문 처리 x -> 더 빨리올 수 있는 경우도 있다. 4 -> 6 으로 갈경우 2초 보다 더 빨리 올수 있다.
		Arrays.fill(v, INF);
		v[subin] = 0;
		while (!q.isEmpty()) {
			Node current = q.poll();
			for (int i = 0; i < DX_SIZE; i++) {
				int nx = 0;
				int time = 0;
				if (i == 2) {
					nx = dx[i] * current.currentPosition;
					time = current.seconds;
				} else if (i != 2) {
					nx = dx[i] + current.currentPosition;
					time = current.seconds + 1;
				}
				if (outOfIdx(nx))
					continue;
				if (v[nx] <= time)
					continue;
				v[nx] = time;
				q.offer(new Node(nx, time));
			}
		}
		return v[sister];
	}

	static boolean outOfIdx(int nx) {
		return nx < MIN_POSITION || nx > MAX_POSITION;
	}
}

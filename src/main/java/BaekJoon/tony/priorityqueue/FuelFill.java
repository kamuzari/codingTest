package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FuelFill {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int[][] stations = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			stations[i][0] = Integer.parseInt(st.nextToken());
			stations[i][1] = Integer.parseInt(st.nextToken());
		}

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int vilieage = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		System.out.println(solution(vilieage, fuel, stations));
	}

	static int solution(int vilieage, int fuel, int[][] stations) {
		int answer = 0;

		PriorityQueue<int[]> distPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> fuelDescPq = new PriorityQueue<>(Collections.reverseOrder());
		distPq.addAll(Arrays.asList(stations));
		distPq.add(new int[] {vilieage, 0});
		int cur = 0;

		while (!distPq.isEmpty()) {
			int[] station = distPq.peek();
			if (station[0] <= fuel + cur) {
				int[] go = distPq.poll();
				fuel -= (go[0] - cur);
				cur = go[0];
				fuelDescPq.offer(go[1]);
			} else if (!fuelDescPq.isEmpty()) { // 갈 수 없으니 충전
				fuel += fuelDescPq.poll();
				answer++;
			} else {
				// 다음 주유소도 가나가 연료가 부족해서 못가고 충전할 곳도 없으니 못감
				return -1;
			}
		}

		return answer;
	}
}

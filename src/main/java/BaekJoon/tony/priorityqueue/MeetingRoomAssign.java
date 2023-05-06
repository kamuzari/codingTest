package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoomAssign {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int[][] meetings = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		int answer = 1;
		int end = meetings[0][1];

		for (int i = 1; i < meetings.length; i++) {
			int[] meeting = meetings[i];

			if (meeting[0] >= end) {
				answer++;
				end = meeting[1];
			}
		}

		System.out.println(answer);
	}
}

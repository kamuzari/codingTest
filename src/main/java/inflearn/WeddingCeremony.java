package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeddingCeremony {
	private static final int FINAL_TIME = 73;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int[] attendanceTime = new int[FINAL_TIME];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int attendance = Integer.parseInt(st.nextToken());
			int timeOut = Integer.parseInt(st.nextToken());
			attendanceTime[attendance]++;
			attendanceTime[timeOut]--;
		}

		int participants = 0;

		for (int i = 1; i < FINAL_TIME; i++) {
			attendanceTime[i] += attendanceTime[i - 1];
			participants = Math.max(participants, attendanceTime[i]);
		}

		System.out.println(participants);

	}
}

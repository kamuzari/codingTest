package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class JunhaWentToTheMilitaryPCRoom {
	static class Entrant implements Comparable<Entrant> {
		int idx, startTime, endTime;

		public Entrant(int idx, int startTime, int endTime) {
			this.idx = idx;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Entrant o) {
			if (startTime - o.startTime == 0) {
				if (endTime - o.endTime == 0) {
					return idx - o.idx;
				}

				return endTime - o.endTime;
			}

			return startTime - o.startTime;
		}
	}

	static class PcUser implements Comparable<PcUser> {
		private int seatId;
		private int endTime;

		public PcUser(int seatId, int endTime) {
			this.seatId = seatId;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(PcUser o) {
			return endTime - o.endTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		PriorityQueue<Integer> sequences = new PriorityQueue<>();
		for (int i = 0; i < 100_001; i++) {
			sequences.offer(i);
		}

		PriorityQueue<Entrant> timeOrders = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			timeOrders.offer(new Entrant(i, start, end));
		}

		int numberOfConcurrentUsers = 1;
		int[] seatCount = new int[n];
		Integer seatId = sequences.poll();
		Entrant first = timeOrders.poll();
		PriorityQueue<PcUser> pcUsers = new PriorityQueue<>();
		pcUsers.offer(new PcUser(seatId, first.endTime));

		while (!timeOrders.isEmpty()) {
			Entrant cur = timeOrders.poll();
			while (!pcUsers.isEmpty()) {
				if (pcUsers.peek().endTime <= cur.startTime) {
					PcUser poll = pcUsers.poll();
					seatCount[poll.seatId]++;
					sequences.offer(poll.seatId);
				} else {
					break;
				}
			}

			pcUsers.offer(new PcUser(sequences.poll(), cur.endTime));
			numberOfConcurrentUsers = Math.max(numberOfConcurrentUsers, pcUsers.size());
		}

		if (!pcUsers.isEmpty()) {
			while (!pcUsers.isEmpty()) {
				PcUser poll = pcUsers.poll();
				seatCount[poll.seatId]++;
			}
		}

		System.out.println(numberOfConcurrentUsers);
		String seatCountResult = Arrays.stream(seatCount)
			.limit(numberOfConcurrentUsers)
			.boxed()
			.map(String::valueOf)
			.collect(Collectors.joining(" "));
		System.out.println(seatCountResult);
	}
}

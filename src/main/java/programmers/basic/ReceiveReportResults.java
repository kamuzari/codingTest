package programmers.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReceiveReportResults {
	class Node {
		int count;
		Set<String> senders;

		public Node() {
			this.count = 0;
			this.senders = new HashSet<>();
		}

		public void add(String name) {
			if (this.senders.contains(name)) {
				return;
			}

			this.senders.add(name);
			this.count = this.count + 1;

		}

		public boolean isViolate(int limit) {
			return this.count >= limit;
		}
	}

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Map<String, Node> map = new HashMap<>();
		for (String name : id_list) {
			map.put(name, new Node());
		}

		for (String rep : report) {
			String[] users = rep.split(" ");
			String sender = users[0];
			String target = users[1];

			map.get(target).add(sender);
		}

		Map<String, Integer> alarms = new HashMap<>();
		for (String target : map.keySet()) {
			if (map.get(target).isViolate(k)) {
				for (String name : map.get(target).senders) {
					alarms.put(name, alarms.getOrDefault(name, 0) + 1);
				}
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			String name = id_list[i];

			if (!alarms.containsKey(name)) {
				continue;
			}

			answer[i] = alarms.get(name);
		}

		return answer;
	}
}

package programmers.coding99;

import java.util.HashMap;
import java.util.Map;

public class RunRace {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> names = new HashMap<>();
		String[] ranks = new String[players.length];
		int idx = 0;
		for (String name : players) {
			names.put(name, idx);
			ranks[idx++] = name;
		}

		for (String name : callings) {
			int rank = names.get(name);
			names.put(name, rank - 1);

			String fronter = ranks[rank - 1];
			String candidate = ranks[rank];

			ranks[rank - 1] = candidate;
			ranks[rank] = fronter;
			names.put(fronter, rank);
		}

		return ranks;
	}
}

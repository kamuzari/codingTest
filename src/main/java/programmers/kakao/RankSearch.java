package programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankSearch {
	Map<String, List<Integer>> candidates = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		push(info);

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] q = query[i].split(" and | ");
			String language = q[0].trim();
			String role = q[1].trim();
			String career = q[2].trim();
			String food = q[3].trim();
			String key = String.join("::", language, role, career, food);
			if (!candidates.containsKey(key)) {
				answer[i] = 0;
			} else {
				int target = Integer.parseInt(q[4].trim());
				int count = Collections.binarySearch(candidates.get(key), target);
				answer[i] = count;
			}
		}

		return answer;
	}

	void push(String[] infos) {
		for (String info : infos) {
			String[] total = info.split(" ");
			String[] languages = {total[0], "-"};
			String[] roles = {total[1], "-"};
			String[] careers = {total[2], "-"};
			String[] foods = {total[3], "-"};
			int score = Integer.parseInt(total[4]);

			for (int i = 0; i < languages.length; i++) {
				for (int j = 0; j < roles.length; j++) {
					for (int k = 0; k < careers.length; k++) {
						for (int o = 0; o < foods.length; o++) {
							String key = String.join("::", languages[i], roles[j], careers[k], foods[o]);

							if (!candidates.containsKey(key)) {
								candidates.put(key, new ArrayList<>());
							}

							candidates.get(key).add(score);
						}
					}
				}
			}
		}

		for (String key : candidates.keySet()) {
			Collections.sort(candidates.get(key));
		}
	}

}

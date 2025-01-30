package programmers.basic;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> wants = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			String name = want[i];
			int quantity = number[i];
			wants.put(name, quantity);
		}

		int n = discount.length;
		for (int i = 0; i < n - 9; i++) {
			Map<String, Integer> purchases = new HashMap<>();

			for (int day = i; day < i + 10; day++) {
				String name = discount[day];
				purchases.put(name, purchases.getOrDefault(name, 0) + 1);
			}

			if (isEnable(wants, purchases)) {
				answer++;
			}
		}

		return answer;
	}

	public boolean isEnable(Map<String, Integer> wants, Map<String, Integer> purchases) {
		for (String key : wants.keySet()) {
			if (!purchases.containsKey(key)) {
				return false;
			}

			if (wants.get(key) != purchases.get(key)) {
				return false;
			}
		}

		return true;
	}
}

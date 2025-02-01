package programmers.basic;

import java.util.HashMap;
import java.util.Map;

public class MultiStageToothbrushSales {
	static final String EMPTY = "-";

	Map<String, Integer> salaries;
	Map<String, String> references;

	public int[] solution(String[] enroll,
		String[] referral,
		String[] seller,
		int[] amount) {

		salaries = new HashMap<>();
		references = new HashMap<>();

		int peopleCount = enroll.length;
		for (int i = 0; i < peopleCount; i++) {
			String name = enroll[i];
			salaries.put(name, 0);
			String refer = referral[i];
			references.put(name, refer);
		}

		for (int i = 0; i < seller.length; i++) {
			distributeProfit(seller[i], amount[i] * 100);
		}

		int[] answer = new int[peopleCount];
		for (int i = 0; i < answer.length; i++) {
			String name = enroll[i];
			answer[i] = salaries.get(name);
		}

		return answer;
	}

	public void distributeProfit(String name, int amount) {
		int distributedAmount = (int)(amount * 0.1);
		int myProfit = amount - distributedAmount;
		salaries.put(name, salaries.getOrDefault(name, 0) + myProfit);
		if (!references.get(name).equals(EMPTY) && distributedAmount != 0) {
			distributeProfit(references.get(name), distributedAmount);
		}
	}
}

package kakaointern2022;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTest {

	public static void main(String[] args) {
		String[] testArgs1 = new String[] {"AN", "CF", "MJ", "RT", "NA"};
		int[] testArgs2 = new int[] {5, 3, 2, 7, 5};
		PersonalityTest personalityTest = new PersonalityTest();
		String solution = personalityTest.solution(testArgs1, testArgs2);
		assert solution.equals("TCMA");
	}

	private static final int MIDDLE = 4;

	public String solution(String[] survey, int[] choices) {
		int length = survey.length;
		Map<String, Integer> results = new HashMap<>();

		results.put("R", 0);
		results.put("T", 0);
		results.put("C", 0);
		results.put("F", 0);
		results.put("J", 0);
		results.put("M", 0);
		results.put("A", 0);
		results.put("N", 0);

		for (int i = 0; i < length; i++) {
			String left = survey[i].substring(0, 1);
			String right = survey[i].substring(1, 2);
			int choice = choices[i];
			int diffValue = Math.abs(MIDDLE - choice);

			if (choice < 4) {
				results.put(left, results.getOrDefault(left, 0) + diffValue);
			} else if (choice > 4) {
				results.put(right, results.getOrDefault(right, 0) + diffValue);
			}
		}

		StringBuilder answer = new StringBuilder();
		int r = results.get("R");
		int t = results.get("T");
		answer.append(getPartialAnswer(r, "R", t, "T"));

		int c = results.get("C");
		int f = results.get("F");
		answer.append(getPartialAnswer(c, "C", f, "F"));

		int j = results.get("J");
		int m = results.get("M");
		answer.append(getPartialAnswer(j, "J", m, "M"));

		int a = results.get("A");
		int n = results.get("N");
		answer.append(getPartialAnswer(a, "A", n, "N"));

		return answer.toString();
	}

	public String getPartialAnswer(int val1, String left, int val2, String right) {
		return val1 >= val2 ? left : right;
	}
}

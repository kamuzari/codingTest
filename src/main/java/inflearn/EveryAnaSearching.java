package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EveryAnaSearching {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[] s = reader.readLine().toCharArray();
		Map<Character, Integer> originals = new HashMap<>();
		Map<Character, Integer> compares = new HashMap<>();

		char[] t = reader.readLine().toCharArray();
		for (char ch : t) {
			compares.put(ch, compares.getOrDefault(ch, 0) + 1);
		}

		int n = s.length;
		int start = 0;
		int end = 0;
		int answer=0;
		int targetLength = t.length;

		while (end < n) {
			if (end - start < targetLength) {
				char key = s[end];
				originals.put(key, originals.getOrDefault(key, 0) + 1);
				end++;
			} else {
				char key = s[start];

				if (originals.get(key) == 1) {
					originals.remove(key);
				} else {
					originals.put(key, originals.get(key) - 1);
				}

				start++;
			}

			if (end - start == targetLength) {
				Set<Character> originalSets = originals.keySet();
				Set<Character> compareSets = compares.keySet();

				if(originalSets.containsAll(compareSets)){

					long count = originalSets.stream().filter(key -> originals.get(key).equals(compares.get(key)))
						.count();

					if(count == compareSets.size()){
						answer++;
					}
				}

			}
		}

		System.out.println(answer);
	}
}

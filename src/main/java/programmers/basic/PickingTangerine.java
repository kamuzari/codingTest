package programmers.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingTangerine {
	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> sizeGroups = new HashMap<>();
		Arrays.stream(tangerine)
			.boxed()
			.sorted()
			.forEach((size) -> sizeGroups.put(size, sizeGroups.getOrDefault(size, 0) + 1));

		List<Integer> orders = sizeGroups.keySet().stream()
			.sorted((a, b) -> sizeGroups.get(b) - sizeGroups.get(a))
			.collect(Collectors.toList());

		int kind = 0;
		for (int size : orders) {
			kind++;
			k -= sizeGroups.get(size);

			if (k <= 0) {
				return kind;
			}
		}

		throw new RuntimeException("고려하지 않은 예외 케이스가 존재합니다.");
	}
}

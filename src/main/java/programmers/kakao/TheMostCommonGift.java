package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheMostCommonGift {
	public int solution(String[] friends, String[] gifts) {
		Map<String, Integer> giftPoints = new HashMap<>();
		Map<String, Map<String, Integer>> givers = new HashMap<>();
		Map<String, Integer> givenCounts = new HashMap<>();

		for (String giver : friends) {
			giftPoints.put(giver, 0);
			givers.put(giver, new HashMap<>());
			givenCounts.put(giver, 0);

			Arrays.stream(friends)
				.filter(receiver -> !receiver.equals(giver))
				.forEach(receiver -> givers.get(giver).put(receiver, 0));
		}

		for (String gift : gifts) {
			String[] s = gift.split(" ");
			String giver = s[0];
			String receiver = s[1];

			givers.get(giver).put(receiver, givers.get(giver).get(receiver) + 1);
			giftPoints.put(giver, giftPoints.getOrDefault(giver, 0) + 1);
			giftPoints.put(receiver, giftPoints.getOrDefault(receiver, 0) - 1);
		}

		for (String giver : friends) {
			for (String receiver : friends) {
				if (giver.equals(receiver))
					continue;
				int giverCount = givers.get(giver).get(receiver);
				int receiverCount = givers.get(receiver).get(giver);
				if (giverCount > receiverCount) {
					givenCounts.put(giver, givenCounts.get(giver) + 1);
				} else if (giverCount == receiverCount) {
					if (giftPoints.get(giver) <= giftPoints.get(receiver))
						continue;
					givenCounts.put(giver, givenCounts.get(giver) + 1);
				}
			}
		}

		return givenCounts.values().stream().mapToInt(v -> v).max().orElseGet(() -> 0);
	}
}

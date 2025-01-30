package programmers.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {
	public String[] solution(String[] record) {
		int n = record.length;

		Map<String, String> idToNames = new HashMap<>();
		for (String sentence : record) {
			String[] words = sentence.split(" ");
			String action = words[0];
			if ("Leave".equals(action)) {
				continue;
			}

			String id = words[1];
			String name = words[2];
			idToNames.put(id, name);
		}

		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String sentence = record[i];
			String[] words = sentence.split(" ");
			String action = words[0];
			String id = words[1];
			if ("Leave".equals(action)) {
				String name = idToNames.get(id);
				results.add(String.format("%s님이 나갔습니다.", name));
			} else if ("Enter".equals(action)) {
				String name = idToNames.get(id);
				results.add(String.format("%s님이 들어왔습니다.", name));
			} else if ("Change".equals(action)) {
				continue;
			} else {
				throw new RuntimeException("고려하지 못한 케이스가 존재합니다.");
			}
		}

		return results.stream().toArray(String[]::new);
	}
}

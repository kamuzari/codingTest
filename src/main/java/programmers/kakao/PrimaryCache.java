package programmers.kakao;

import java.util.LinkedList;

public class PrimaryCache {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (String data : cities) {
            data = data.toUpperCase();
            if (cache.contains(data)) {
                cache.remove(data);
                cache.add(data);
                answer++;
            } else {
                if (cache.size() == cacheSize) {
                    cache.pollFirst();
                }

                cache.add(data);
                answer += 5;
            }
        }

        return answer;
    }
}

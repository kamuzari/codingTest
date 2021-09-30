package tues_thurs_sat._202109._20210928;

import java.util.LinkedList;

public class PGM17680_Cache {
    public static void main(String[] args) {
    }

    // LRU : 캐시 hit -> 순서 맨뒤로
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        int capacity = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (list.contains(city)) {
                list.remove(city);
                list.offer(city);
                answer++;
            } else {
                if (!list.isEmpty() && capacity == cacheSize) {
                    capacity--;
                    list.pop();
                }
                if (cacheSize != 0) {
                    list.add(city);
                    capacity++;
                }
                answer += 5;
            }
        }
        return answer;
    }

}

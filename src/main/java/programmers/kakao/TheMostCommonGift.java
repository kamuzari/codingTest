package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheMostCommonGift {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> nameMappings = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            nameMappings.put(friends[i], i);
        }

        int n = friends.length;
        int[][] tables = new int[n][n];

        for (String to : gifts) {
            String[] aToB = to.split(" ");
            int from = nameMappings.get(aToB[0]);
            int toto= nameMappings.get(aToB[1]);

            tables[from][toto]++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(tables[i]));
        }

        return answer;
    }
}

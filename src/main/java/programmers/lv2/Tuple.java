package programmers.lv2;
import java.util.*;
public class Tuple {
    public int[] solution(String s) {
        StringBuffer sb = new StringBuffer();
        String substring = s.substring(2, s.length() - 2);
        String[] split = substring.split("},\\{");
        Arrays.sort(split, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        ArrayList<Integer> results = new ArrayList<>();
        for (String str : split) {
            String[] split1 = str.split(",");
            for (String element : split1) {
                Integer toInt = Integer.valueOf(element);
                if (!results.contains(toInt)) {
                    results.add(toInt);
                }
            }
        }

        int size = results.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}

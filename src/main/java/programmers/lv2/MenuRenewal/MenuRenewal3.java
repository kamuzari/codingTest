package programmers.lv2.MenuRenewal;

import java.util.*;

public class MenuRenewal3 {
    Map<String, Integer> map ;
    int max=0;
    public String[] solution(String orders[], int[] course) {
        PriorityQueue<String> answers = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            int target = course[i];
            map=new HashMap<>();
            max=0;
            for (int j = 0; j < orders.length; j++) {
                comb(0, 0, target, orders[j], new TreeSet<Character>());
            }
            for (String key : map.keySet()) {
                Integer val = map.get(key);
                if(val>1 && val==max) answers.offer(key);
            }
        }
        String answer[] = new String[answers.size()];
        int idx=0;
        while (!answers.isEmpty()){
            answer[idx++]=answers.poll();
        }
        return answer;
    }

    public void comb(int cnt, int idx, int target, String order, TreeSet<Character> result) {
        if (cnt == target) {
            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                sb.append(c);
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }
        for (int i = idx; i < order.length(); i++) {
            char cur = order.charAt(i);
            result.add(cur);
            comb(cnt + 1, i + 1, target, order, result);
            result.remove(cur);
        }
    }
}

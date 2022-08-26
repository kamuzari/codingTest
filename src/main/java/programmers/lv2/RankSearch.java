package programmers.lv2;
import java.util.*;

public class RankSearch {
    Map<String, List<Integer>> map = new LinkedHashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            makingKey(info[i]);
        }

        for (String key : map.keySet()) {
            map.get(key).sort((o1, o2) -> o1-o2);
            Collections.sort(map.get(key));
        }

        int answer[] = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] s = split[3].split(" ");
            String key = (split[0])+(split[1])+(split[2])+(s[0]);
            if (!map.containsKey(key)) {
                answer[i] = 0;
            } else {
                int score = Integer.parseInt(s[1]);
                List<Integer> list = map.get(key);
                answer[i] = list.size() - lowerBound(score, list);
            }
        }
        return answer;
    }

     void makingKey(String s) {
        String str[]=s.split(" ");
        String language[]={"-",str[0]};
        String role[]={"-",str[1]};
        String career[]={"-",str[2]};
        String food[]={"-",str[3]};
        int score=Integer.parseInt(str[4]);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        String key=language[i]+role[j]+career[k]+food[l];
                        if(!map.containsKey(key))
                        {
                            List<Integer> list=new ArrayList<>();
                            list.add(score);
                            map.put(key,list);
                        }
                        else
                        {
                            map.get(key).add(score);
                        }
                    }
                }
            }

        }
    }

    private int lowerBound(int target, List<Integer> list) {
        int s = 0;
        int e = list.size();
        while (s < e) {
            int mid = (s + e) >> 1;
            if (list.get(mid) >= target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}

package programmers.Kits.Hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class Disguise {
    public static void main(String[] args) {
        String c[][]={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(c));
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map=new LinkedHashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key=clothes[i][1];
            map.put(key,map.getOrDefault(key,0)+1);

        }
//        System.out.println(map);
        for (Integer val : map.values()) {
            answer*=(val+1);
        }
        return answer-1;
    }

}

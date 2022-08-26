package programmers.lv2;
import java.util.*;

public class Disguise {
    Map<String,Integer> map=new HashMap<>();
    public int solution(String[][] clothes) {
        for(String [] cloth : clothes){
            String key=cloth[1];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int answer=1;
        for(String key : map.keySet()){
            answer*=(map.get(key)+1);
        }
        return answer-1; // 단 입은 경우 제외하기
    }
}

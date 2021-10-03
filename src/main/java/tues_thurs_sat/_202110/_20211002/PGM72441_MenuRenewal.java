package tues_thurs_sat._202110._20211002;
import java.util.*;

public class PGM72441_MenuRenewal {
    int target;
    int max;
    Map<String,Integer> map;
//    O(10000 log10000)
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq=new PriorityQueue<>();
        for(int i=0; i<course.length; i++){
            map=new LinkedHashMap<>();
            target=course[i];
            max=0;
            for(int j=0; j<orders.length; j++){
                combination(0,0,"",orders[j]);
            }
            if(max>1){
                for(String key : map.keySet()){
                    int orderCnt=map.get(key);
                    if(orderCnt==max){
                        pq.offer(key);
                    }
                }
            }
        }
        String[] answer = new String[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            answer[idx++]=pq.poll();
        }
        return answer;
    }
    private void combination(int cnt,int idx,String result,String order){
        if(cnt==target){
            char c[]=result.toCharArray();
            Arrays.sort(c);
            StringBuffer sb=new StringBuffer();
            for(char ch : c ){
                sb.append(ch);
            }
            String key=sb.toString();
            map.put(key,map.getOrDefault(key,0)+1);
            max=Math.max(max,map.get(key));
            return;
        }
        for(int i=idx; i<order.length();i++){
            combination(cnt+1,i+1,result+order.charAt(i),order);
        }
    }
}

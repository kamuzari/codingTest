package Programmers.LV2.MenuRenewal;
import java.util.*;
import java.util.stream.*;

public class MenuRenewal2 {
    Set<Character> menus=new HashSet<>(); // 단품메뉴들의 개수.
    List<Set<Character>> dList=new ArrayList<>(); // 사용자별 주문표.
    List<String> answers=new ArrayList<>();
    List<Character> candidate;
    Map<String,Integer> map;
    int max=0;
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){
            Set<Character> set=new HashSet<>();
            for(int j=0; j<orders[i].length(); j++){
                char ch=orders[i].charAt(j);
                set.add(ch);
                menus.add(ch);
            }
            dList.add(set);
        }
        // 주문이 들어온 단품메뉴들.
        candidate=menus.stream().collect(Collectors.toList()); // util.* 커버 안됨 ->
        for(int i=0; i<course.length; i++){
            int target=course[i];
            map=new HashMap<>();
            comb(0,0,target,new TreeSet<>());
            for(String key : map.keySet()){
                if(map.get(key)==max){
                    answers.add(key);
                }
            }
            max=0;
        }
        Collections.sort(answers);
        String answer[] =new String[answers.size()];
        int idx=0;
        for(String val:answers){
            answer[idx++]=val;
        }
        return answer;
    }
    public void comb(int cnt,int idx,int target,TreeSet<Character> pick){
        if(cnt==target){
            int count=0;
            for(Set<Character> sub:dList){
                if(sub.containsAll(pick)){
                    count++;
                }
            }
            if(count>1){
                StringBuilder sb=new StringBuilder();
                for(Character ch : pick){
                    sb.append(ch);
                }
                max=Math.max(count,max);
                String key=sb.toString();
                map.put(key,count);
            }
            return;
        }
        for(int i=idx; i<candidate.size(); i++){
            char menu= candidate.get(i);
            pick.add(menu);
            comb(cnt+1,i+1,target,pick);
            pick.remove(menu);
        }
    }
}

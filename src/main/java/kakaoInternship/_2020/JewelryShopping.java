package kakaoInternship._2020;

import java.util.*;

public class JewelryShopping {
    public static void main(String[] args) {
        String gems[]={"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String gems2[]={"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(solution(gems2)));
    }
    public static int[] solution(String[] gems) {
        Set<String> set=new LinkedHashSet<>();
        Map<String,Integer> map=new LinkedHashMap<>();

        for (String gem : gems) {
            set.add(gem);
        }
        int totalCnt=set.size();
        set.clear();
        int l=0;
        int start=0;
        Queue<String> q=new LinkedList<>();
        int len=gems.length;
        for(int i=0; i<gems.length;i++)
        {
            String str=gems[i];
           map.put(str,map.getOrDefault(str,0)+1);
           q.offer(str);
           while (true)
           {
               String s=q.peek();
               if(map.get(s)>1)
               {
                   q.poll();
                   l++;
                   map.put(s,map.get(s)-1);
               }
               else
                   break;
           }
           if(map.size()== totalCnt && len>q.size())
           {
               len=q.size();
               start=l;
           }
        }
        int []answer={start+1,start+len};
        map.clear();
        return answer;
    }

}

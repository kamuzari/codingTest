package programmers.lv2.VowelDictionary;
import java.util.*;
public class VowelDictionary {
    // 완전 탐색.
    ArrayList<String> list=new ArrayList<>();
    String w[]={"A","E","I","O","U"};
    int target;
    final static int MAX_LENTH = 5;
    public int solution(String word) {
        int answer = 0;
        // System.out.println(Math.pow(5,5)> 100_000_000 ? "TLE" : "PASS");

        for(int i=1; i<=MAX_LENTH; i++)
        {
            target=i;
            pick(0,"");
        }
        Collections.sort(list);
        for(String val : list)
        {
            answer++;
            if(val.equals(word))
            {
                return answer;
            }
        }
        return -1;
    }
    public void pick(int cnt,String result)
    {
        if(cnt==target)
        {
            list.add(result);
            return;
        }
        for(int i=0; i<w.length; i++){
            pick(cnt+1,result+w[i]);
        }
    }
}

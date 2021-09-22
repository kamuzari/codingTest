package tues_thurs_sat._202109._20210921;

import java.util.*;

public class PGM84512_CollectionDictionary {
    ArrayList<String> results =new ArrayList<>();
    String w[]={"A","E","I","O","U"};
    int target;
    final int MAX_LENTH = 5;
    public int solution(String word) {
        int answer = 0;
        for(int i=1; i<=MAX_LENTH; i++)
        {
            target=i;
            pick(0,"");
        }
        Collections.sort(results);
        for(String val : results)
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
            results.add(result);
            return;
        }
        for(int i=0; i<w.length; i++){
            pick(cnt+1,result+w[i]);
        }
    }
}

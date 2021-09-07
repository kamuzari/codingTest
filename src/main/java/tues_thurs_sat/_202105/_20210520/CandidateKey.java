package tues_thurs_sat._202105._20210520;

import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    public static void main(String[] args) {

    }

    static String ref[][];
    static Set<Set<Integer>> candidates;
    static int target;
    static int n,answer;

    public int solution(String[][] relation) {
         answer = 0;
        ref=relation;
         n=relation[0].length;
         candidates=new HashSet<>();
        for (int i = 1; i <=n ; i++) {
            target=i;
            comb(0,0,new HashSet<>());
        }
        return answer;
    }
    static void comb(int idx,int cnt,Set<Integer> set)
    {
        if(cnt==target)
        {
            if(!isUnique(set))
            {
                return;
            }
            for (Set<Integer> candidate : candidates) {
                if(set.containsAll(candidate))
                {
                    return;
                }
            }
            candidates.add(set);
            answer++;
            return;
        }
        for (int i = idx; i < n; i++) {
            Set<Integer> args = new HashSet<>(set);
            args.add(i);
            comb(i+1,cnt+1,args);
        }
    }

    private static boolean isUnique(Set<Integer> set) {
        Set<String> list=new HashSet<>();
        for (int i = 0; i < ref.length; i++) {
            String temp="";
            for (Integer val : set) {
                temp+=ref[i][val];
            }
            if(!list.contains(temp))
            {
                list.add(temp);
            }
            else
                return false;
        }
        return true;
    }
}

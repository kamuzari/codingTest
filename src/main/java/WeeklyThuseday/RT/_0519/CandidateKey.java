package WeeklyThuseday.RT._0519;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    public static void main(String[] args) {
        String rel[][]={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(rel));
    }
    static int colLength;
    static ArrayList<Set<Integer>> candidateKeys;
    static Set<Integer> set=new HashSet<>();
    static String ref[][];
    static int asnwer;
    public static int solution(String[][] relation){
        asnwer=0;
        ref=relation;
        candidateKeys=new ArrayList<>();
         colLength = relation[0].length;
        for (int i = 1; i <=colLength ; i++) {
            comb(0,0,i,new HashSet<>());
        }
        return asnwer;
    }
    static void comb(int cnt,int idx,int target,Set<Integer> set)
    {
        if(target==cnt)
        {
            if(!isUnique(set))
                return;
            for (Set<Integer> key : candidateKeys) {
                if(set.containsAll(key))
                {
                    return;
                }
            }
            candidateKeys.add(set);
            asnwer++;
            return;
        }

        for (int i = idx; i <colLength; i++) {
            Set<Integer> newSet=new HashSet<>(set);
            newSet.add(i);
            comb(cnt+1,i+1,target,newSet);
        }
    }
    static boolean isUnique(Set<Integer> setlist)
    {
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < ref.length; i++) {
            String temp=""  ;
            for (Integer val : setlist) {
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
// 10,000 * 1,000 = 10,000,000
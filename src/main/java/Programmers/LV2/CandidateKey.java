package Programmers.LV2;
import java.util.*;
public class CandidateKey {
    Set<Set<Integer>> candidates=new HashSet<>();
    String rel[][];
    int row;
    int col;
    int answer;
    public int solution(String[][] relation) {
        rel=relation;
        row=rel.length;
        col=rel[0].length;
        for(int i=0; i<col; i++){
            comb(0,0,i+1,new HashSet<>());
        }
        return answer;
    }
    public void comb(int cnt,int idx,int target,HashSet<Integer> set){
        if(cnt==target){
            if(isUnique(set)){
                if(minimal(set)){
                    HashSet<Integer> candidate=new HashSet<>(set);
                    candidates.add(candidate);
                    answer++;
                }
            }
            return;
        }
        for(int index=idx; index<col; index++){
            if(!set.add(index)) continue;
            set.add(index);
            comb(cnt+1,index+1,target,set);
            set.remove(index);
        }
    }

    public boolean isUnique(Set<Integer> set){
        Set<String> UniqueValues=new HashSet<>();
        for(int i=0; i<row; i++){
            StringBuilder result=new StringBuilder();
            for(Integer idx : set){
                result.append(rel[i][idx]);
            }
            if(!UniqueValues.add(result.toString())){
                return false;
            }
        }
        return true;
    }

    public boolean minimal(Set<Integer> set){
        for(Set<Integer> candidate : candidates){
            if(set.containsAll(candidate)){
                // candidate 속성들이 뽑은 set에 모두 포함된 원소면 최소성 만족 X
                return false;
            }
        }
        return true;
    }
}

package Programmers.LV2;

import java.util.Set;
import java.util.HashSet;

public class SkillTree {
    /*
     := skill_trees 원소를 각 StringBuilrder에 담아 해당 스킬에 포함되지 않는다면 자리를 삭제한다.
        그리고 스킬 순서 비교.
    */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder result;
        Set<Character> charSets=new HashSet<>(); // 중복 없음 Set 사용
        for(int i=0; i<skill.length(); i++){
            charSets.add(skill.charAt(i));
        }
        for(String skillTree : skill_trees){
            result=new StringBuilder();
            for(int i=0; i<skillTree.length(); i++){
                char ch=skillTree.charAt(i);
                if(charSets.contains(ch)){
                    result.append(ch);
                }
            }
            if(skill.indexOf(result.toString())==0){
                answer++;
            }
        }
        return answer;
    }
}

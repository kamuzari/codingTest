package Programmers.ProgrammersKit.SummerIntern;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SkillTree {
    public static void main(String[] args) {
        String t[]={"BACDE", "CBADF", "AECB", "BDA"};
        String s="CBD";
        System.out.println(solution(s, t));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Integer,Character> map=new LinkedHashMap<>();
        Set<Character> set=new LinkedHashSet<>();
        for (int j = 0; j < skill.length(); j++) {
            map.put(j,skill.charAt(j));
            set.add(skill.charAt(j));
        }
        for (int i = 0; i < skill_trees.length; i++) {
            boolean flag=true;
            String s=skill_trees[i];
            int idx=0;
            for (int j = 0; j < s.length(); j++) {
                char ch=s.charAt(j);
                if(!set.contains(ch))
                    continue;

                if(map.get(idx)==ch) {
                    idx++;
                    continue;
                }
                flag=false;
                break;
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}

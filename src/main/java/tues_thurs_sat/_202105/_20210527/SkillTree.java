package tues_thurs_sat._202105._20210527;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Integer,Character> map=new LinkedHashMap<>();
        Set<Character> set=new LinkedHashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            map.put(i,skill.charAt(i));
            set.add(skill.charAt(i));
        }

        for (int i = 0; i < skill_trees.length; i++) {
            String s=skill_trees[i];
            int idx=0;
            boolean flag=true;
            for (int j = 0; j < s.length(); j++) {
                if(!set.contains(s.charAt(j)))
                {
                    continue;
                }

                if(map.get(idx)==s.charAt(j))
                {
                    idx++;
                }
                else
                {
                    flag=false;
                }
            }
            if(flag)
            {
                answer++;
            }
        }
        return answer;
    }
}

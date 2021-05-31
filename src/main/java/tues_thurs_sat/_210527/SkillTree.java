package tues_thurs_sat._210527;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SkillTree {
    public static void main(String[] args) {

    }
    public static int solution(String skill, String[] skill_trees)
    {
        int answer=0;
        Map<Integer,Character> map=new HashMap<>();
        Set<Character> set=new LinkedHashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            map.put(i,skill.charAt(i));
            set.add(skill.charAt(i));
        }
        for (int i = 0; i < skill_trees.length; i++) {
            boolean flag=true;
            String s=skill_trees[i];
            int idx=0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(!set.contains(ch))
                {
                    continue;
                }
                if(map.get(idx)==ch)
                {
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

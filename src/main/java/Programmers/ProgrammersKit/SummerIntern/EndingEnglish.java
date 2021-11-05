package Programmers.ProgrammersKit.SummerIntern;

import java.util.LinkedHashSet;
import java.util.Set;

public class EndingEnglish {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set=new LinkedHashSet<>();
        char previous='_';
        int seq,idx;
        for (int i = 0; i < words.length; i++) {
            if(previous=='_'|| previous==words[i].charAt(0)) {
                if (!set.contains(words[i])) {
                    set.add(words[i]);
                    previous=words[i].charAt(words[i].length()-1);
                }
                else
                {
                    return new int[]{i%n+1,i/n+1};
                }
            }
            else
            {
                return new int[]{i%n+1,i/n+1};
            }
        }

        return new int[]{0,0};
    }

}

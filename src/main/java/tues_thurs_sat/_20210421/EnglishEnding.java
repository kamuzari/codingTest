package tues_thurs_sat._20210421;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class EnglishEnding {
    public static void main(String[] args) {
        String w1[]={"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String w2[]={"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String w3[]={"hello", "one", "even", "never", "now", "world", "draw"};

//        System.out.println(Arrays.toString(solution(3,w1)));
//        System.out.println(Arrays.toString(solution(5,w2)));
        System.out.println(Arrays.toString(solution(2,w3)));

    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set=new LinkedHashSet<>();
        String pre=words[0];

        int idx=0;
        set.add(pre);
        int cnt=1;
        boolean flag=true;

        for (int i = 1; i < words.length; i++) {
            if(i%n==0)
                cnt++;

            if(!set.contains(words[i])&&pre.charAt(pre.length()-1)==words[i].charAt(0))
            {

                set.add(words[i]);
            }
            else if(set.contains(words[i]))
            {
                idx=i%n+1;
                flag=false;
                break;
            }
            else {
                idx=i%n+1;
                flag=false;
                break;
            }
            pre=words[i];

        }
        if(!flag) {
            answer[0] = idx;
            answer[1] = cnt;
        }
        return answer;
    }
}

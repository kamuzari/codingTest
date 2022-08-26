package programmers.lv2;
import java.util.*;
public class EnglishWord_endToEnd {
    Set<String> wordSet=new HashSet<>();
    public int[] solution(int n, String[] words) {
        String prev="";
        int loop=0;
        for(int i=0; i<words.length; i++){
            boolean nextPossible=true;
            if(!prev.equals("")){
                char prevCh=prev.charAt(prev.length()-1);
                if(prevCh!=words[i].charAt(0) || wordSet.contains(words[i])) {
                    return new int[]{i%n+1,i/n+1};
                }
            }
            prev=words[i];
            wordSet.add(words[i]);
        }
        return new int[]{0,0};
    }
}

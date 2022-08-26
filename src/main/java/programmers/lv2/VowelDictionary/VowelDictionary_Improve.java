package programmers.lv2.VowelDictionary;
import java.util.*;
public class VowelDictionary_Improve {
    String str[]={"A","E","I","O","U"};
    List<String> results=new ArrayList<>();
    public int solution(String word) {
        improvePick(0,"");
        return results.indexOf(word);
    }
    public void improvePick(int cnt,String result){
        if(cnt>5) return;
        results.add(result);
        for(int i=0; i<5;i++){
            improvePick(cnt+1,result+str[i]);
        }
    }
}

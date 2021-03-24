import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex {
    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    private static Map<String,Integer> wordPrefix(){
        Map<String ,Integer> wordCountMap=new HashMap<>();
        String prefix;
        Integer cnt;
        for (String word : WORDS) {
            prefix=word.substring(0,1);
            cnt=wordCountMap.get(prefix);
            if(cnt==null)
                wordCountMap.put(prefix,1);
            else
                wordCountMap.put(prefix,cnt+1);
        }
        return wordCountMap;
    }
    private static Map<String,Integer> Func_wordPrefix(){
        Map<String ,Integer> wordCountMap=new HashMap<>();
       WORDS.stream().map(s -> s.substring(0,1)).forEach(s -> wordCountMap.merge(s,1,(o,n)->n+=o));
       return wordCountMap;
    }

    public static void main(String[] args) {
        final Map<String,Integer> map=wordPrefix();
        map.keySet().forEach((String m) -> System.out.println(map.get(m)));
        System.out.println(map);

        final Map<String ,Integer> map2=Func_wordPrefix();
        map.keySet().forEach((String m)-> System.out.println(map.get(m)));
    }
}

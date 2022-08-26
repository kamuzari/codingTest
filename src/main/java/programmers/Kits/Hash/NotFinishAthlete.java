package programmers.Kits.Hash;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class NotFinishAthlete {
    public static void main(String[] args) {
        String p[]={"leo", "kiki", "eden"};
        String c[]={"eden", "kiki"};
        System.out.println(solution(p,c));
    }

    public static String solution(String[] participant, String[] completion)
    {
        String answer="";
        HashMap<String ,Integer> map=new LinkedHashMap<>();
        for (String s : participant) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String s : completion) {
            if(map.get(s)!=0&&map.containsKey(s))
            {
                map.put(s,map.get(s)-1);
                if(map.get(s)==0)
                    map.remove(s);
            }
        }
        for (String s : map.keySet()) {
            return s;
        }
        return "";
    }
}

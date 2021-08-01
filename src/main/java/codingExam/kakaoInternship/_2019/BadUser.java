package codingExam.kakaoInternship._2019;

import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser {

    public static void main(String[] args) {
        String s[]={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String s2[]={"*rodo", "*rodo", "******"};
        System.out.println(solution(s,s2));
    }
    static Set<Set<String>> ans=new LinkedHashSet<>();
    static String user[],ban[];
    public static int solution(String[] user_id, String[] banned_id) {

        user=user_id;
        ban=banned_id;
        pick(new LinkedHashSet<>());
        System.out.println(ans);
        return ans.size();
    }

    static void pick(Set<String> set)
    {
        if(set.size()==ban.length)
        {
            if(isBanId(set))
            {
                ans.add(new LinkedHashSet<>(set));
            }
            return;
        }
        for (String s : user) {
            if(!set.contains(s))
            {
                set.add(s);
                pick(set);
                set.remove(s);
            }
        }
    }

    private static boolean isBanId(Set<String> set) {
        int i=0;
        for (String s : set) {
            if(!isSame(s,ban[i++]))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isSame(String setElement, String banId) {
        if(setElement.length()!=banId.length())
            return false;
        for (int i = 0; i < banId.length(); i++) {
            if(banId.charAt(i)=='*')
                continue;
            if(setElement.charAt(i)!=banId.charAt(i))
                return false;
        }
        return true;

    }

}

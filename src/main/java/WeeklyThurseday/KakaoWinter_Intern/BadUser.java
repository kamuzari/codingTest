package WeeklyThurseday.KakaoWinter_Intern;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser {
    public static void main(String[] args) {
        String u[]={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String b[]={"fr*d*", "*rodo", "******", "******"};
        int x=solution(u,b);
        System.out.println(x);

    }
    static private Set<Set<String>> ans;

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ans = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return ans.size();
    }

    static void dfs(String[] userId, String[] banId, Set<String> set) { // 되는 대로 집어넣기 (완전 탐색)
        if (set.size() == banId.length) {
            if (isBanUser(set, banId))
                ans.add(new HashSet<>(set));
            return;
        }
        for(String userid:userId){
            if(!set.contains(userid))
            {
                set.add(userid);
                dfs(userId,banId,set);
                set.remove(userid);
            }
        }
    }

    static boolean isBanUser(Set<String> s, String[] banId) { // 내가 set에 넣은 userId가 bannedId목록에 있는 것과 같은지 정확한 비교.
        int i = 0;
        for (String user : s) {
            if (!IsSameString(user, banId[i++]))
                return false;
        }
        return true;
    }
    // 세밀한 문자 판별.
    static boolean IsSameString(String a,String b)
    {
        if(a.length()!=b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if(b.charAt(i)=='*')
                continue;
            if(a.charAt(i)!=b.charAt(i))
                return false;
        }
        return true;
    }
}

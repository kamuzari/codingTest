package tues_thurs_sat._202105._20210527;

import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser {
    public static void main(String[] args) {
        String u[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String b[] = {"fr*d*", "abc1**"};
        String b2[] = {"*rodo", "*rodo", "******"};
        String b3[] = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(u, b3));
    }
    static Set<Set<String>> result=new LinkedHashSet<>();
    static Set<String> set = new LinkedHashSet<>();
    static String userId[];
    static String banId[];
    static int answer;

    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        userId = user_id;
        banId = banned_id;
        pick(0, 0);
        System.out.println(result);
        return result.size();
    }

    static void pick(int cnt, int idx) {
        if (cnt == banId.length) {
            if (isBan()) {
                System.out.println(set);
                result.add(new LinkedHashSet<>(set));

                answer++;
            }
            return;
        }
        for (int i = 0; i < userId.length; i++) {
            if (!set.contains(userId[i])) {
                set.add(userId[i]);
                pick(cnt + 1, i + 1);
                set.remove(userId[i]);
            }
        }
    }

    static boolean isBan() {
        int idx = 0;
        for (String s : set) {
            if (!isEqual(idx, s)) {
                return false;
            }
            idx++;
        }
        return true;
    }

    static boolean isEqual(int idx, String value) {
        String target = banId[idx];
        if (value.length() != target.length())
            return false;
        for (int i = 0; i < value.length(); i++) {
            if (target.charAt(i) == '*')
                continue;
            else if (target.charAt(i) != value.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

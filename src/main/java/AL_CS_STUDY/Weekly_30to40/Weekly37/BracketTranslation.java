package AL_CS_STUDY.Weekly_30to40.Weekly37;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
public class BracketTranslation {
    public static String solution(String p) {
        String ans = "";
        if (p.equals(""))
            return p;
        int idx = isBalanced(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if (isValid(u))
            return u+solution(v);
        else
        {
            ans+="("+solution(v)+")";
            for (int i = 1; i < u.length()-1; i++) {
                char c = u.charAt(i);
                if(c==')')
                    ans+='(';
                else
                    ans+=')';
            }
            return ans;
        }
    }

    static int isBalanced(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                cnt++;
            else {
                cnt--;
            }
            if (cnt == 0)
                return i;
        }
        return -1;
    }

    static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(')
                s.push(c);
            else if (!s.isEmpty() && c == ')')
                s.pop();
            else {
                return false;
            }
        }
        return s.isEmpty();
    }
}

package WeeklyThuseday.Random;

public class Parentheses_conversion {
    public static void main(String[] args) {
        String s="()))((()"		;
        String k=solution(s);
        System.out.println(k);

    }
    public static String solution(String p) {
        if(p.equals(""))
            return p;
        int position=isBalaning(p);
        String u=p.substring(0,position+1);
        String v=p.substring(position+1);
        if(isCorrect(u)) {
            return u+solution(v);
        }

        else{
            String answer="";
            answer = "(" + solution(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == ')')
                    answer += '(';
                else
                    answer += ')';
            }
            return answer;
        }
    }
    static int isBalaning(String p)
    {
        int cnt=0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='(')
                cnt++;
            else
                cnt--;
            if(cnt==0)
            {
                return i;
            }
        }
        return -1;
    }
    static boolean isCorrect(String p)
    {
        int cnt=0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='(')
                cnt++;
            else
            {
                if(cnt==0)
                    return false;
                cnt--;
            }
        }
        return true;
    }
}

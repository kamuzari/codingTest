package oneDay_twoSol.DB_FirstSearch;

public class Bracket_Conversion {
    public static void main(String[] args) {
//        String ans=solution("(()())()");
        String ans2=solution("()))((()");
        System.out.println(ans2);
    }
    // u,v 로 분리?  문제 이해 x

    public static String solution(String p) {

        if(p.equals(""))
            return p;
        int balanced= isBalanced_bracket(p);
        String u=p.substring(0,1+balanced);
        String v=p.substring(1+balanced);
        String answer = "";
        // 여기까지가 균형잡힌 괄호형.

        // 균형잡힌거 인증되었으니 올바른지까지 확인해야함.
        if(Correct_bracket(u))
            return u+solution(v); // 수행한 결과 u에 이어붙인다.   <꼬리 재귀.>
        else // 문자열 u가 "올바른 괄호"문자열이 아니라면.
        {
            answer="("+solution(v)+")";
            for (int i = 1; i <u.length()-1; i++) {
                if(u.charAt(i)=='(')
                    answer+=")";
                else
                    answer+="(";
            }
            return answer;
        }
    }
    // 정확환 괄호 표현법인지 확인하는 메소드이다.
    private static boolean Correct_bracket(String u) {
        int cnt=0;
        for (int i = 0; i < u.length(); i++) {

            if(u.charAt(i)=='(')
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
    // 이 메소드는 괄호의 개수 '(' 와 ')' 의 개수만 맞으면 된다.
    private static int isBalanced_bracket(String p) {
        int cnt=0;

        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='(')
                cnt++;
            else
                cnt--;
            if(cnt==0)
                return i;
        }
        return -1;
    }
}

package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String brackets[]=new String[n];
        for (int i = 0; i < n; i++) {
            brackets[i]=br.readLine();
        }
//        solution(brackets, sb);
        refactorSolution(brackets,sb);

        System.out.println(sb);
    }

    private static void solution(String brackets[], StringBuilder sb) {
        for (int i = 0; i < brackets.length; i++) {
            String str = brackets[i];
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') {
                    s.push(ch);
                } else if (ch == ')') {
                    if (s.isEmpty()) {
                        flag = false;
                        break;
                    } else if (s.peek() == '(')
                        s.pop();
                }
            }

            if (s.isEmpty() && flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
    }
    /*
    - if 문의 제약 조건도 시간의 차이가 크다. (if 문의 안에 조건이 많으면 많을 수록 시간이 더 걸린다.
    - stack의 자료구조 특성을 이용하면 구현은 간단하다. 하지만 stack을 굳이 이용하지 않고 +- 연산으로 올바른 괄호인지 구하면 1.7배 가량 빠르다.
    */
    private static void refactorSolution(String brackets[], StringBuilder sb) {
        for (int i = 0; i < brackets.length; i++) {
            String str = brackets[i];
            int l=0;
            for (int j = 0; j <str.length() ; j++) {
                char ch = str.charAt(j);
                if(ch=='(')
                    l++;
                else if(l>0 &&ch==')')
                    l--;
                else
                    l-=9999;
            }

            if (l==0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
    }


}

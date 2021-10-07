package tues_thurs_sat._202110._20211005;

import java.util.*;

public class PGM76502_BracketRotate {
    public static void main(String[] args) {
        PGM76502_BracketRotate p = new PGM76502_BracketRotate();
        System.out.println(p.solution("[](){}"));
    }

    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int startIdx = i;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            while (cnt < n) {
                char ch = s.charAt(startIdx++);
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        if (stack.peek() == '[' && ch == ']') {
                            stack.pop();
                        } else if (stack.peek() == '{' && ch == '}') {
                            stack.pop();
                        } else if (stack.peek() == '(' && ch == ')') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                System.out.println(stack);
                startIdx = startIdx % n;
                cnt++;
            }
            if (flag && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}

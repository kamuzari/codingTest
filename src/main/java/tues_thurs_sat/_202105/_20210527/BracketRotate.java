package tues_thurs_sat._202105._20210527;

import java.util.Stack;

public class BracketRotate {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int result = 0;
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '[')
                    stack.push(s.charAt(j));
                else if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek == '[' && s.charAt(j) == ']')
                        stack.pop();
                    else if (peek == '{' && s.charAt(j) == '}')
                        stack.pop();
                    else if (peek == '(' && s.charAt(j) == ')')
                        stack.pop();
                } else if (stack.isEmpty() || s.charAt(j) == ')' || s.charAt(j) == '}' || s.charAt(j) == ']') {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                continue;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '[')
                    stack.push(s.charAt(j));
                else if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek == '[' && s.charAt(j) == ']')
                        stack.pop();
                    else if (peek == '{' && s.charAt(j) == '}')
                        stack.pop();
                    else if (peek == '(' && s.charAt(j) == ')')
                        stack.pop();
                } else if (stack.isEmpty() || s.charAt(j) == ')' || s.charAt(j) == '}' || s.charAt(j) == ']') {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                continue;
            if (stack.isEmpty())
                answer++;
        }
        return answer;
    }
}

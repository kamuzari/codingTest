package Programmers.ProgrammersKit.Greedy;

import java.util.Stack;

public class MaxNumber {
    public static void main(String[] args) {
//        System.out.println(solution("1924", 2));
//        System.out.println(solution("1231234", 3));
//        System.out.println(solution("4177252841", 4));
        System.out.println(solution("12345678", 2));
    }

    public static String False_solution(String number, int k) {
        String ans = "";
        int sIdx = 0, maxIdx = 0;
        char maxVal = 0;
        for (int i = 0; i < number.length() - k; i++) {
            maxIdx = sIdx;
            maxVal = number.charAt(sIdx);
            for (int j = sIdx + 1; j <= i + k; j++) {
                if (maxVal < number.charAt(j)) {
                    maxVal = number.charAt(j);
                    maxIdx = j;
                }
            }
            sIdx = maxIdx + 1;
            ans += maxVal;

        }
        return ans;
    }

    public static String solution(String number, int k) {
        char[] ans = new char[number.length() - k];
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            while (!s.isEmpty() && s.peek() < ch && k-- > 0) {
                s.pop();
            }
            s.push(ch);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=s.get(i);
        }
        return new String(ans);
    }
}

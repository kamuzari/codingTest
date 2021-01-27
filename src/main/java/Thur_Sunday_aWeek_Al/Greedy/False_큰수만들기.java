package Thur_Sunday_aWeek_Al.Greedy;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/42883
public class False_큰수만들기 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 2;

        solution(number, 4
        );
    }

    public static String solution(String number, int k) {
        String answer = ""; // 매번 새로운 객체 생성으로 부하가 있으므로 builder 나 buffer(스레드 안전성) 권장.

        char[] arr=number.toCharArray();
//        System.out.println(Arrays.toString(arr));
        Stack<Character> s = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++) {
            while(!s.empty() && k > 0 && s.peek() < arr[i]) {
                k--;
                s.pop();
            }
            s.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        // k개를 삭제하지 못 한 경우 뒤에서 부터 제거.
        while(!s.empty()) {
            if(k != 0) {
                s.pop();
                k--;
            }else {
                sb.append(s.pop());
            }
        }
        return sb.reverse().toString();
    }
}

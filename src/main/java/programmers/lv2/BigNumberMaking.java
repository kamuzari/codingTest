package programmers.lv2;

import java.util.Stack;

public class BigNumberMaking {
    public static String solution(String number, int k) {
        Stack<Integer> s = new Stack<>();
        int n=number.length();
        int answerSize=n-k;
        for (int i = 0; i < n; i++) {
            int ch = number.charAt(i)-'0';
            while (!s.isEmpty() && s.peek() < ch && k > 0) {
                s.pop();
                k--;
            }
            s.push(ch);
        }
        StringBuilder answer=new StringBuilder();
       /* 맞는 코드  :  차이점 ..
       `for(int i=0; i<answerSize; i++){
                 answer.append(s.get(i));
         }
         int idx=0;
         while(idx<answerSize){
             answer.append(s.get(idx++));
         }
       */

      /* 틀린 코드 : 주의 **
         test Case 12 번 걸림...?  (why .? ) -- >  pop()을 뒤에서 부터 하면 큰게 잘려나간다... 이미 앞에 있는 선택받은 숫자들은 가장 큰수들로 이루어진 것.
         for(int i=0; i<answerSize; i++){
             answer.append(s.pop());
         }
      */

        while(!s.isEmpty()){
            if(k>0) {
                k--;
                s.pop(); continue;
            }
            answer.append(s.pop());
        }
        return answer.reverse().toString();
    }
}

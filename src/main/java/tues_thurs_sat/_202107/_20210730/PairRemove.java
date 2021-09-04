package tues_thurs_sat._20210730;

import java.util.Stack;

public class PairRemove {
    public static void main(String[] args) {

    }
    // RT, notEfficient
    public static int fSolution(String s)
    {
        boolean answer=false;
        int idx=0;
        for (int i = 0; i < s.length()-1; i++) {
            if(i<0)
                i=0;
               if(s.charAt(i)==s.charAt(i+1))
               {
                   s=s.substring(0,i)+s.substring(i+2); // 2*n
                   i-=2;
               }
        }
        if(s.equals(""))
            answer=true;

        return answer?1:0;
    }

    public static int solution(String s)
    {
        boolean answer=false;
        Stack<Character> stack=new Stack<>()    ;
        for (char ch : s.toCharArray()) {
            if(!stack.isEmpty())
            {
                if(stack.peek()==ch)
                    stack.pop();
                else
                    stack.push(ch);
            }
            else
            {
                stack.push(ch);
            }
        }
        return stack.isEmpty()?1:0;
    }

}

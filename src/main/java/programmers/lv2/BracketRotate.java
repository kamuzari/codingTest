package programmers.lv2;

import java.util.*;

public class BracketRotate {
    //   다 여는 괄호만 들어올 경우 check
    public int solution(String s) {
        int answer = 0;
        int n=s.length();
        for(int startIdx=0; startIdx<n; startIdx++){
            Stack<Character> stack=new Stack<>();
            int cnt=0;
            boolean flag=true;
            for(int start=startIdx; cnt<n; start=(start+1)%n){
                if(cnt==n) break;
                char ch=s.charAt(start);
                if(ch=='(' || ch=='[' || ch=='{') stack.push(ch);
                else{
                    if(stack.isEmpty()) {
                        flag=false;
                        break;
                    }else if(isEqualShape(ch,stack)){
                        stack.pop();
                    }else {
                        flag=false;
                        break;
                    }
                }
                cnt++;
            }

            if(!flag || !stack.isEmpty()) continue;
            else answer++;
        }
        return answer;
    }
    public boolean isEqualShape(char cur,Stack<Character> s){
        if(s.peek()=='(' && cur==')') return true;
        else if(s.peek()=='[' && cur==']') return true;
        else if(s.peek()=='{' && cur=='}') return true;
        else return false;
    }
}

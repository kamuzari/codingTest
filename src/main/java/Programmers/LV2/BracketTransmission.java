package Programmers.LV2;
import java.util.*;

public class BracketTransmission {
    final char open='(';
    final char close=')';
    public String solution(String p) {
        String answer="";
        if(p.equals("")){
            return "";
        }
        int retIdx=isBalanced(p);

        String u=p.substring(0,retIdx);
        String v=p.substring(retIdx,p.length());
        if(isProper(u)){
            return u+solution(v);
        }else{
            answer="("+solution(v)+")";
            for(int i=1; i<u.length()-1; i++){
                char ch =u.charAt(i);
                answer+=(ch==open ? close : open);
            }
            return answer;
        }
    }
    public  boolean isProper(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch==open){
                s.push(open);
            }

            if(!s.isEmpty() && ch==close) {
                s.pop();
            }
        }
        return s.isEmpty();
    }
    public  int isBalanced(String str){
        int cnt=0;
        for(int i=0; i<str.length(); i++){
            char cur=str.charAt(i);
            if(open==cur){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                return i+1;
            }
        }
        return -1;// 이런 입력은 안주어짐..
    }
}

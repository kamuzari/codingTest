package Basic.StackAndQueue;

import java.util.*;
import java.io.*;

public class BOJ11899_BracketPut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int answer=0;
        for (int i = 0; i < str.length(); i++) {
            final char ch = str.charAt(i);
            if(!s.isEmpty() && ch==')')
            {
                s.pop();
            }
            else if(ch==')'){
                answer++;
            }else if(ch=='(')
            {
                s.push(ch);
            }
        }

        System.out.println(answer+s.size());
    }
}

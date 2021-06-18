package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LaserPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ch = str.replace("()", "|").toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            s.push(ch[i]);
        }
        int size=s.size();
        int stickCnt=0;
        int answer=0;
        for (int i = 0; i < size; i++) {
            Character pop = s.pop();
            if(pop==')')
            {
                stickCnt++;
            }
            else if(pop=='(')
            {
                stickCnt--;
                answer++;
            }

            if(pop=='|')
                answer+=stickCnt;
        }

        System.out.println(answer);
    }
}

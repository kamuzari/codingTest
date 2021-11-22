package Basic.SolvedAC4;

import java.io.*;
import java.util.*;

public class BOJ1918_InfixToPostFIxNotation {
    //1.숫자가 들어오면 그대로 출력 , 나머지는 우선순위와 괄호를 통해 적절히 출력.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> operations = new Stack<>(); // '(' ,')' 도 들어감.
        char exp[] = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] >= 'A' && exp[i] <= 'Z') answer.append(exp[i]);
            else {
                if (exp[i] == '('){
                    operations.push(exp[i]);
                }else if(exp[i]==')'){
                    while(!operations.isEmpty() && operations.peek()!='('){
                        answer.append(operations.pop());
                    }
                    if(operations.peek()=='(') operations.pop();
                }else  {
                    // '+' '*' '-' '/' 일 때,
                    while (!operations.isEmpty() && priority(operations.peek())>=priority(exp[i])){
                        // 스택안에 있는 연산자 우선순위 보다 작은 연산자가 들어온다면 pop();
                        answer.append(operations.pop());
                    }
                    operations.push(exp[i]);
                }
            }
        }
        while (!operations.isEmpty()){
            answer.append(operations.pop());
        }
        System.out.println(answer.toString());

    }
    public static int priority(char op){
        if(op =='*' || op=='/') return 2;
        else if(op=='+' || op=='-') return 1;
        else if(op=='(' || op==')')return 0; // '(' , ')'
        else return -1;
    }
}

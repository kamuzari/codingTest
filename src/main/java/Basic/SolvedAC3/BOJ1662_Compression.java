package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1662_Compression {
    static int[] closedIdx =new int[50];
    private static String compression;
    // closedIdx closedIdx[여는 괄호 index] = 닫히는 괄호의 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        compression = br.readLine();
        Stack<Integer> stack =new Stack<>() ;

        for (int i = 0; i < compression.length(); i++) {
            if(compression.charAt(i)=='(') stack.push(i);
            else if(compression.charAt(i)==')'){
                closedIdx[stack.pop()]=i;
            }
        }
        System.out.println(recursion(0,compression.length()));

    }
    static int recursion(int s,int e){
        int len=0;
        for (int i = s; i < e; i++) {
            if(compression.charAt(i)=='('){
                len+=(compression.charAt(i-1)-'0')*recursion(i+1, closedIdx[i])-1;
                i=closedIdx[i];
            }else if(compression.charAt(i)!=')'){
                len++;
            }
        }
        return len;
    }
}

package Basic.StackAndQueue;

import java.io.*;
import java.util.*;

public class BOJ12605_WordOrderingReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<String> s = new Stack<>();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < testCase; i++) {
            String input[]=br.readLine().split(" ");
            sb.append("Case #").append(i+1).append(":");
            for (int j = 0; j < input.length; j++) {
                s.push(input[j]);
            }
            while (!s.isEmpty()) {
               sb.append(" ").append(s.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

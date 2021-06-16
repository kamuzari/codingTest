package Basic.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence {
    public static void main(String args[]) {
        ArrayList<Character> ans=new ArrayList<Character>();
        Stack<Integer> s = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = 0;
        while (N--> 0) {
            int in = sc.nextInt();
            if (in > k) {
                while (k < in) {
                    s.push(++k);
                    ans.add('+');
                }
                s.pop();
                ans.add('-');
            }
            else {
                boolean flag = false;
                if(!s.isEmpty())
                {
                    int peek=s.pop();
                    ans.add('-');
                    if(in==peek)
                    {
                        flag=true;
                    }
                }
                if(!flag)
                {
                    System.out.print("NO");
                    return;
                }
            }
        }
        for (char c:ans) {
            System.out.println(c);
        }
    }
}
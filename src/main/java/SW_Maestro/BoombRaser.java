package SW_Maestro;

import java.util.Scanner;
import java.util.Stack;

public class BoombRaser {
    static Stack<Character> s=new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[]=sc.nextLine().toCharArray();
        System.out.println(solution(ch));
    }
    public static String  solution(char ch[])
    {
        int left=0;
        int right=0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='(')
                left++;
            else
                right++;
        }
        if(left==right)
            return "YES";
        else
            return "NO";
    }
}

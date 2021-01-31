package Thur_Sunday_aWeek_Al.StringProblem;

import java.util.Scanner;

public class lostParenthesis {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("-");

        int result=0;
        for (int i = 0; i < str.length; i++) {
            int ans=plus(str[i]);

            if(i==0)
                ans*=-1;
            result-=ans;
        }
        System.out.println(result);

    }
    public static int plus(String str)
    {
        String sub[]=str.split("\\+");
        int n=0;
        for (String s:sub) {
            n+=Integer.parseInt(s);
        }
        return n;
    }
}

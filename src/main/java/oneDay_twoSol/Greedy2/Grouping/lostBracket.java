package oneDay_twoSol.Greedy2.Grouping;

import java.util.Scanner;

public class lostBracket {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("-");
        int res=0;
        for (int i = 0; i < str.length; i++) {
            int ans=plus(str[i]);
            if(i!=0)
                ans*=-1;
            res+=ans;
        }
        System.out.println(res);
    }
    public static int plus(String str)
    {
        int ans=0;
        String temp[]=str.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            ans+=Integer.parseInt(temp[i]);
        }
        return ans;
    }
}

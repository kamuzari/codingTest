package WeeklyThuseday.maestroReady;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        sc.nextLine();
        while(t-->0)
        {
            String str=sc.nextLine();
            char ch[]=str.toCharArray() ;
            int ans=isPalindrome(ch);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static int isPalindrome(char[] ch)
    {
        int ans=0;
        int L=0;
        int R=ch.length-1;
        while (L<=R)
        {
            if(ch[L]==ch[R])
            {
                L++;
                R--;
            }
            else
            {
                int l=L+1;
                int r=R;
                while (l<=r)
                {
                    if(ch[l]==ch[r])
                    {
                        l++;
                        r--;
                    }
                    else {
                        ans++;
                        break;
                    }
                }
                l=L;
                r=R-1;
                while (l<=r)
                {
                    if(ch[l]==ch[r])
                    {
                        l++;
                        r--;
                    }
                    else {
                        ans++;
                        break;
                    }
                }
                return ans;
            }
        }
        return ans;
    }
}

package Thur_Sunday_aWeek_Al.SW_MaestroReady;

import java.util.Scanner;

public class goodSequence {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lowSequence("");
    }

    private static void lowSequence(String s) {
        if (s.length() == n)
        {
            System.out.println(s);
            System.exit(0);
            return;
        }
        else
        {
            for (int i = 1; i <=3; i++) {
                if(isGood(s+i))
                {
                    lowSequence(s+i);
                }
            }
        }
    }

    private static boolean isGood(String s) {
        int len=s.length()/2;
        for (int i = 1; i <=len ; i++) {
            if(s.substring(s.length()-i).equals(s.substring(s.length()-2*i,s.length()-i)))
            {
                return false;
            }
        }
        return true;
    }
}

package Thur_Sunday_aWeek_Al.SW_MaestroReady;

import java.util.Scanner;

public class goodSequence {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lowSequence("");

//        System.out.println(isGood("33"));
//        System.out.println(isGood("32121323"));
//        System.out.println(isGood("123123213"));
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
            String front=s.substring(s.length()-2*i,s.length()-i);
            String behind=s.substring(s.length()-i,s.length());
            if(front.equals(behind))
                return false;
        }
        return true;
    }
}

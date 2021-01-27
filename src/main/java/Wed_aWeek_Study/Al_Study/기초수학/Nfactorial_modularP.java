package Wed_aWeek_Study.Al_Study.기초수학;

import java.util.Scanner;

public class Nfactorial_modularP {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        long n=Long.parseLong(str[0]);
        long m=Long.parseLong(str[1]);

        System.out.println(factorial(n,m));
    }

    static long factorial(long n,long m)
    {
        long fact=1;
        for (int i = 2; i <=n ; i++) {
            fact*=i;
            fact%=m;
        }
        return fact;
    }
}

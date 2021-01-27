package Wed_aWeek_Study.Al_Study.기초수학;

import java.util.Scanner;

public class 최대공약수_최소공배수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a;
        if(n>m)
        {
            a=gcd(n,m);
            System.out.println(a);
            System.out.println(lcm(n,m,a));
        }
        else
        {
            a=gcd(m,n);
            System.out.println(a);
            System.out.println(lcm(m,n,a));
        }


    }
    static int gcd(int a,int b)
    {
        while (b>0)
        {
            int tmp=a;
            a=b;
            b=tmp%b;
        }
        return a;
    }
    static int lcm(int a,int b,int gcd)
    {
        return (a*b)/gcd;
    }
    static void swap(int a,int b)
    {
        int temp=a;
        a=b;
        b=temp;
    }
}

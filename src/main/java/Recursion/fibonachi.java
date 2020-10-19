package Recursion;

import java.util.Scanner;

public class fibonachi {
    // 메모이제이션 적용하지 않은 일반적인 재귀형식의 피보나치.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibo(n));


    }
    static int fibo(int n)
    {
        if(n<0)
            return 0;
        else if (n==1)
        {
            return 1;
        }
        return fibo(n-1)+ fibo(n-2);
    }
}

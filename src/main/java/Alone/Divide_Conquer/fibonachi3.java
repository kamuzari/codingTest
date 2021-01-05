package Alone.Divide_Conquer;

import java.util.Scanner;

public class fibonachi3 {
//    주기의 길이가 P면,
//    N번째 피보나치 수를 M으로 나눈 나머지는
//    N%P번째 피보나치 수를 M으로 나눈 나머지와 같다.
    // # 공식 #
//    모듈러가 10^k (k > 2) 주기는 15 * 10^(k - 1) 이다.
    static int mod=1000000;
    public static long p = mod / 10 * 15;
    static int [] fibo;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        fibo=new int[(int)p];
        fibo[0]=0;
        fibo[1]=1;
        System.out.println(fibo3(n));

    }

    public static int fibo3(long n)
    {
        for (int i = 2; i <p ; i++) {
            fibo[i]=fibo[i-1]+fibo[i-2];
            fibo[i]%=mod;
        }
        n=n%p;
        return fibo[(int)n];
    }

}

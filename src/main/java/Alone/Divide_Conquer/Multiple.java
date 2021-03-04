package Alone.Divide_Conquer;

import java.util.Scanner;

public class Multiple {
    static int c;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(POW(a, b));
    }

    public static long POW(int a, int n) {
        if (n == 0)
            return 1;
        long k = POW(a, n / 2);
        long temp = k * k % c;
        if (n % 2 == 0)
            return temp;
        else
            return a*temp % c;
    }

    public static int refactoring_pow(int a, int n) {
        if (n == 0)
            return 1;
        int k = refactoring_pow(a, n / 2);
        int temp = k * k;
        if (n % 2 == 1)
            return a * temp;
        else
            return temp;
    }

    public static int log_pow(int a, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0) {
            int k = log_pow(a, n / 2);
            return k * k;
        } else {
            int k = log_pow(a, (n - 1) / 2);
            return a * k * k;
        }
    }

    // 일반적인 o(n)인 선형시간 복잡도.
    public static int Loop_pow(int a, int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= a;
        }
        return res;
    }

    public static int Recursion_pow(int a, int n) {
        if (n == 0)
            return 1;
        return a * Recursion_pow(a, n - 1);
    }
}

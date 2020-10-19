package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        // 주의 값의 범위중 0값을 잘 처리합니다.
        Scanner sc = new Scanner(System.in);
        int fact = 1;
        int n = sc.nextInt();

        System.out.println(factorial(n));
//        for (int i = 1; i <=n ; i++) {
//            fact*=i;
//        }
//        System.out.println(fact);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}

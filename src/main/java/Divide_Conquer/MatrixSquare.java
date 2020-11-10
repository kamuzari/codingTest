package Divide_Conquer;

import java.util.Scanner;

public class MatrixSquare {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 행열의 값
        long b = sc.nextLong(); // 지수
        sc.nextLine();
        long arr[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        long [][]res=new long[n][n] ;
       res = divide(arr, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] % 1000 +" ");
            }
            System.out.println();
        }
    }

    public static long[][] divide(long[][] arr, long b) {
        if (b == 0) {
            long[][] tmp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    tmp[i][j] = 1;
                }
            }
            return tmp;
        }
        if(b==1)
            return arr;

        // 홀일떄.. divide 하고 b-1 상태로 짝수로 만듦.
        if (b % 2 == 1) {
            long[][] tmp = divide(arr, b - 1);
            return square(arr, tmp);
        }
        // 짝수일때.. divide 도 계속 짝수로.
        else {
            long[][] tmp = divide(arr, b / 2);
            return square(tmp, tmp);
        }

    }
    public static long[][] square(long[][] arr, long[][] arr2) {
    long ans[][]=new long[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                long tmp=0;
                for (int k = 0; k <n ; k++) {
                    tmp+=arr[i][k]*arr2[k][j]%1000; // 일반적인 행렬 곱셈 원리.
                }
                ans[i][j]=tmp%1000;
            }
        }
        return ans;
    }
    public static void print(long arr[][])
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] % 1000 +" ");
            }
            System.out.println();
        }
    }
}

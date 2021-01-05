package Alone.bruteForce;

import java.util.Scanner;

public class Build {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); // 사람 수
        sc.nextLine();
        int build[][]=new int[n][n];
        for (int i = 0; i <n ; i++) {
            String str[]=sc.nextLine().split(" ");
                build[i][0]=Integer.parseInt(str[0]);
                build[i][1]=Integer.parseInt(str[1]);
        }
        int ans[]=bodyCheck(build,n);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
    static int[] bodyCheck(int arr[][],int n)
    {
        int rank[]=new int[n]; // cnt 처럼 쓰는 배열.

        for (int i = 0; i <n ; i++) {
            int creteria_kg=arr[i][0];
            int creteria_cm=arr[i][1];
            for (int j = 0; j < n; j++) {
                if(creteria_kg>arr[j][0] && creteria_cm>arr[j][1])
                    rank[j]++;

            }
        }
        for (int i = 0; i <rank.length ; i++) {
            rank[i]++;
        }

        return rank;
    }
}

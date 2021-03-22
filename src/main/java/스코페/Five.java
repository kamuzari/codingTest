package 스코페;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int map[][]=new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j <n+1 ; j++) {
               map[i][j]=sc.nextInt();
            }
        }

        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                map[i][j]+=Math.max(map[i-1][j],map[i][j-1]);
            }
        }

        System.out.println(map[m][n]);
    }
}

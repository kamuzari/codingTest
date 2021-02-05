package Thur_Sunday_aWeek_Al.Random2;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
    static int INF= (int)1e9;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix =new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            Arrays.fill(matrix[i],INF);
        }

        for (int i = 0; i < n+1; i++) {
            matrix[i][i]=0;
            matrix[i][0]=0;
        }

        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(matrix[a][b]!=INF) { // 이미 들어간 값이라면..
                matrix[a][b]= matrix[a][b] > c ? c : matrix[a][b];
            }
            else
            {
                matrix[a][b]=c;
            }
        }

        //=======================

        // 2 -> 4  2-[1,2,3,4,5]-[1]-1
        for (int k =1; k <n+1 ; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    matrix[i][j]=Math.min(matrix[i][k]+matrix[k][j],matrix[i][j]);
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j =1; j < n+1; j++) {
                if(matrix[i][j]==INF)
                    System.out.print(0+" ");
                else
                    System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

package oneDay_twoSol.Greedy2.InBook.basic;

import java.util.Arrays;
import java.util.Scanner;

public class numberCardGame {
    static int card[][];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        card=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                card[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            Arrays.sort(card[i]);
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            if(max<card[i][0])
            {
                max=card[i][0];
            }
        }
        System.out.println(max);
    }
}
/*
3 3
3 1 2
4 1 4
2 2 2

2 4
7 3 1 8
3 3 3 4
*/

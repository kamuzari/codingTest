package oneDay_twoSol.shortestDIstance.InBook;

import java.util.Arrays;
import java.util.Scanner;

public class promisingCity {
    static int n, m;
    static int adjMatirx[][];
    static final int INF=(int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adjMatirx=new int[n+1][n+1];
        for (int i = 1; i <n+1 ; i++) {
            Arrays.fill(adjMatirx[i],INF);
        }
        for (int i = 1; i < m+1; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adjMatirx[a][b]=1;
            adjMatirx[b][a]=1;
        }
        for (int i = 1; i < n+1; i++) {
            adjMatirx[i][i]=0;
            adjMatirx[i][0]=0;
        }

        for (int i = 1; i <n+1 ; i++) {
            System.out.println(Arrays.toString(adjMatirx[i]));
        }

        int x=sc.nextInt();
        int k=sc.nextInt();

        for (int a = 1; a < n+1; a++) {
            for (int b = 1; b < n+1; b++) {
                for (int c = 1; c < n+1; c++) {
                    if(b!=c)
                        adjMatirx[b][c]=Math.min(adjMatirx[b][a]+adjMatirx[a][c],adjMatirx[b][c]);
                }
            }
        }
        for (int i = 1; i <n+1 ; i++) {
            System.out.println(Arrays.toString(adjMatirx[i]));
        }

        System.out.println(adjMatirx[1][k]+adjMatirx[k][x]);

    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
* */

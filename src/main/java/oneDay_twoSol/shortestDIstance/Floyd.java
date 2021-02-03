package oneDay_twoSol.shortestDIstance;

import java.util.Arrays;
import java.util.Scanner;
/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
*/
public class Floyd {
    static final int INF=(int) 1e9;
    static int adjMatrix[][];
    static int v,e;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();

        adjMatrix=new int[v+1][v+1];
        for (int i = 1; i < v+1; i++) {
            Arrays.fill(adjMatrix[i],INF);
        }

        for (int i = 1; i <v+1 ; i++) {
            adjMatrix[i][i]=0;
            adjMatrix[i][0]=0;
        }
        for (int i = 0; i < e; i++) {
            adjMatrix[sc.nextInt()][sc.nextInt()]= sc.nextInt();
        }

        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                for (int k = 1; k < v+1; k++) {
                    if(j!=k)
                        adjMatrix[j][k]=Math.min(adjMatrix[j][k],adjMatrix[j][i]+adjMatrix[i][k]);
                }
            }
        }

        for (int i = 1; i < v+1; i++) {
            System.out.println(Arrays.toString(adjMatrix[i]));
        }
    }
}

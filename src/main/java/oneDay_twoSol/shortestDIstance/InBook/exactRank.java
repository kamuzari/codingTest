package oneDay_twoSol.shortestDIstance.InBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exactRank {  // Floyd 응용
    static int n,m,cnt;
    static ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int INF=(int)1e9;
        int[][] vertax =new int[n+1][n+1];
        for (int i = 1; i <n+1 ; i++) {
            Arrays.fill(vertax[i],INF);
        }
        for (int i = 1; i <n+1 ; i++) {
            vertax[i][i]=0;
            vertax[i][0]=0;
        }
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            vertax[a][b]=1;
        }

        // 한노드가 내가 가거나 나에게 오는 경로가 정점의 수 만큼 있으면 순위를 매길수 있다.
        //  누가 나보다 위에 몇명이 있고 누가 나보다 밑에있는지를 알 수 있으므로.

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i <n+1 ; i++) {
                for (int j = 1; j < n+1; j++) {
                    vertax[i][j]=Math.min(vertax[i][k]+vertax[k][j],vertax[i][j]);
                }
            }
        }
        print(vertax);
        //나에게 오는 노드가 있으면 나보다 낮은 순위 내가 가는 경로가 있으면 나보다 높은 순위
        int ans=0;
        for (int i = 1; i < n+1; i++) {
            cnt=0;
            for (int j = 1; j < n+1; j++) {
                if(vertax[i][j]!=INF || vertax[j][i]!=INF) // 내가 다른 애보다 작거나 혹은 나보다 작은애가 있거나.
                    cnt++;
            }
            if(cnt==n)
                ans++;
        }
        System.out.println(ans);


    }
    static void print(int arr[][])
    {
        for (int i = 1; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("====end====");

    }
    /*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
    */
}

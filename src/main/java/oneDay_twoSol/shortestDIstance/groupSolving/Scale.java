package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {
    static int INF = (int) 1e9;
    // 일정한 무게가 아닌 서로를 대상으로 누가 제일 큰지 작은지를 결정하는 순위를 정하는 문제이다.
    /*
    3개의 물건중에 이런 표현이 가능하다면
    1>2 ,2>3
    1 > 2 > 3 으로 1이 제일 큰것을 알 수있다.
    이것을 그래프 적으로 표현하면면

    3번에서 2번으로 갈수 있고 2번에서 1번으로 갈 수 있는 것이다. 즉 3번 정점을 기준으로 보자면 3번에서 1번으로 가는 점은 초기에 없었지만
    플로이드 와샬을 이용한다면 3번에 1번으로 가는 최단거리 값이 갱신될 것이다.
    사이클 조건이랑 비슷하게
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int matrix[][] = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(matrix[i], INF);
        }
        for (int i = 0; i <n+1 ; i++) {
            matrix[i][i]=0;
            matrix[i][0]=0;
        }
        for (int i = 0; i < m; i++) {
            matrix[sc.nextInt()][sc.nextInt()] = 1;
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            System.out.println( Arrays.toString(matrix[i]));
        }
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                if (i!=j &&(matrix[i][j] != INF || matrix[j][i] != INF))
                    cnt++;
            }
            System.out.println(n-cnt-1);
        }
    }
}

package thisCodingTest.ShorthestPath.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExactRank {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int path[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(path[i], INF);
            path[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            path[a][b] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) continue;
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }
        int ans=0;


        for (int i = 1; i < n+1; i++) {
            System.out.println(Arrays.toString(path[i]));
        }
        System.out.println();
        for (int i = 1; i < n+1; i++) {
            int cnt=0;
            for (int j = 1; j < n+1; j++) {
                if(path[i][j]!=INF || path[j][i]!=INF)
                    cnt++;
            }
            if(cnt==n)
                ans++;
        }
        System.out.println(ans);

    }
}

   /*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
path Table
[0, 0, 2, 1000000000, 2, 1, 3]
[0, 1000000000, 0, 1000000000, 1000000000, 1000000000, 1000000000]
[0, 1000000000, 2, 0, 1, 1000000000, 2]
[0, 1000000000, 1, 1000000000, 0, 1000000000, 1]
[0, 1000000000, 1, 1000000000, 1, 0, 2]
[0, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 0]
    */

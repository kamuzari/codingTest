package thisCodingTest.ShorthestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyed {
    static final int INF=(int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int graph[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(graph[i],INF);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a][b] = w;
        }

        for (int k = 1; k <n+1; k++) {
            for (int i = 1; i <n+1; i++) {
                for (int j = 1; j <n+1; j++) {
                    if(i==j) continue;
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}

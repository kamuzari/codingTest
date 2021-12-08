package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404_Floyd {

    static final int INF = (int) 1e9;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        initialMapArrays(n);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[from][to] = Math.min(map[from][to], weight);
        }

        doFloyd(n);
        printTwoDemensionArrays(map);
    }

    private static void doFloyd(int n) {
        for (int middlePoint = 1; middlePoint <= n; middlePoint++) {
            for (int current = 1; current <= n; current++) {
                for (int target = 1; target <= n; target++) {
                    map[current][target] = Math.min(map[current][target],
                        map[current][middlePoint] + map[middlePoint][target]);
                }
            }
        }
    }

    private static void printTwoDemensionArrays(int map[][]) {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initialMapArrays(int n) {
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
    }

}

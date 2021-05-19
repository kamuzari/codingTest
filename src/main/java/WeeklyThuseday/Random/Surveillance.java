package WeeklyThuseday.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Surveillance {
    static class Node {
        int y, x, number;

        public Node(int y, int x, int number) {
            this.y = y;
            this.x = x;
            this.number = number;
        }
    }

    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] office;
    static ArrayList<Node> cctv;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        office = new int[n][m];
        cctv = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(str[j]);
                if (office[i][j] > 0 && office[i][j] <= 5)
                    cctv.add(new Node(i, j, office[i][j]));
            }
        }

        dfs(0, office);
        System.out.println(ans);
    }

    static void dfs(int cctvNumber, int middle_ans[][]) {
        int[][] visited = new int[n][m];
        if (cctvNumber == cctv.size()) {
            // cctv가 아무것도 없음.
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (middle_ans[i][j] == 0) {
                        temp++;
                    }
                }
            }
            if (temp < ans) {
                ans = temp;
            }
        } else {
            Node node = cctv.get(cctvNumber);
            int number = node.number;
            int y = node.y;
            int x = node.x;

            switch (number) {
                case 1:
                    // 회전 4가지 방향.
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(middle_ans[j], m);
                        }
                        detect(visited, y, x, i);
                        dfs(cctvNumber + 1, visited);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(middle_ans[j], m);
                        }
                        detect(visited, y, x, i);
                        detect(visited, y, x, i + 2);
                        dfs(cctvNumber + 1, visited);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(middle_ans[j], m);
                        }
                        detect(visited, y, x, i);
                        detect(visited, y, x, (i + 1) % 4);
                        dfs(cctvNumber + 1, visited);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(middle_ans[j], m);
                        }
                        detect(visited, y, x, i);
                        detect(visited, y, x, (i + 1) % 4);
                        detect(visited, y, x, (i + 2) % 4);
                        dfs(cctvNumber + 1, visited);
                    }
                    break;
                case 5:
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(middle_ans[j], m);
                    }
                    detect(visited, y, x, 0);
                    detect(visited, y, x, 1);
                    detect(visited, y, x, 2);
                    detect(visited, y, x, 3);
                    dfs(cctvNumber + 1, visited);
                    break;
            }
        }
    }

    static void detect(int[][] visited, int y, int x, int direction) {
        // 6일때 벽.
        switch (direction) {
            case 0: // 왼쪽 <--
                for (int k = x; k >= 0; k--) {
                    if (office[y][k] == 6) {
                        break;
                    }
                    visited[y][k] = 7;
                }
                break;

            case 1: // 위쪽
                for (int k = y; k >= 0; k--) {
                    if (office[k][x] == 6) {
                        break;
                    }
                    visited[k][x] = 7;
                }
                break;
            case 2: // 오른쪽
                for (int k = x; k < m; k++) {
                    if (office[y][k] == 6) {
                        break;
                    }
                    visited[y][k] = 7;
                }
                break;
            case 3: // 아래
                for (int k = y; k < n; k++) {
                    if (office[k][x] == 6) {
                        break;
                    }
                    visited[k][x] = 7;
                }
                break;
        }
    }
}

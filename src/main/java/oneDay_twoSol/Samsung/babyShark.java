package oneDay_twoSol.Samsung;

import java.util.*;

public class babyShark {
    static int n, map[][], dp[][];

    static class Node {
        private int y, x, d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }


        static int level = 2;
        static int exp = 0;
        static int dy[] = {-1, 1, 0, 0};
        static int dx[] = {0, 0, -1, 1};
        static int INF = (int) 1e9;

        static int dfs(int y, int x) {
            int ans = 0;
            int level = 2, exp = 2;
            Node posit = new Node(y, x, 0);
            do {
                boolean[][] visited = new boolean[n][n]; // 방문을 굳이 해야할까..?
                Queue<Node> q = new LinkedList<>();
                visited[posit.y][posit.x] = true;
                q.add(new Node(posit.y, posit.x, 0));
                posit.d = INF; //초기화.
                //=========== 최단 거리의 상어 발견. 로직
                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    if (cur.d > posit.d) break; //크면 볼필요 없이 ..
                    if (map[cur.y][cur.x] > level) continue; // 이동 불가 (레벨이 높은 상어)
                    if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < level) {
                        // eat
                        if (cur.d < posit.d) {
                            posit = cur;
                        } else if (posit.d == cur.d) {
                            if (posit.y > cur.y) {
                                posit = cur;
                            } else if (cur.y == posit.y && cur.x < posit.x) {
                                posit = cur;
                            }
                        }
                        continue;
                    }
                    for (int i = 0; i < 4; i++) {
                        int ty = cur.y + dy[i];
                        int tx = cur.x + dx[i];
                        if (ty >= 0 && tx >= 0 && ty < n && tx < n) {
                            if (!visited[ty][tx]) {
                                visited[ty][tx] = true;
                                q.add(new Node(ty, tx, cur.d + 1));
                            }
                        }
                    }
                }
                //=======================================
                if (posit.d != INF) {
                    ans += posit.d;
                    --exp;
                    if (exp == 0) {
                        level++;
                        exp = level;
                    }
                    map[posit.y][posit.x] = 0;
                }
            } while (posit.d != INF);

            return ans;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int y = 0, x = 0;
            n = sc.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = sc.nextInt();
                    if (a == 9) {
                        y = i;
                        x = j;
                        map[i][j] = 0;
                    } else
                        map[i][j] = a;
                }
            }

      /*  int cnt = 0;// 이동칸.(seconds)
        // 가장 왼쪽에 있는거 어떻게 먹을까?
        PriorityQueue<Node> q = new PriorityQueue<>();
        int tempCnt = 0;
        while (!q.isEmpty()) {
            Node shark_posit = q.poll();
            for (int i = 0; i < 4; i++) {
                int ty = shark_posit.y + dy[i];
                int tx = shark_posit.x + dx[i];
                if (ty >= 0 && tx >= 0 && ty < n && tx < n) {
                    if (map[ty][tx] == 0 || (map[ty][tx] > level))
                    {
                        cnt++;
                        continue;
                    }
                    else if (map[ty][tx] == level) {
                        cnt++;
                    } else if (map[ty][tx] < level) {
                        exp++;
                        if (exp == level) {
                            level++;
                            exp = 0;
                        }
                    } else {
                        cnt++;
                    }
                }
            }
        }*/

            System.out.println(dfs(y, x));

        }


    }
}

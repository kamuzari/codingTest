package oneDay_twoSol.graphTheory.Grouping;

import java.util.*;

public class BridgeMaking2 {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n, m, map[][];
    static boolean visited[][];
    static int area = 1;
    static int parent[];
    static Queue<qNode> q = new LinkedList<>();
    static PriorityQueue<pqNode> pq = new PriorityQueue<>();

    static class qNode implements Comparable<qNode> {
        int y, x, area;

        public qNode(int y, int x, int area) {
            this.y = y;
            this.x = x;
            this.area = area;  // area 이면서 pq에서는 cost가 된다.
        }

        @Override
        public int compareTo(qNode o) {
            return this.area - o.area;
        }
    }

    static class pqNode implements Comparable<pqNode> {
        int v1, v2, cost;

        public pqNode(int v1, int x, int cost) {
            this.v1 = v1;
            this.v2 = x;
            this.cost = cost;  // area 이면서 pq에서는 cost가 된다.
        }

        @Override
        public int compareTo(pqNode o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = area;
                    dfs(i, j);
                    area++;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        bfs();
        parent = new int[area];
        for (int i = 1; i < area; i++) {
            parent[i] = i;
        }
        int min_dist = 0;
        while (!pq.isEmpty()) { // pq 순회 아무렇게 출력 됨. 정렬된 순서가 아님!!! 우선순위 큐 순회 조심..
            pqNode cur = pq.poll();
//            System.out.println(find(cur.v1)+" "+find(cur.v2));
            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                min_dist += cur.cost;
            }
        }
//        System.out.println("자기 자신과 부모노드가 같은 인덱스라면 모두 연결이 x.");

        if (check())
            System.out.println(min_dist);
        else
            System.out.println(-1);


    }
    static boolean check()
    {
        int cnt=0;
        for (int i = 1; i < area; i++) {
            if(parent[i]==i)
                cnt++;
        }
        if(cnt==1)
        {
            return true;
        }
        else
            return false;
    }

    // 영역 나누기
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        q.add(new qNode(y, x, area));
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (!visited[ny][nx] && map[ny][nx] != 0) {
                    map[ny][nx] = area;
                    dfs(ny, nx);
                }
            }
        }
    }

    // 모든 distance 들을 일단 MST의 쓰일 pq에 저장.
    static void bfs() {
        while (!q.isEmpty()) {
            qNode cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int dist = 0;
                while (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    // 바다가 아니면
                    if (map[ny][nx] != 0) { //
                        // 바다가 아니고 && 나와 같은 영역이 아니면 ! 엣지 추가.
                        if (cur.area != map[ny][nx]) {
                            if (dist != 1)
                                pq.add(new pqNode(map[cur.y][cur.x], map[ny][nx], dist));
                        }
                        break;
                    }
                    ny += dy[i];
                    nx += dx[i];
                    dist++;
                }
            }
        }
    }

    // MST 도구 UNION-FIND
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else
            parent[a] = b;
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}
/*
8 8
0 0 0 1 1 1 1 0
0 1 1 1 1 0 1 0
0 1 0 1 1 1 0 0
0 1 0 0 0 1 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 1 0 0
0 1 1 1 0 0 0 0
0 1 0 0 0 1 0 0


3 7
1 0 0 1 0 0 1
1 0 0 1 0 0 1
1 1 1 1 0 0 0

9 6
0 0 0 0 1 0
0 0 0 0 0 0
0 1 0 0 0 1
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 1 1
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 0 0

10 10
0 0 0 1 1 0 0 0 0 0
0 0 0 1 0 0 0 0 0 1
0 0 0 1 1 0 0 0 0 0
0 0 0 1 1 0 0 0 0 0
1 0 0 1 0 0 0 0 0 1
0 0 0 1 1 0 0 0 0 0
0 0 0 1 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 0 1 1 1 1 0 0 1 1
*/

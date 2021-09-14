package tues_thurs_sat._202109._20210914;

import java.util.*;

public class LandMove {

    int dy[] = {-1, 1, 0, 0};
    int dx[] = {0, 0, -1, 1};
    int parent[];
    int check[][];
    int len;
    List<Node> list;

    public static void main(String[] args) {
        LandMove landMove = new LandMove();
        int land[][]={
                {1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
        };
        landMove.solution(land,3);
    }
    class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    class Node implements Comparable<Node> {
        int v1, v2, diff;

        public Node(int v1, int v2, int diff) {
            this.v1 = v1;
            this.v2 = v2;
            this.diff = diff;
        }

        @Override
        public int compareTo(Node o1) {
            return this.diff-o1.diff;
        }
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        len = land.length;
        check = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(check[i], -1);
        }
        list = new ArrayList<>();
        int area = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (check[i][j] == -1) {
                    area++;
                    LinkedList<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));
                    check[i][j] = area;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = cur.y + dy[dir];
                            int nx = cur.x + dx[dir];
                            if (indexOutOf(ny, nx) || check[ny][nx] >= 0 ||
                                    Math.abs(land[ny][nx] - land[cur.y][cur.x]) > height) {
                                continue;
                            }
                            check[ny][nx] = area;
                            q.add(new Pair(ny, nx));
                        }
                    }
                }
            }
        }
        parent = new int[area + 1];
        for (int i = 0; i < area + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if (indexOutOf(ny, nx)) continue;
                    if (check[i][j] == check[ny][nx]) continue;
                    int diff = Math.abs(land[i][j] - land[ny][nx]);
                    list.add(new Node(check[i][j], check[ny][nx], diff));
                }
            }
        }

        Collections.sort(list);
        int cnt=0;

        for(Node node: list){
            if(find(node.v1)!=find(node.v2)) {
                union(node.v1,node.v2);
                answer+=node.diff;
            }
            if(cnt==area-1)break;
        }
        System.out.println(answer);
        return answer;
    }

    public boolean indexOutOf(int y, int x) {
        return y < 0 || x < 0 || y >= len || x >= len;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else if (a > b) {
            parent[a] = b;
        }
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}

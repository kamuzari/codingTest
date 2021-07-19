package AL_CS_STUDY.Weekly29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SharkMiddleSchool {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] v;

    static class Node {
        private int y, x, size, rainbow;
        private List<Node> list;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int size, int rainbow, List<Node> list) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.rainbow = rainbow;
            this.list = new LinkedList<>();
            this.list.addAll(list);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", size=" + size +
                    ", rainbow=" + rainbow +
                    ", list=" + list +
                    '}';
        }
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            Node max = null;
            v = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > -1&& !v[i][j]) {
                        Node cur = bfs(i, j);
                        System.out.println(cur);
                        if (max == null)
                            max = cur;
                        else if (max != null) {
                            if (cur.size > max.size)
                                max = cur;
                            else if (cur.size == max.size) {
                                if (cur.rainbow > max.rainbow) {
                                    max = cur;
                                } else if (cur.rainbow == max.rainbow) {
                                    if (cur.y > max.y) {
                                        max = cur;
                                    } else if (cur.y == cur.y) ;
                                    {
                                        if (cur.x > max.x) {
                                            max = cur;
                                        }
                                    }

                                }

                            }
                        }
                    }
                }
            }
            if(max==null)
                break;
            else
            {
                List<Node> relatedDots = max.list;
                map[max.y][max.x]=-2;
                for (Node cur : relatedDots) {
                    map[cur.y][cur.x]=-2;
                }

                for (int j = 0; j < n; j++) {
                    for(int k=0; k<n; k++) {
                        for (int i = n - 1; i > 0; i--) {
                            if (map[i - 1][j] <=-1 || map[i][j] == -1)
                                continue;
                            map[i][j] = map[i - 1][j];
                            map[i-1][j]=-2;
                            if (i == 1)
                                map[i-1][j] = -2;
                        }
                    }
                }
            }
        }

    }

    public static Node bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> rainbowList = new LinkedList<>();
        int value = map[y][x];
        v[y][x] = true;

        List<Node> relatedDot = new LinkedList<>();
        if (value == 0) {
            rainbowList.add(new Node(y, x));
        }
        q.offer(new Node(y, x));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == -1 || map[ny][nx] == -2 || v[ny][nx])
                    continue;
                if (map[ny][nx] == value || map[ny][nx] == 0) {
                    relatedDot.add(new Node(ny, nx));
                    v[ny][nx] = true;

                    if (map[ny][nx] == 0) {
                        rainbowList.add(new Node(ny, nx));
                    }
                    q.offer(new Node(ny, nx));
                }
            }

        }
        Node cur = new Node(y, x, relatedDot.size() + 1, rainbowList.size(), relatedDot);
        relatedDot.clear();
        for (Node node : rainbowList) {
            v[node.y][node.x] = false;
        }
        rainbowList.clear();

        return cur;
    }
}

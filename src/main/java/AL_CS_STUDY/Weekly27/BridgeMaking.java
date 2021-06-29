package AL_CS_STUDY.Weekly27;

import java.util.*;
import java.io.*;

public class BridgeMaking {

    private static int m;
    private static int n;
    private static int map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    private static boolean[][] v;
    private static int parent[];
    private static PriorityQueue<Bridge> sortByDist=new PriorityQueue<>();
    private static Queue<Node> Area=new LinkedList<>();
    static class Bridge implements Comparable<Bridge>
    {
        @Override
        public String toString() {
            return "Bridge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", dist=" + dist +
                    '}';
        }

        private int v1,v2,dist;

        public Bridge(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Bridge bridge) {
            return dist-bridge.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    AreaDivide(cnt, i, j);
                    cnt++;
                }
            }
        }
        
        bridgeMake();
        parent=new int[cnt];
        for (int i = 1; i <cnt ; i++) {
            parent[i]=i;
        }
        int answer=0;
        while (!sortByDist.isEmpty())
        {
            Bridge bridge = sortByDist.poll();

            if(find(bridge.v1)!=find( bridge.v2))
            {
                union(bridge.v1,bridge.v2);
                answer+=bridge.dist;
            }
        }
        for (int i = 1; i < cnt; i++) {
            find(i);
        }
        // 모든 점들이 연결되있는지 판단.
        int criteria = parent[1];
        for (int i = 2; i < cnt; i++) {
            if(criteria==parent[i])
                continue;
            System.out.println(-1);
            return;
        }
        System.out.println(answer==0?-1:answer);
    }

    private static void bridgeMake() {
        while (!Area.isEmpty())
        {
            Node cur = Area.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int dist=0;
                while (ny>=0 && ny<n && nx>=0 && nx<m)
                {
                    if(map[ny][nx]!=0)
                    {
                        if(map[cur.y][cur.x]!=map[ny][nx])
                        {
                            if(dist!=1)
                            {
                                sortByDist.offer(new Bridge(map[cur.y][cur.x],map[ny][nx],dist));
                            }
                        }
                        break;
                    }
                    ny+=dy[i];
                    nx+=dx[i];
                    dist++;
                }
            }
        }
    }

    private static void AreaDivide(int number, int y, int x) {
        Queue<Node> q = new LinkedList<>();
        v[y][x] = true;
        map[y][x]=number;
        Area.add(new Node(y,x));
        q.offer(new Node(y,x));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if(ny<0 || nx<0 ||ny>=n || nx>=m || v[ny][nx] || map[ny][nx]>-1)
                    continue;

                v[ny][nx]=true;
                map[ny][nx]=number;
                q.offer(new Node(ny,nx));
                Area.add(new Node(ny,nx));
            }

        }
    }

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static void union(int a,int b)
    {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else
            parent[a] = b;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
/*
반례 : 모든 점이 같은 부모를 가져야 한다.
8 8
0 0 0 1 1 1 1 0
0 1 1 1 1 0 1 0
0 1 0 1 1 1 0 0
0 1 0 0 0 1 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 1 0 0
0 1 1 1 0 0 0 0
0 1 0 0 0 1 0 0

6 10
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 1 0 0 0
1 0 1 0 1 0 1 0 0 1
1 0 1 1 1 0 1 0 0 1
0 0 0 0 0 0 0 0 0 1
1 1 0 1 1 1 1 1 0 1



*/


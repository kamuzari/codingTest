package tues_thurs_sat._20210811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MiroEscape {
    public static void main(String[] args) {
        MiroEscape miroEscape=new MiroEscape()  ;
        miroEscape.solution(4,1,4,new int[][]{
            {1,2,1},
            {3,2,1},
            {2,4,1},
        },new int[]{2,3});
    }

    class Node implements Comparable<Node>{
        private int dist, idx,state;

        public Node(int dist, int idx, int state) {
            this.dist = dist;
            this.idx = idx;
            this.state=state;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + dist +
                    ", weight=" + idx +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return dist -o.dist;
        }
    }

    static class pair{
        int x,y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int TRAP_MAX=10;
    static final int INF=(int)1e9;
    static int dist[][],trapIdx[];
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        dist=new int[n+1][1 << TRAP_MAX];
        List<pair> adj[]=new List[n+1];
        List<pair> prevAdj[]=new List[n+1];
        trapIdx=new int[n+1];

        for (int i = 1; i <=n ; i++) {
            Arrays.fill(dist[i],INF);
        }

        for (int i = 1; i <= n; i++) {
            adj[i]=new ArrayList<>();
            prevAdj[i]=new ArrayList<>();
        }

        Arrays.fill(trapIdx,-1);
        for (int i = 0; i < traps.length; i++) {
            trapIdx[traps[i]]=i; // 트랩의 번호(값)를 인덱스로 하여 2번은 0번째에 들어있다.
        }
        for (int i = 0; i < roads.length; i++) {
            int v1=roads[i][0];
            int v2=roads[i][1];
            int dist=roads[i][2];
            adj[v1].add(new pair(v2,dist));
            prevAdj[v2].add(new pair(v1,dist));
        }

        dist[start][0]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(dist[start][0],start,0));
        while (!pq.isEmpty())
        {
            Node cur = pq.poll();

            if(cur.idx==end)
                return cur.dist;
            if(dist[cur.idx][cur.state]!=cur.dist)
                continue;

            for (pair next : adj[cur.idx]) {
                int rev=0;
                if(trapIdx[cur.idx]!=-1 && bitMask(cur.state,cur.idx))
                    rev^=1;
                if(trapIdx[next.x]!=-1 && bitMask(cur.state,next.x))
                    rev^=1;
                if(rev!=0)
                    continue;

                int nextState=cur.state;
                if(trapIdx[next.x]!=-1)
                {
                    nextState^=(1<<trapIdx[next.x]);
                }
                if(dist[next.x][nextState]> next.y+cur.dist)
                {
                    dist[next.x][nextState]= next.y+cur.dist;
                    pq.offer(new Node(dist[next.x][nextState],next.x,nextState));
                }
            }

            for (pair next : prevAdj[cur.idx]) {
                int rev=0;

                if(trapIdx[cur.idx]!=-1 && bitMask(cur.state,cur.idx))
                    rev^=1;
                if(trapIdx[next.x]!=-1 && bitMask(cur.state,next.x))
                    rev^=1;
                if(rev!=1)
                    continue;

                int nextState=cur.state;
                if(trapIdx[next.x]!=-1)
                {
                    nextState^=(1<<trapIdx[next.x]);
                }
                if(dist[next.x][nextState]> next.y+cur.dist)
                {
                    dist[next.x][nextState]= next.y+cur.dist;
                    pq.offer(new Node(dist[next.x][nextState],next.x,nextState));
                }
            }
        }
        return -1;
    }
    boolean bitMask(int state, int idx){
        return ((1 << trapIdx[idx]) & state) != 0;
    }
}

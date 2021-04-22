package tues_thurs_sat._20210422;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestPath {

    public static void main(String[] args) {
        int map[][]={
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };
        System.out.println(solution(map));

    }
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static class Node{
        int y, x, dist;
        public Node(int y,int x,int dist)
        {
            this.y=y;
            this.x=x;
            this.dist=dist;
        }
    }
    public static int solution(int[][] maps) {
        int answer = bfs(0,0,maps);
        return answer;
    }
    public static int bfs(int y,int x,int map[][])
    {
        Queue<Node> q=new LinkedList<>();
        int n=map.length;
        int m=map[0].length;
        int temp[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(temp[i],-1);
        }
        temp[0][0]=1;
        q.offer(new Node(y,x,1));
        while(!q.isEmpty())
        {
            Node cur=q.poll();
            if(cur.y==4 && cur.x==4)
            {
                return cur.dist;
            }

            for(int i=0; i<4; i++)
            {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<n && nx<n)
                {
                    if(map[ny][nx]==1 && temp[ny][nx]==-1 ) {
                        temp[ny][nx] = cur.dist + 1;
                        q.offer(new Node(ny, nx, cur.dist + 1));
                    }
                }
            }
        }
        return -1;
    }
}

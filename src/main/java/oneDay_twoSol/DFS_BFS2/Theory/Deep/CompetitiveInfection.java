package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.*;

public class CompetitiveInfection {
    static int n,k,s,y,x,map[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};

    static class Node implements Comparable<Node> {
        int idx;
        int y,x;
        int time;

        public Node(int idx, int y, int x,int time) {
            this.idx = idx;
            this.y = y;
            this.x = x;
            this.time=time;
        }


        @Override
        public int compareTo(Node o) {
            return idx-o.idx;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        k=sc.nextInt();
        LinkedList<Node> q=new LinkedList<>();
        map=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]!=0)
                {
                    q.offer(new Node(map[i][j],i,j,0));
                }
            }
        }
        Collections.sort(q);
        s=sc.nextInt();
        y=sc.nextInt();
        x=sc.nextInt();
        while (!q.isEmpty())
        {
            Node cur=q.poll();
            if(cur.time==s)
            {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny=cur.y+dy[i];
                int nx=cur.x+dx[i];
                if(ny>=0 && nx>=0 && ny<n && nx<n)
                {
                    if(map[ny][nx]==0)
                    {
                        map[ny][nx]=cur.idx;
                        q.offer(new Node(cur.idx,ny,nx, cur.time+1));
                    }
                }
            }
        }

        System.out.println(map[y-1][x-1]);



    }

}

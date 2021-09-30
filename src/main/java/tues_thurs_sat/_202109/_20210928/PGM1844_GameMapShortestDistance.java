package tues_thurs_sat._202109._20210928;
import java.util.*;
public class PGM1844_GameMapShortestDistance {
    public static void main(String[] args) {
        PGM1844_GameMapShortestDistance p = new PGM1844_GameMapShortestDistance();
        int solution = p.solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        });
        System.out.println(solution);
    }
    class Node{
        private int y,x,dist;
        public Node(int y,int x , int dist){
            this.y=y;
            this.x=x;
            this.dist=dist;
        }
    }
    int dy[]={-1,1,0,0};
    int dx[]={0,0,-1,1};
    int n,m;
    public int solution(int[][] maps) {
        LinkedList<Node> q=new LinkedList<>();
        q.offer(new Node(0,0,1));
        n=maps.length;
        m=maps[0].length;
        int dist[][]=new int[n][m];
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.y==n-1 && cur.x==m-1){
                dist[0][0]=0;
                return cur.dist;
            }
            for(int i=0; i<4; i++){
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(indexOutOf(ny,nx) || maps[ny][nx]==0 || dist[ny][nx]!=0){
                    continue;
                }
                dist[ny][nx]=cur.dist+1;
                q.offer(new Node(ny,nx,cur.dist+1));
            }
        }

        return -1;
    }
    private boolean indexOutOf(int y,int x){
        return y<0 || x<0 || y>n-1 || x>m-1;
    }
}

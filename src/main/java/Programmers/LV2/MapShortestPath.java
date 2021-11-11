package Programmers.LV2;
import java.util.*;
/*
처음 발디딘 곳이 가장 빠르고 뒤에 오는 것은 거리만 커질 뿐..
*/
public class MapShortestPath {
    class Node{
        private int y,x,dist;
        public Node(int y,int x,int dist){
            this.y=y;
            this.x=x;
            this.dist=dist;
        }
    }
    int dy[]={-1,1,0,0};
    int dx[]={0,0,-1,1};
    public int solution(int[][] maps) {
        int n=maps.length;
        int m=maps[0].length;
        LinkedList<Node> q=new LinkedList<>();
        boolean v[][]=new boolean[n][m];
        q.offer(new Node(0,0,0));
        v[0][0]=true;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.y==n-1 && cur.x==m-1){
                return cur.dist+1;
            }
            for(int i=0; i<4; i++){
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(indexOutOf(ny,nx,n,m)) continue;
                if(v[ny][nx] || maps[ny][nx]==0) continue;
                v[ny][nx]=true;
                q.offer(new Node(ny,nx,cur.dist+1));
            }
        }
        return -1;
    }
    public boolean indexOutOf(int ny,int nx,int n,int m){
        return ny<0 || nx<0 || ny>n-1 || nx>m-1;
    }
}

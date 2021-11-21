package Programmers.LV2;

import java.util.*;
// 배열 왼쪽으로 붙이고 규칙 찾기.
public class TriangleSnail {
    int dy[]={1,0,-1};
    int dx[]={0,1,-1};
    class Node{
        private int y,x,dir;
        public Node(int y,int x,int dir){
            this.y=y;
            this.x=x;
            this.dir=dir;
        }
    }
    public int[] solution(int n) {
        int map[][]=new int [n][n];
        int cnt=drawSnail(n,map);
        int[] answer = new int[cnt-1];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++]=map[i][j];
            }
        }
        return answer;
    }
    public int drawSnail(int n,int map[][]){
        LinkedList<Node> q=new LinkedList<>();
        q.offer(new Node(0,0,0));
        int cnt=1;
        while(!q.isEmpty()){
            Node cur=q.poll();
            map[cur.y][cur.x]=cnt++;
            int ny=cur.y+dy[cur.dir];
            int nx=cur.x+dx[cur.dir];

            if(indexOutOf(ny,nx,n) || map[ny][nx]!=0){
                int nextDir=(cur.dir+1)%3;
                ny=cur.y+dy[nextDir];
                nx=cur.x+dx[nextDir];
                if(indexOutOf(ny,nx,n) || map[ny][nx]!=0){
                    continue;
                }
                q.offer(new Node(ny,nx,nextDir));
            }else{
                q.offer(new Node(ny,nx,cur.dir));
            }
        }
        return cnt;
    }
    public boolean indexOutOf(int ny,int nx,int n){
        return ny<0 || nx<0 || ny>n-1 || nx>n-1;
    }
}

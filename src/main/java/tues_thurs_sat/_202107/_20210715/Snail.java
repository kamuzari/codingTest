package tues_thurs_sat._20210715;

import java.util.*;
public class Snail {
    public static void main(String[] args) {
        System.out.println("solution(3) = " + solution(1));
    }
    static class Node{
        int y,x;
        public Node(int y,int x)
        {
            this.y=y;
            this.x=x;
        }
    }
    static int dy[]={1,0,-1};
    static int dx[]={0,1,-1};
    public static int[] solution(int n) {

        int[] answer = new int[(n*(n+1))/2];
        int tri[][]=new int[n+1][n+1];
        int number=1;
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(1,1));
        tri[1][1]=number++;
        int dir=0;
        while(!q.isEmpty())
        {
            Node cur=q.poll();
            int ny=dy[dir]+cur.y;
            int nx=dx[dir]+cur.x;
            if(ny>=1 && nx>=1 && ny<=n && nx<=n && tri[ny][nx]==0)
            {
                if(tri[ny][nx]==0)
                {
                    tri[ny][nx]=number++;
                    q.offer(new Node(ny,nx));
                }
            }
            else {
                dir=(dir+1)%3;
                ny=dy[dir]+cur.y;
                nx=dx[dir]+cur.x;
                if(!(ny>=1 && nx>=1 && ny<=n && nx<=n && tri[ny][nx]==0) || tri[ny][nx]!=0 )
                {
                    break;
                }
                tri[ny][nx]=number++;
                q.offer(new Node(ny,nx));
            }
        }

        int idx=0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                answer[idx++]=tri[i][j];
            }
        }
        return answer;
    }
}

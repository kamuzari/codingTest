package kakaoInternship;

import java.util.LinkedList;
import java.util.Queue;

public class RacewayConstruction {
    public static void main(String[] args) {

    }

    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};
    static class Node{
        private int y,x,dir,cost;

        public Node(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    ", cost=" + cost +
                    '}';
        }
    }
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int [][]map = board;
        int n = board.length;

        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(0,0,-1,0));
        map[0][0]=1;
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            if(cur.cost>answer)
            {
                continue;
            }
            if(cur.y==n-1 && cur.x==n-1)
            {
                System.out.println(cur);
                answer=Math.min(answer,cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<n && nx<n && board[ny][nx]!=1)
                {
                    int newCost=0;
                    if(cur.dir==-1 || cur.dir==i)
                    {
                       newCost=cur.cost+100;
                    }
                    else
                    {
                        newCost=cur.cost+600;
                    }

                    if(map[ny][nx]==0|| map[ny][nx]>=newCost)
                    {
                        map[ny][nx]=newCost;
                        q.add(new Node(ny,nx,i,newCost));
                    }
                }
            }
        }

        return answer;
    }



}

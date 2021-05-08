package ProgrammersKit.SummerIntern;

import java.util.LinkedList;
import java.util.Queue;

public class JumpAndTeleportation {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(TLE_solution(5));
        System.out.println(TLE_solution(6));
        System.out.println(TLE_solution(5000));
    }
    public static int solution(int n)
    {
        int answer=0;
        while (n!=0)
        {
            if(n%2==0)
            {
                n/=2;
            }
            else
            {
                n--;
                answer++;
            }
        }
        return answer;
    }
    static int dx[]={1,2};
    static class Node{
        int x,Consumption;

        public Node(int x, int consumption) {
            this.x = x;
            Consumption = consumption;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", Consumption=" + Consumption +
                    '}';
        }
    }
    public static int TLE_solution(int n) {
        if(n==1)
            return 1;
        int ans = 1;
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(1,1));
        while (!q.isEmpty())
        {
            Node cur = q.poll();
//            System.out.println(cur);
            if(cur.x==n)
            {
                return cur.Consumption-1;
            }
            for (int i = 0; i < 2; i++) {
                int nx;
                if(i==1)
                {
                    nx=cur.x*dx[i];
                    if(nx<=n)
                        q.offer(new Node(nx,cur.Consumption));
                }
                else
                {
                    nx=cur.x+dx[i];
                    if(nx<=n)
                        q.offer(new Node(nx, cur.Consumption+1));
                }

            }
        }
        return ans;
    }
}

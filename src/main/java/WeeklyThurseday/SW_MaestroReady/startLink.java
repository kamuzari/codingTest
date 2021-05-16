package WeeklyThurseday.SW_MaestroReady;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class startLink {
    static int F,S,G,U,D;
    static int dist[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        F=sc.nextInt(); // total
         S=sc.nextInt(); // current
         G=sc.nextInt(); // object
         U=sc.nextInt();
         D=sc.nextInt();
         dist=new int[F+1];
        int ans=bfs();
        if(ans==-1)
        {
            System.out.println("use the stairs");
        }
        else
            System.out.println(ans);

    }
    static int bfs()
    {
        Queue<Integer> q=new LinkedList<>();
        dist[S]=1; // dist[s]=0 으로 시작하면 틀린다.. 이유가 몰까..? 아 cur == G같으면 0이라서..?
        q.offer(S);
        while (!q.isEmpty())
        {
            int cur=q.poll();
            if(cur==G)
            {
                return dist[cur];
            }
            int up=cur+U;
            int down=cur-D;
            if(up>0 && up<=F && dist[up]==0)
            {
                dist[up]=dist[cur]+1;
                q.offer(up);
            }
            if(down>0 && down<=F && dist[down]==0)
            {
                dist[down]=dist[cur]+1;
                q.offer(down);
            }
        }
        return -1;
    }

}

package thisCodingTest.ShorthestPath.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697
public class HideAndSeek {
    static int dx[]={-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int subin=Integer.parseInt(st.nextToken());
        int sister=Integer.parseInt(st.nextToken());
        int dist[]=new int[100_001];

        Queue<Integer> q=new LinkedList<>();
        dist[subin]=1;
        q.offer(subin);

        while (!q.isEmpty())
        {
            int cur=q.poll();
            if(cur==sister)
            {
                System.out.println(dist[cur]-1);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx=0;
                if(i==2)
                {
                    nx=dx[i]*cur;
                }
                else
                {
                    nx=dx[i]+cur;
                }

                if(nx>=0 && nx<100_001)
                {
                    if(dist[nx]==0)
                    {
                        q.offer(nx);
                        dist[nx]=dist[cur]+1;
                    }
                }
            }
        }


    }
}

package thisCodingTest.ShorthestPath.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/13549
public class HideAndSeek3 {
    static int dx[]={2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int subin=Integer.parseInt(st.nextToken());
        int sister=Integer.parseInt(st.nextToken());
        int dist[]=new int[100_001];

        Queue<Integer> q=new LinkedList<>();
        q.offer(subin);
        Arrays.fill(dist,(int)1e9);
        dist[subin]=0;
        while (!q.isEmpty())
        {
            int cur=q.poll();
            if(cur==sister)
            {
                System.out.println(dist[cur]);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx=0;
                if(i==0)
                {
                    nx=dx[i]*cur;
                }
                else
                {
                    nx=dx[i]+cur;
                }

                if(nx>=0 && nx<100_001)
                {
                    if(dist[nx]>=dist[cur] && i==0 )
                    {
                        q.offer(nx);
                        dist[nx]=dist[cur];
                    }
                    else if(dist[nx]>=dist[cur]+1 )
                    {
                        q.offer(nx);
                        dist[nx]=dist[cur]+1;
                    }
                }
            }
        }
    }
}

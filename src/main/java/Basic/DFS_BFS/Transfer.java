package Basic.DFS_BFS;

import java.io.*;
import java.util.*;

public class Transfer {
    public static int dist[];
    public static  ArrayList<Integer> list[];
    public static final int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        list=new ArrayList[n+1+m+1];

        for (int i = 0; i < n+m+2; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int dummy=n+i;
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int node=Integer.parseInt(st.nextToken());
                list[dummy].add(node);
                list[node].add(dummy);
            }
        }

        dist=new int[n+m+2];
        Arrays.fill(dist,INF);

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        dist[1]=1;
        while (!q.isEmpty())
        {
            Integer cur = q.poll();
            if(cur==n)
                break;

            for (Integer node : list[cur]) {
                if(dist[node]>dist[cur]+1)
                {
                    if(node<=n)
                    {
                        dist[node]=dist[cur]+1;
                    }
                    else if(node>n)
                    {
                        dist[node]=dist[cur];
                    }
                    q.offer(node);
                }
            }
        }
        int answer=dist[n]==INF? -1:dist[n];
        System.out.println(answer);
    }
}

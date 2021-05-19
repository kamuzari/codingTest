package WeeklyThuseday._0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindingCityOnSpecificStreet {
    static int n, m, k, x;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        int dist[]=new int[n+1];
        Arrays.fill(dist,-1);
        Queue<Integer> q=new LinkedList<>();
        dist[x]=0;
        q.offer(x);
        while (!q.isEmpty())
        {
            Integer cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int next=list[cur].get(i);
                if(dist[next]==-1)
                {
                    dist[next]=dist[cur]+1;
                    q.offer(next);
                }
            }
        }
        boolean flag=false;
        for (int i = 1; i <=n ; i++) {
            if(dist[i]==k)
            {
                System.out.println(i);
                flag=true;
            }
        }
        if(!flag)
        {
            System.out.println(-1);
        }
    }
}

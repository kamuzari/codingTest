package Basic.DFS_BFS;

import java.io.*;
import java.util.*;

public class Transfer {
    public static int INF=Integer.MAX_VALUE;
    static int n, k, m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> hyper = new ArrayList<>();
        for(int i=0; i<=n+m+10; i++){
            hyper.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=m; i++){
            int dummy = n+i;
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++){
                int node = Integer.parseInt(st.nextToken());

                hyper.get(dummy).add(node);
                hyper.get(node).add(dummy);
            }
        }

        int d[] = new int[n+m+10];
        Arrays.fill(d, INF);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        d[1]=1;

        int step=0;
        while(!q.isEmpty()){
            int qSize = q.size();

            while(qSize-->0){
                int p = q.poll();

                if(p==n) break;

                for(int t: hyper.get(p)){
                    if(d[t]>d[p]+1){
                        if(p<=n) d[t] = d[p]+1;
                        else d[t]=d[p];
                        q.add(t);
                    }
                }
            }

            step++;
        }

        System.out.println(d[n]==INF? -1:d[n]); // 출력 방식 1
    }
}
